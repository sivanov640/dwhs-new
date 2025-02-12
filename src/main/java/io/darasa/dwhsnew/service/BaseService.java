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
import org.springframework.data.cassandra.core.query.CassandraPageRequest;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public abstract class BaseService<T extends BaseEntity<TID>, TID, U extends BaseDto> {

    @Getter
    private final Type type;

    @Autowired
    private CassandraRepository<T, TID> baseEntityRepository;

    @Autowired
    private BaseMapper<T, U> baseMapper;

    public String save(BaseDto dto) {
        try {
            T entity = baseEntityRepository.save(convertDtoToEntity(dto));
            if (baseEntityRepository.existsById(entity.getId())) {
                return type.getEntityClass().getSimpleName() + " " + entity.getId() + " saved successfully";
            } else {
                throw new CassandraException(type.getEntityClass());
            }
        } catch (InvalidRequestException e) {
            throw e;
        } catch (Exception e) {
            throw new CassandraException(type.getEntityClass());
        }
    }

    public PageResponse<U> getAll(int page, int size) {
        if (page < 1) {
            throw new InvalidRequestException("Page must be greater than 0");
        } else if (size < 1) {
            throw new InvalidRequestException("Size must be greater than 0");
        }
        Slice<T> slice = baseEntityRepository.findAll(CassandraPageRequest.first(size));
        while (slice.hasNext() && page > 1) {
            slice = baseEntityRepository.findAll(slice.nextPageable());
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
        T entity;
        try {
            entity = baseMapper.toEntity((U) dto);
        } catch (Exception e) {
            throw new InvalidRequestException("Can't convert dto to entity");
        }
        return entity;
    }
}