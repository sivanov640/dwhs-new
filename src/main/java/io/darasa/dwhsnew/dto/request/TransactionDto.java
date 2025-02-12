package io.darasa.dwhsnew.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class TransactionDto extends BaseDto {

    @JsonProperty("game_id")
    private String gameId;

    @JsonProperty("ticket_id")
    private String ticketId;

    @JsonProperty("agency_id")
    private String agencyId;

    @JsonProperty("member_id")
    private String memberId;

    @JsonProperty("request_json")
    private String requestJson;

    @JsonProperty("response_json")
    private String responseJson;

}

