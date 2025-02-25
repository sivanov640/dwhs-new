package io.darasa.dwhsnew.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.darasa.dwhsnew.constants.ColumnName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class DroppedDto extends BaseDto {

    @JsonProperty(ColumnName.Round.RESULT)
    private String data;

    public static DroppedDto of(String data) {
        return new DroppedDto(data);
    }

}

