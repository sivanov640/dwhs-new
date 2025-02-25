package io.darasa.dwhsnew.mapper;

import org.mapstruct.Mapping;

public interface BaseMapper<T, U> {

    @Mapping(target = "id", source = ".")
    T toEntity(U dto);

    @Mapping(target = ".", source = "id")
    U toDto(T entity);

}