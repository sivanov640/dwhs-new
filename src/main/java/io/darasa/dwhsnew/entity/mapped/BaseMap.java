package io.darasa.dwhsnew.entity.mapped;

import io.darasa.dwhsnew.constants.ColumnName;

import java.time.Instant;
import java.util.Map;

public abstract class BaseMap {

    public final static Map<String, Class<?>> elasticFields = Map.of(
            ColumnName.Base._CREATED_AT, Instant.class,
            ColumnName.Base._UPDATED_AT, Instant.class
    );

}
