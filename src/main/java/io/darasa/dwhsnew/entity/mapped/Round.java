package io.darasa.dwhsnew.entity.mapped;

import io.darasa.dwhsnew.constants.ColumnName;

import java.time.Instant;
import java.util.List;
import java.util.Map;

public class Round extends BaseMap {

    public final static String index = "round";

    public final static Map<String, Class<?>> fieldMap = Map.ofEntries(
            Map.entry(ColumnName.Base.CREATED_AT, Instant.class),
            Map.entry(ColumnName.Base.UPDATED_AT, Instant.class),
            Map.entry(ColumnName.Round.ROUND_ID, String.class),
            Map.entry(ColumnName.Round.TABLE_ID, String.class),
            Map.entry(ColumnName.Round.GAME_ID, String.class),
            Map.entry(ColumnName.Round.GAME_NAME, String.class),
            Map.entry(ColumnName.Round.RESULT, String.class),
            Map.entry(ColumnName.Round.START_TIME, Instant.class),
            Map.entry(ColumnName.Round.END_TIME, Instant.class),
            Map.entry(ColumnName.Round.NUMBER, Integer.class)
    );

    public final static List<String> id = List.of(
            ColumnName.Round.GAME_ID,
            ColumnName.Round.ROUND_ID
    );

}