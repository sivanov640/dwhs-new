package io.darasa.dwhsnew.entity.mapped;

import io.darasa.dwhsnew.constants.ColumnName;

import java.time.Instant;
import java.util.List;
import java.util.Map;

public class Transaction extends BaseMap {

    public final static String index = "transaction";

    public final static Map<String, Class<?>> fieldMap = Map.ofEntries(
            Map.entry(ColumnName.Base.CREATED_AT, Instant.class),
            Map.entry(ColumnName.Base.UPDATED_AT, Instant.class),
            Map.entry(ColumnName.Transaction.TRANSACTION_ID, String.class),
            Map.entry(ColumnName.Transaction.REQUEST, String.class),
            Map.entry(ColumnName.Transaction.RESPONSE, String.class)
    );

    public final static List<String> id = List.of(
            ColumnName.Transaction.TRANSACTION_ID
    );

}