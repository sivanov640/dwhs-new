package io.darasa.dwhsnew.entity.mapped;

import io.darasa.dwhsnew.constants.ColumnName;

import java.time.Instant;
import java.util.List;
import java.util.Map;

public class Ticket extends BaseMap {

    public final static String index = "ticket";

    public final static Map<String, Class<?>> fieldMap = Map.ofEntries(
            Map.entry(ColumnName.Base.CREATED_AT, Instant.class),
            Map.entry(ColumnName.Base.UPDATED_AT, Instant.class),
            Map.entry(ColumnName.Ticket.TICKET_ID, String.class),
            Map.entry(ColumnName.Ticket.TABLE_ID, String.class),
            Map.entry(ColumnName.Ticket.GAME_ID, String.class),
            Map.entry(ColumnName.Ticket.GAME_NAME, String.class),
            Map.entry(ColumnName.Ticket.AGENCY_ID, Integer.class),
            Map.entry(ColumnName.Ticket.AGENCY_CODE, String.class),
            Map.entry(ColumnName.Ticket.AGENCY_CODE2, String.class),
            Map.entry(ColumnName.Ticket.ROUND_ID, String.class),
            Map.entry(ColumnName.Ticket.TRANSACTION_ID, String.class),
            Map.entry(ColumnName.Ticket.ACTION, String.class),
            Map.entry(ColumnName.Ticket.BET_AMOUNT, Double.class),
            Map.entry(ColumnName.Ticket.MEMBER_ID, Long.class),
            Map.entry(ColumnName.Ticket.PAYMENT_STATUS, String.class),
            Map.entry(ColumnName.Ticket.BET_OPTION, String.class),
            Map.entry(ColumnName.Ticket.DISPLAY_NAME, String.class),
            Map.entry(ColumnName.Ticket.CURRENCY, String.class),
            Map.entry(ColumnName.Ticket.TYPE, String.class),
            Map.entry(ColumnName.Ticket.WIN_AMOUNT, Double.class),
            Map.entry(ColumnName.Ticket.GAME_YOUR_BET, Double.class),
            Map.entry(ColumnName.Ticket.STATUS, String.class),
            Map.entry(ColumnName.Ticket.UID, String.class),
            Map.entry(ColumnName.Ticket.UUID, String.class),
            Map.entry(ColumnName.Ticket.USERNAME, String.class),
            Map.entry(ColumnName.Ticket.USER_ID, String.class)
    );

    public final static List<String> id = List.of(
            ColumnName.Ticket.GAME_ID,
            ColumnName.Ticket.TICKET_ID
    );

}