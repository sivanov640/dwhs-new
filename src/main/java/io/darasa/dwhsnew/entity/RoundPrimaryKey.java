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
public class RoundPrimaryKey implements Serializable {

    @PrimaryKeyColumn(name = ColumnName.Round.ROUND_ID, type = PrimaryKeyType.PARTITIONED)
    private String roundId;

    @PrimaryKeyColumn(name = ColumnName.Round.GAME_ID, type = PrimaryKeyType.PARTITIONED)
    private String gameId;

}
