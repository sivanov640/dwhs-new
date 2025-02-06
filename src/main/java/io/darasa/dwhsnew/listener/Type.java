package io.darasa.dwhsnew.listener;

import java.util.Arrays;

public enum Type {

    ROUND, TRANSACTION, TICKET;

    static Type getType(String value) {
        return Arrays.stream(Type.values()).filter(type -> type.name().equalsIgnoreCase(value)).findFirst().orElseThrow(() -> new RuntimeException("Type not found"));
    }
}
