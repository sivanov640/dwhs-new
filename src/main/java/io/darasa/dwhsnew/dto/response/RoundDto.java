package io.darasa.dwhsnew.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoundDto {

    private UUID id;
    private String result;
    private Instant startTime;
    private Instant endTime;
    private String createdBy;
    private Instant createdAt;
    private Instant updatedAt;
}
