package io.darasa.dwhsnew.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.darasa.dwhsnew.constants.ColumnName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.Instant;

@Data
@EqualsAndHashCode(callSuper = true)
public class CreatedUpdatedDto extends BaseDto {

    @JsonProperty(ColumnName.Base.CREATED_AT)
    private Instant createdAt;

    @JsonProperty(ColumnName.Base.UPDATED_AT)
    private Instant updatedAt;
}
