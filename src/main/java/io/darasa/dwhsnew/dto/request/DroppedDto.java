package io.darasa.dwhsnew.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.darasa.dwhsnew.constants.ColumnName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.StringUtils;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class DroppedDto extends BaseDto {

    @JsonProperty(ColumnName.Dropped.DATA)
    private String data;

    @JsonProperty(ColumnName.Dropped.TYPE)
    private String type;

    public static DroppedDto of(String data, String type) {
        return new DroppedDto(
                data == null ? StringUtils.EMPTY : data,
                type == null ? StringUtils.EMPTY : type
        );
    }

}

