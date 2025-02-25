package io.darasa.dwhsnew.entity;

import io.darasa.dwhsnew.constants.ColumnName;
import lombok.*;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.io.Serializable;

@Getter
@Builder
@ToString
@PrimaryKeyClass
@NoArgsConstructor
@AllArgsConstructor
public class TicketPrimaryKey implements Serializable {

    @PrimaryKeyColumn(name = ColumnName.Ticket.TICKET_ID, type = PrimaryKeyType.PARTITIONED)
    private String ticketId;

    @PrimaryKeyColumn(name = ColumnName.Ticket.GAME_ID, type = PrimaryKeyType.PARTITIONED)
    private String gameId;

}
