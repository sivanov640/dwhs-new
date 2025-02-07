package io.darasa.dwhsnew.mapper;

import io.darasa.dwhsnew.dto.request.TransactionDto;
import io.darasa.dwhsnew.entity.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TransactionMapper extends BaseMapper<Transaction, TransactionDto> {

}