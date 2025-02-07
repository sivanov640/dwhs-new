package io.darasa.dwhsnew.mapper;

import io.darasa.dwhsnew.dto.request.TicketDto;
import io.darasa.dwhsnew.entity.Ticket;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TicketMapper extends BaseMapper<Ticket, TicketDto> {
}