package io.darasa.dwhsnew.mapper;

import io.darasa.dwhsnew.dto.request.UnknownDto;
import io.darasa.dwhsnew.entity.Unknown;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UnknownMapper extends BaseMapper<Unknown, UnknownDto> {

    @Mapping(target = "id", expression = "java(java.util.UUID.randomUUID().toString())")
    Unknown toEntity(UnknownDto dto);

}