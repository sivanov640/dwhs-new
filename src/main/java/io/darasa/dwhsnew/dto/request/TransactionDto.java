package io.darasa.dwhsnew.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.darasa.dwhsnew.constants.TicketStatus;
import io.darasa.dwhsnew.constants.TxAction;
import io.darasa.dwhsnew.constants.TxOption;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TransactionDto extends BaseDto {

    @JsonProperty("member_id")
    private long memberId;

    @JsonProperty("ticket_id")
    private String ticketId;

    @JsonProperty("amount")
    private double amount;

    @JsonProperty("action")
    private TxAction action;

    @JsonProperty("option")
    private TxOption option;

    @JsonProperty("ticket_status")
    private TicketStatus ticketStatus;

    @JsonProperty("error_code")
    private int errorCode;

    @JsonProperty("payload")
    private String payload;

    @JsonProperty("response")
    private String response;

    @JsonProperty("note")
    private String note;
}

