package io.darasa.dwhsnew.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CassandraException extends RuntimeException {


    private static final String message = "Error save %s at Cassandra!";

    public CassandraException(Class<?> clazz) {
        super(String.format(message, clazz.getSimpleName()));
    }
}