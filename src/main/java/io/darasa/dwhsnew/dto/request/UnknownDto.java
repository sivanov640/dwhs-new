package io.darasa.dwhsnew.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.darasa.dwhsnew.constants.ColumnName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class UnknownDto extends BaseDto {

    @JsonProperty(ColumnName.Round.RESULT)
    private String data;

    public static UnknownDto of(String data) {
        return new UnknownDto(data);
    }

}

