package io.darasa.dwhsnew.service;

import io.darasa.dwhsnew.constants.Type;
import io.darasa.dwhsnew.dto.request.BaseDto;
import io.darasa.dwhsnew.dto.response.PageResponse;
import io.darasa.dwhsnew.entity.BaseEntity;
import io.darasa.dwhsnew.exception.CassandraException;
import io.darasa.dwhsnew.exception.InvalidRequestException;
import io.darasa.dwhsnew.mapper.BaseMapper;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.core.query.CassandraPageRequest;
import org.springframework.data.cassandra.core.query.Criteria;
import org.springframework.data.cassandra.core.query.CriteriaDefinition;
import org.springframework.data.cassandra.core.query.Query;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public abstract class BaseService<T extends BaseEntity<TID>, TID, U extends BaseDto> {

    @Getter
    protected final Type type;

    @Autowired
    protected CassandraTemplate cassandraTemplate;

    @Autowired
    protected BaseMapper<T, U> baseMapper;

    public void save(BaseDto dto) {
        try {
            T entity = cassandraTemplate.insert(convertDtoToEntity(dto));
            if (!cassandraTemplate.exists(entity.getId(), type.getEntityClass())) {
                throw new CassandraException(type.getEntityClass());
            }
        } catch (InvalidRequestException e) {
            throw e;
        } catch (Exception e) {
            throw new CassandraException(type.getEntityClass());
        }
    }

    public PageResponse<U> getAll(int page, int size, List<CriteriaDefinition> criteriaDefinitions) {
        if (page < 1) {
            throw new InvalidRequestException("Page must be greater than 0");
        } else if (size < 1) {
            throw new InvalidRequestException("Size must be greater than 0");
        }
        if (criteriaDefinitions == null) {
            criteriaDefinitions = new ArrayList<>();
        }
        Slice<T> slice = (Slice<T>) cassandraTemplate.slice(Query.query(criteriaDefinitions).pageRequest(CassandraPageRequest.first(size)).withAllowFiltering(), type.getEntityClass());

        while (slice.hasNext() && page > 1) {
            slice = (Slice<T>) cassandraTemplate.slice(
                    Query.query(criteriaDefinitions).pageRequest(slice.nextPageable()),
                    type.getEntityClass()
            );
            page--;
        }
        if (page == 1) {
            Slice<U> all = slice.map(baseMapper::toDto);
            return PageResponse.<U>builder()
                    .records(all.getContent())
                    .hasNext(all.hasNext())
                    .size(all.getNumberOfElements())
                    .build();
        } else {
            return PageResponse.<U>builder().build();
        }
    }

    private T convertDtoToEntity(BaseDto dto) {
        try {
            return baseMapper.toEntity((U) dto);
        } catch (Exception e) {
            throw new InvalidRequestException("Can't convert dto to entity");
        }
    }

    protected static void addCriteriaDefinitionsForDateTime(String column, String roundStartTime, List<CriteriaDefinition> criteriaDefinitions) {
        if (!roundStartTime.contains("_")) {
            Instant realRoundStartTime;
            try {
                realRoundStartTime = Instant.parse(roundStartTime);
            } catch (Exception e) {
                throw new InvalidRequestException("Can't parse " + column);
            }
            criteriaDefinitions.add(Criteria.where(column).is(realRoundStartTime));
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
            criteriaDefinitions.add(Criteria.where(column).gte(fromDate));
            criteriaDefinitions.add(Criteria.where(column).lte(toDate));
        }
    }
}