package io.darasa.dwhsnew.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.Instant;

@Data
@EqualsAndHashCode(callSuper = true)
public class RoundDto extends BaseDto {
    private String result;
    @JsonProperty("start_time")
    private Instant startTime;
    @JsonProperty("end_time")
    private Instant endTime;
}
