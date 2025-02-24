package io.darasa.dwhsnew.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.darasa.dwhsnew.constants.ColumnName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class TicketDto extends BaseDto {

    @JsonProperty(ColumnName.Ticket.TICKET_ID)
    private String ticketId;
    @JsonProperty(ColumnName.Ticket.TABLE_ID)
    private String tableId;
    @JsonProperty(ColumnName.Ticket.GAME_ID)
    private String gameId;
    @JsonProperty(ColumnName.Ticket.GAME_NAME)
    private String gameName;
    @JsonProperty(ColumnName.Ticket.AGENCY_ID)
    private int agencyId;
    @JsonProperty(ColumnName.Ticket.ROUND_ID)
    private String roundId;
    @JsonProperty(ColumnName.Ticket.TRANSACTION_ID)
    private String transactionId;
    @JsonProperty(ColumnName.Ticket.ACTION)
    private String action;
    @JsonProperty(ColumnName.Ticket.AGENCY_CODE)
    private String agencyCode;
    @JsonProperty(ColumnName.Ticket.BET_AMOUNT)
    private double betAmount;
    @JsonProperty(ColumnName.Ticket.MEMBER_ID)
    private Long memberId;
    @JsonProperty(ColumnName.Ticket.MEMBER_UID)
    private String memberUid;
    @JsonProperty(ColumnName.Ticket.PAYMENT_STATUS)
    private String paymentStatus;
    @JsonProperty(ColumnName.Ticket.BET_OPTION)
    private String betOption;
    @JsonProperty(ColumnName.Ticket.BRAND)
    private String brand;
    @JsonProperty(ColumnName.Ticket.FULL_NAME)
    private String fullName;
    @JsonProperty(ColumnName.Ticket.DISPLAY_NAME)
    private String displayName;
    @JsonProperty(ColumnName.Ticket.CURRENCY)
    private String currency;
    @JsonProperty(ColumnName.Ticket.TYPE)
    private String type;
    @JsonProperty(ColumnName.Ticket.WIN_AMOUNT)
    private double winAmount;
    @JsonProperty(ColumnName.Ticket.STATUS)
    private String status;
    @JsonProperty(ColumnName.Ticket.GAME_YOUR_BET)
    private String gameYourBet;

}

