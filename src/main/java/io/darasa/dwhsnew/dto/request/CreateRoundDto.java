package io.darasa.dwhsnew.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class CreateRoundDto {
    private String result;
    private Instant startTime;
    private Instant endTime;
    private String createdBy;
}
