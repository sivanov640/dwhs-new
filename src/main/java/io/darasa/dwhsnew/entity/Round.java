package io.darasa.dwhsnew.entity;

import io.darasa.dwhsnew.constants.ColumnName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.Indexed;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.Instant;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table("round")
public class Round extends CreatedUpdatedEntity<RoundPrimaryKey> {

    @Column(ColumnName.Round.TABLE_ID)
    private String tableId;

    @Column(ColumnName.Round.GAME_NAME)
    private String gameName;

    @Column(ColumnName.Round.RESULT)
    private String result;

    @Indexed
    @Column(ColumnName.Round.START_TIME)
    private Instant startTime;

    @Indexed
    @Column(ColumnName.Round.END_TIME)
    private Instant endTime;

}

