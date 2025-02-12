package io.darasa.dwhsnew.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.Instant;

@Data
@EqualsAndHashCode(callSuper = false)
public class RoundDto extends BaseDto implements Identifiable {
    @JsonProperty
    private String id;
    @JsonProperty("table_id")
    private String tableId;
    @JsonProperty("game_id")
    private String gameId;
    @JsonProperty("game_name")
    private String gameName;
    @JsonProperty("result")
    private String result;
    @JsonProperty("start_time")
    private Instant startTime;
    @JsonProperty("end_time")
    private Instant endTime;
}
