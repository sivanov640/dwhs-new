package io.darasa.dwhsnew.service;

import io.darasa.dwhsnew.constants.Type;
import io.darasa.dwhsnew.dto.request.BaseDto;
import io.darasa.dwhsnew.dto.response.PageResponse;
import io.darasa.dwhsnew.entity.BaseEntity;
import io.darasa.dwhsnew.exception.ElasticsearchException;
import io.darasa.dwhsnew.exception.InvalidRequestException;
import io.darasa.dwhsnew.mapper.BaseMapper;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public abstract class BaseService<T extends BaseEntity, U extends BaseDto> {

    @Getter
    protected final Type type;

    @Autowired
    protected ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    protected BaseMapper<T, U> baseMapper;

    public void save(BaseDto dto) {
        try {
            T entityOfDto = convertDtoToEntity(dto);
            if (entityOfDto.getId() == null) {
                throw new InvalidRequestException("Id must not be null");
            }
            if (elasticsearchTemplate.exists(entityOfDto.getId(), type.getEntityClass())) {
                entityOfDto = convertDtoToEntity(elasticsearchTemplate.get(entityOfDto.getId(), type.getEntityClass()), dto);
            }
            elasticsearchTemplate.save(entityOfDto);

            if (!elasticsearchTemplate.exists(entityOfDto.getId(), type.getEntityClass())) {
                throw new ElasticsearchException(type.getEntityClass());
            }
        } catch (InvalidRequestException e) {
            throw e;
        } catch (Exception e) {
            throw new ElasticsearchException(type.getEntityClass());
        }
    }

    public PageResponse<U> getAll(int page, int size, List<Criteria> criterias) {
        if (page < 1) {
            throw new InvalidRequestException("Page must be greater than 0");
        } else if (size < 1) {
            throw new InvalidRequestException("Size must be greater than 0");
        }
        if (!elasticsearchTemplate.indexOps(type.getEntityClass()).exists()) {
            return PageResponse.<U>builder().build();
        }
        if (criterias == null) {
            criterias = new ArrayList<>();
        }
        CriteriaQuery query = new CriteriaQuery(new Criteria().and(criterias.toArray(Criteria[]::new)))
                .setPageable(PageRequest.of(page - 1, size + 1));

        // Perform the search with the query and pageable request
        var resultPage = elasticsearchTemplate.search(query, type.getEntityClass());
        return PageResponse.<U>builder()
                .records(resultPage.getSearchHits().stream()
                        .limit(size)
                        .map(searchHit -> baseMapper.toDto((T) searchHit.getContent()))
                        .toList())
                .hasNext(resultPage.getSearchHits().size() > size)
                .size(Math.min(resultPage.getSearchHits().size(), size))
                .build();
    }

    private T convertDtoToEntity(BaseDto dto) {
        try {
            return baseMapper.toEntity((U) dto);
        } catch (Exception e) {
            throw new InvalidRequestException("Can't convert dto to entity");
        }
    }

    private T convertDtoToEntity(BaseEntity entity, BaseDto dto) {
        try {
            return baseMapper.toEntity((T) entity, (U) dto);
        } catch (Exception e) {
            throw new InvalidRequestException("Can't convert dto to entity");
        }
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