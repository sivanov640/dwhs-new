package io.darasa.dwhsnew.entity;

import io.darasa.dwhsnew.constants.ColumnName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.Instant;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TypeAlias("round")
@Document(indexName = "round")
public class Round extends CreatedUpdatedEntity {

    @Field(name = ColumnName.Round.ROUND_ID)
    private String roundId;

    @Field(name = ColumnName.Round.GAME_ID)
    private String gameId;

    @Field(ColumnName.Round.TABLE_ID)
    private String tableId;

    @Field(ColumnName.Round.GAME_NAME)
    private String gameName;

    @Field(ColumnName.Round.RESULT)
    private String result;

    @Field(name = ColumnName.Round.START_TIME, type = FieldType.Date)
    private Instant startTime;

    @Field(name = ColumnName.Round.END_TIME, type = FieldType.Date)
    private Instant endTime;

    @Override
    public String getId() {
        if (gameId == null || roundId == null) {
            return null;
        }
        return gameId + '-' + roundId;
    }

}

