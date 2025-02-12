package io.darasa.dwhsnew.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.Instant;

@Data
@EqualsAndHashCode(callSuper = false)
public class TicketDto extends BaseDto implements Identifiable {

    @JsonProperty
    private String id;
    @JsonProperty("table_id")
    private String tableId;
    @JsonProperty("game_id")
    private String gameId;
    @JsonProperty("game_name")
    private String gameName;
    @JsonProperty("agency_id")
    private int agencyId;
    @JsonProperty("round_id")
    private String roundId;
    @JsonProperty("transactionId")
    private String transactionId;
    @JsonProperty("action")
    private String action;
    @JsonProperty("agency_code")
    private String agencyCode;
    @JsonProperty("bet_amount")
    private double betAmount;
    @JsonProperty("member_id")
    private String memberId;
    @JsonProperty("payment_status")
    private String paymentStatus;
    @JsonProperty("round_start_time")
    private Instant roundStartTime;
    @JsonProperty("round_end_time")
    private Instant roundEndTime;
    @JsonProperty("user_step")
    private String userStep;
    @JsonProperty("round_step")
    private String roundStep;
    @JsonProperty("brand")
    private String brand;
    @JsonProperty("full_name")
    private String fullName;
    @JsonProperty("currency")
    private String currency;

}

