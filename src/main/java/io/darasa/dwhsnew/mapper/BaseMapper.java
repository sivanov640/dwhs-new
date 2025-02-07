package io.darasa.dwhsnew.mapper;

import io.darasa.dwhsnew.dto.request.BaseDto;
import io.darasa.dwhsnew.entity.BaseEntity;
import org.mapstruct.Mapping;

public interface BaseMapper<T extends BaseEntity, U extends BaseDto> {

    @Mapping(target = "id", source = "id", defaultExpression = "java(java.util.UUID.randomUUID())")
    T toEntity(U dto);

    U toDto(T entity);
}