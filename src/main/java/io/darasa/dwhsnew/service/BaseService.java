package io.darasa.dwhsnew.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.darasa.dwhsnew.constants.ColumnName;
import io.darasa.dwhsnew.constants.Type;
import io.darasa.dwhsnew.dto.response.PageResponse;
import io.darasa.dwhsnew.exception.ElasticsearchException;
import io.darasa.dwhsnew.exception.InvalidRequestException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.document.Document;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.ScriptType;
import org.springframework.data.elasticsearch.core.query.UpdateQuery;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public abstract class BaseService {

    @Getter
    protected final Type type;

    @Autowired
    protected ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    protected ObjectMapper objectMapper;

    public static final String REMOVE_SCRIPT = "ctx._source.remove('%s')";


    public void save(String json) {
        try {
            String id = validateJsonAndGetId(json);
            if (id == null) {
                throw new InvalidRequestException("Id must not be null");
            }
            upsert(id, json);
            if (!elasticsearchTemplate.exists(id, getIndexCoordinates())) {
                throw new ElasticsearchException(type.getIndex());
            }

        } catch (InvalidRequestException e) {
            throw e;
        } catch (Exception e) {
            throw new ElasticsearchException(type.getIndex());
        }
    }

    public PageResponse getAll(int page, int size, List<Criteria> criterias) {
        if (page < 1) throw new InvalidRequestException("Page must be greater than 0");
        if (size < 1) throw new InvalidRequestException("Size must be greater than 0");

        if (!elasticsearchTemplate.indexOps(getIndexCoordinates()).exists()) {
            return PageResponse.builder().build();
        }
        if (criterias == null) {
            criterias = new ArrayList<>();
        }
        CriteriaQuery query = new CriteriaQuery(new Criteria().and(criterias.toArray(Criteria[]::new)))
                .setPageable(PageRequest.of(page - 1, size + 1));
        var resultPage = elasticsearchTemplate.search(query, Map.class, getIndexCoordinates());
        return PageResponse.builder()
                .records(resultPage.getSearchHits().stream()
                        .limit(size)
                        .map(SearchHit::getContent)
                        .map(this::getDtoMap)
                        .toList())
                .hasNext(resultPage.getSearchHits().size() > size)
                .size(Math.min(resultPage.getSearchHits().size(), size))
                .build();
    }

    private Map<String, Object> getDtoMap(Map map) {
        Map<String, Object> result = new HashMap<>();
        for (Object o : map.entrySet()) {
            if (o instanceof Map.Entry<?, ?> entry) {
                if (entry.getKey() instanceof String key) {
                    if (type.getFieldMap().containsKey(key)) {
                        result.put(key, entry.getValue());
                    }
                }
            }
        }
        return result;
    }

    private String validateJsonAndGetId(String json) {
        JsonNode jsonNode;
        try {
            jsonNode = objectMapper.readTree(json);
        } catch (JsonProcessingException e) {
            throw new InvalidRequestException("Can't parse json");
        }

        Iterator<String> jsonFields = jsonNode.fieldNames();
        while (jsonFields.hasNext()) {
            String fieldName = jsonFields.next();
            if (!type.getFieldMap().containsKey(fieldName)) {
                throw new InvalidRequestException("Field '" + fieldName + "' is not allowed");
            }
        }

        type.getFieldMap().forEach((dtoFieldName, dtoFieldType) -> {
            if (jsonNode.has(dtoFieldName)) {
                JsonNode fieldNode = jsonNode.get(dtoFieldName);
                if (!isValidType(fieldNode, dtoFieldType)) {
                    throw new InvalidRequestException("Field '" + dtoFieldName + "' has invalid type. Expected: " + dtoFieldType.getSimpleName());
                }
            }
        });
        return type.getId().stream()
                .map(jsonNode::get)
                .map(value -> {
                    if (value == null || StringUtils.isBlank(value.asText())) {
                        throw new InvalidRequestException("Id must not be empty or null");
                    }
                    return value;
                })
                .map(JsonNode::textValue)
                .collect(Collectors.joining("_"));
    }

    private boolean isValidType(JsonNode field, Class<?> expectedType) {
        if (field.isNull()) return true;
        if (expectedType == Integer.class || expectedType == int.class) return field.isInt();
        if (expectedType == Boolean.class || expectedType == boolean.class) return field.isBoolean();
        if (expectedType == Double.class || expectedType == double.class) return field.isDouble();
        if (expectedType == Long.class || expectedType == long.class)
            return field.isNumber() && (field.isInt() || field.isLong());
        if (expectedType == Instant.class) {
            if (field.isTextual()) {
                try {
                    Instant.parse(field.asText());
                    return true;
                } catch (DateTimeParseException e) {
                    return false;
                }
            }
            return false;
        }
        return field.isTextual();
    }

    private void upsert(String id, String json) {
        Document document = Document.parse(json);
        if (elasticsearchTemplate.exists(id, getIndexCoordinates())) {
            List<String> keysToDelete = new ArrayList<>();
            document.entrySet().removeIf(entry -> {
                if (entry.getValue() == null) {
                    keysToDelete.add(entry.getKey());
                    return true;
                }
                return false;
            });

            if (!keysToDelete.isEmpty()) {
                String deleteScript = keysToDelete.stream()
                        .map(key -> String.format(REMOVE_SCRIPT, key))
                        .reduce((a, b) -> a + "; " + b)
                        .orElse("");
                UpdateQuery deleteQuery = UpdateQuery.builder(id)
                        .withScript(deleteScript)
                        .withScriptType(ScriptType.INLINE)
                        .build();
                elasticsearchTemplate.update(deleteQuery, getIndexCoordinates());
            }
        }

        if (!document.isEmpty()) {
            var now = Instant.now().toString();
            if (!elasticsearchTemplate.exists(id, getIndexCoordinates())) {
                document.put(ColumnName.Base._CREATED_AT, now);
            }
            document.put(ColumnName.Base._UPDATED_AT, now);
            UpdateQuery updateQuery = UpdateQuery.builder(id)
                    .withDocument(document)
                    .withDocAsUpsert(true)
                    .build();
            elasticsearchTemplate.update(updateQuery, getIndexCoordinates());
        }
    }

    private IndexCoordinates getIndexCoordinates() {
        return IndexCoordinates.of(type.getIndex());
    }

    protected static void addCriteriaDefinitionsForDateTime(String column, String roundStartTime, List<Criteria> criteriaList) {
        if (!roundStartTime.contains("_")) {
            Instant realRoundStartTime;
            try {
                realRoundStartTime = Instant.parse(roundStartTime);
            } catch (Exception e) {
                throw new InvalidRequestException("Can't parse " + column);
            }
            criteriaList.add(Criteria.where(column).is(realRoundStartTime));
        } else {
            var roundStartTimes = roundStartTime.split("_");
            if (roundStartTimes.length != 2) {
                throw new InvalidRequestException("Can't split " + column + " interval into 2 parts");
            }
            List<Instant> realRoundStartTimes = new ArrayList<>();
            try {
                realRoundStartTimes.add(Instant.parse(roundStartTimes[0]));
                realRoundStartTimes.add(Instant.parse(roundStartTimes[1]));
            } catch (Exception e) {
                throw new InvalidRequestException("Can't parse " + column + " interval");
            }
            Instant fromDate = realRoundStartTimes.getFirst();
            Instant toDate = realRoundStartTimes.getLast();
            if (fromDate.isAfter(toDate)) {
                var temp = fromDate;
                fromDate = toDate;
                toDate = temp;
            }
            criteriaList.add(Criteria.where(column).greaterThanEqual(DateTimeFormatter.ISO_INSTANT.format(fromDate)));
            criteriaList.add(Criteria.where(column).lessThanEqual(DateTimeFormatter.ISO_INSTANT.format(toDate)));
        }
    }


}