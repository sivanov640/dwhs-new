package io.darasa.dwhsnew.mapper;

import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

public interface BaseMapper<T, U> {

    @Mapping(target = "createdAt", source = "createdAt", defaultExpression = "java(java.time.Instant.now())")
    @Mapping(target = "updatedAt", source = "updatedAt", defaultExpression = "java(java.time.Instant.now())")
    T toEntity(U dto);

    U toDto(T entity);

    T toEntity(@MappingTarget T entity, U dto);
}