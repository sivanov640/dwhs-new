package io.darasa.dwhsnew.entity;

import io.darasa.dwhsnew.constants.ColumnName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.Instant;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TypeAlias("ticket")
@Document(indexName = "ticket")
public class Ticket extends CreatedUpdatedEntity {


    @Field(name = ColumnName.Ticket.TICKET_ID)
    private String ticketId;

    @Field(name = ColumnName.Ticket.GAME_ID)
    private String gameId;

    @Field(ColumnName.Ticket.TABLE_ID)
    private String tableId;

    @Field(ColumnName.Ticket.GAME_NAME)
    private String gameName;

    @Field(ColumnName.Ticket.AGENCY_ID)
    private int agencyId;

    @Field(ColumnName.Ticket.AGENCY_CODE)
    private String agencyCode;

    @Field(ColumnName.Ticket.AGENCY_CODE2)
    private String agencyCode2;

    @Field(ColumnName.Ticket.ROUND_ID)
    private String roundId;

    @Field(ColumnName.Ticket.TRANSACTION_ID)
    private String transactionId;

    @Field(ColumnName.Ticket.ACTION)
    private String action;

    @Field(ColumnName.Ticket.BET_AMOUNT)
    private double betAmount;

    @Field(ColumnName.Ticket.MEMBER_ID)
    private Long memberId;

    @Field(ColumnName.Ticket.PAYMENT_STATUS)
    private String paymentStatus;

    @Field(ColumnName.Ticket.BET_OPTION)
    private String betOption;

    @Field(ColumnName.Ticket.DISPLAY_NAME)
    private String displayName;

    @Field(ColumnName.Ticket.CURRENCY)
    private String currency;

    @Field(ColumnName.Ticket.TYPE)
    private String type;

    @Field(ColumnName.Ticket.WIN_AMOUNT)
    private double winAmount;

    @Field(ColumnName.Ticket.GAME_YOUR_BET)
    private String gameYourBet;

    @Field(ColumnName.Ticket.STATUS)
    private String status;

    @Field(ColumnName.Ticket.UID)
    private String uid;

    @Field(ColumnName.Ticket.UUID)
    private String uuid;

    @Field(ColumnName.Ticket.USERNAME)
    private String username;

    @Field(ColumnName.Ticket.USER_ID)
    private String userId;

    @Field(name = ColumnName.Ticket.ROUND_START_TIME, type = FieldType.Date)
    private Instant roundStartTime;

    @Field(name = ColumnName.Ticket.ROUND_END_TIME, type = FieldType.Date)
    private Instant roundEndTime;

    @Field(ColumnName.Ticket.ROUND_NUMBER)
    private String roundNumber;

    @Override
    public String getId() {
        if (gameId == null || roundId == null) {
            return null;
        }
        return gameId + '-' + ticketId;
    }

}

