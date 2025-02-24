package io.darasa.dwhsnew.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.darasa.dwhsnew.constants.ColumnName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class TransactionDto extends BaseDto {

    @JsonProperty(ColumnName.Transaction.GAME_ID)
    private String gameId;
    @JsonProperty(ColumnName.Transaction.TICKET_ID)
    private String ticketId;
    @JsonProperty(ColumnName.Transaction.AGENCY_ID)
    private String agencyId;
    @JsonProperty(ColumnName.Transaction.MEMBER_ID)
    private String memberId;
    @JsonProperty(ColumnName.Transaction.REQUEST_JSON)
    private String requestJson;
    @JsonProperty(ColumnName.Transaction.RESPONSE_JSON)
    private String responseJson;

}

