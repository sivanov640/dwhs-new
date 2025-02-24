package io.darasa.dwhsnew.entity;

import io.darasa.dwhsnew.constants.ColumnName;
import lombok.*;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.io.Serializable;

@Getter
@ToString
@Builder
@PrimaryKeyClass
@NoArgsConstructor
@AllArgsConstructor
public class TransactionPrimaryKey implements Serializable {

    @PrimaryKeyColumn(name = ColumnName.Transaction.GAME_ID, type = PrimaryKeyType.PARTITIONED)
    private String gameId;

    @PrimaryKeyColumn(name = ColumnName.Transaction.TICKET_ID, type = PrimaryKeyType.PARTITIONED)
    private String ticketId;

    @PrimaryKeyColumn(name = ColumnName.Transaction.AGENCY_ID, type = PrimaryKeyType.PARTITIONED)
    private String agencyId;

    @PrimaryKeyColumn(name = ColumnName.Transaction.MEMBER_ID, type = PrimaryKeyType.PARTITIONED)
    private String memberId;

}
