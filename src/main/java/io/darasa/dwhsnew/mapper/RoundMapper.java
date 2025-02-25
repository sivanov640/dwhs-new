package io.darasa.dwhsnew.mapper;

import io.darasa.dwhsnew.dto.request.RoundDto;
import io.darasa.dwhsnew.entity.Round;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoundMapper extends BaseMapper<Round, RoundDto> {

}