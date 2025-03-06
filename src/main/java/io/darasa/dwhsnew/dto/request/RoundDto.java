package io.darasa.dwhsnew.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.darasa.dwhsnew.constants.ColumnName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.Instant;

@Data
@EqualsAndHashCode(callSuper = false)
public class RoundDto extends CreatedUpdatedDto {
    @JsonProperty(ColumnName.Round.ROUND_ID)
    private String roundId;
    @JsonProperty(ColumnName.Round.TABLE_ID)
    private String tableId;
    @JsonProperty(ColumnName.Round.GAME_ID)
    private String gameId;
    @JsonProperty(ColumnName.Round.GAME_NAME)
    private String gameName;
    @JsonProperty(ColumnName.Round.RESULT)
    private String result;
    @JsonProperty(ColumnName.Round.START_TIME)
    private Instant startTime;
    @JsonProperty(ColumnName.Round.END_TIME)
    private Instant endTime;
    @JsonProperty(ColumnName.Round.NUMBER)
    private String number;
}
