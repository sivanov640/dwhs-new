package io.darasa.dwhsnew.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.darasa.dwhsnew.constants.Currency;
import io.darasa.dwhsnew.constants.TicketStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = true)
public class TicketDto extends BaseDto {

    @JsonProperty("user_step")
    private String userStep;

    @JsonProperty("round_step")
    private String roundStep;

    @JsonProperty("member_id")
    private long memberId;

    @JsonProperty("brand")
    private String brand;

    @JsonProperty("agency_id")
    private int agencyId;

    @JsonProperty("agency_code")
    private String agencyCode;

    @JsonProperty("full_name")
    private String fullName;

    @JsonProperty("currency")
    private Currency currency;

    @JsonProperty("round_id")
    private UUID roundId;

    @JsonProperty("status")
    private TicketStatus status;

    @JsonProperty("amount")
    private double amount;

    @JsonProperty("amount_win")
    private double amountWin;

    @JsonProperty("note")
    private String note;

    @JsonProperty("rate")
    private double rate;

    @JsonProperty("paid")
    private boolean paid;
}

