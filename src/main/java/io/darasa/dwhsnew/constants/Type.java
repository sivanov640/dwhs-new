package io.darasa.dwhsnew.constants;

import io.darasa.dwhsnew.dto.request.BaseDto;
import io.darasa.dwhsnew.dto.request.RoundDto;
import io.darasa.dwhsnew.dto.request.TicketDto;
import io.darasa.dwhsnew.dto.request.TransactionDto;
import io.darasa.dwhsnew.entity.BaseEntity;
import io.darasa.dwhsnew.entity.Round;
import io.darasa.dwhsnew.entity.Ticket;
import io.darasa.dwhsnew.entity.Transaction;
import io.darasa.dwhsnew.exception.InvalidRequestException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum Type {

    ROUND(Round.class, RoundDto.class),
    TRANSACTION(Transaction.class, TransactionDto.class),
    TICKET(Ticket.class, TicketDto.class);

    private final Class<? extends BaseEntity> entityClass;

    private final Class<? extends BaseDto> dtoClass;

    public static Type getType(String value) {
        return Arrays.stream(Type.values()).filter(type -> type.name().equalsIgnoreCase(value)).findFirst().orElseThrow(() -> new InvalidRequestException("Type " + value + " not found"));
    }
}
