package io.darasa.dwhsnew.entity.mapped;

import io.darasa.dwhsnew.constants.ColumnName;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public abstract class BaseMap {

    public final static Map<String, Class<?>> elasticFields = Map.of(
            ColumnName.Base._CREATED_AT, Instant.class,
            ColumnName.Base._UPDATED_AT, Instant.class
    );

    public static Map<String, Object> getExample(Map<String, Class<?>> map, List<String> ids) {
        return map.entrySet().stream()
                .map(entry -> getExampleValue(entry, ids))
                .filter(Objects::nonNull)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private static Map.Entry<String, Object> getExampleValue(Map.Entry<String, Class<?>> entry, List<String> ids) {
        if (entry.getValue() == String.class) {
            if (ids.contains(entry.getKey())) return Map.entry(entry.getKey(), "string (required)");
            return Map.entry(entry.getKey(), "string");
        }
        if (entry.getValue() == Integer.class) return Map.entry(entry.getKey(), 123);
        if (entry.getValue() == Long.class) return Map.entry(entry.getKey(), 123456789L);
        if (entry.getValue() == Double.class) return Map.entry(entry.getKey(), 123.456);
        if (entry.getValue() == Boolean.class) return Map.entry(entry.getKey(), true);
        if (entry.getValue() == Instant.class) return Map.entry(entry.getKey(), Instant.now().toString());
        return null;
    }

}
