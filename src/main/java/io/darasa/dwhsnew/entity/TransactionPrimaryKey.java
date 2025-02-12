package io.darasa.dwhsnew.entity;

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

    @PrimaryKeyColumn(name = "game_id", type = PrimaryKeyType.PARTITIONED)
    private String gameId;

    @PrimaryKeyColumn(name = "ticket_id", type = PrimaryKeyType.PARTITIONED)
    private String ticketId;

    @PrimaryKeyColumn(name = "agency_id", type = PrimaryKeyType.PARTITIONED)
    private String agencyId;

    @PrimaryKeyColumn(name = "member_id", type = PrimaryKeyType.PARTITIONED)
    private String memberId;

}
