package io.darasa.dwhsnew.constants;

import io.darasa.dwhsnew.entity.mapped.Round;
import io.darasa.dwhsnew.entity.mapped.Ticket;
import io.darasa.dwhsnew.entity.mapped.Transaction;
import io.darasa.dwhsnew.exception.InvalidRequestException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Getter
@RequiredArgsConstructor
public enum Type {

    ROUND(Round.fieldMap, Round.id, Round.index),
    TRANSACTION(Transaction.fieldMap, Transaction.id, Transaction.index),
    TICKET(Ticket.fieldMap, Ticket.id, Ticket.index);

    private final Map<String, Class<?>> fieldMap;

    private final List<String> id;

    private final String index;

    public static Type getType(String value) {
        return Arrays.stream(Type.values()).filter(type -> type.name().equalsIgnoreCase(value)).findFirst().orElseThrow(() -> new InvalidRequestException("Type " + value + " not found"));
    }
}
