package io.darasa.dwhsnew.mapper;

import io.darasa.dwhsnew.dto.request.DroppedDto;
import io.darasa.dwhsnew.entity.Dropped;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DroppedMapper extends BaseMapper<Dropped, DroppedDto> {

    @Mapping(target = "id", expression = "java(java.util.UUID.randomUUID().toString())")
    Dropped toEntity(DroppedDto dto);

}