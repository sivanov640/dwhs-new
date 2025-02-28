package io.darasa.dwhsnew.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ElasticsearchException extends RuntimeException {


    private static final String message = "Error save %s at Elasticsearch!";

    public ElasticsearchException(Class<?> clazz) {
        super(String.format(message, clazz.getSimpleName()));
    }
}