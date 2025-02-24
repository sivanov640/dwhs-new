package io.darasa.dwhsnew.entity;

import io.darasa.dwhsnew.constants.ColumnName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.Indexed;
import org.springframework.data.cassandra.core.mapping.Table;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table("ticket")
public class Ticket extends BaseEntity<String> {

    @Indexed
    @Column(ColumnName.Ticket.TICKET_ID)
    private String ticketId;

    @Column(ColumnName.Ticket.TABLE_ID)
    private String tableId;

    @Indexed
    @Column(ColumnName.Ticket.GAME_ID)
    private String gameId;

    @Column(ColumnName.Ticket.GAME_NAME)
    private String gameName;

    @Indexed
    @Column(ColumnName.Ticket.AGENCY_ID)
    private int agencyId;

    @Indexed
    @Column(ColumnName.Ticket.ROUND_ID)
    private String roundId;

    @Indexed
    @Column(ColumnName.Ticket.TRANSACTION_ID)
    private String transactionId;

    @Column(ColumnName.Ticket.ACTION)
    private String action;

    @Column(ColumnName.Ticket.AGENCY_CODE)
    private String agencyCode;

    @Column(ColumnName.Ticket.BET_AMOUNT)
    private double betAmount;

    @Column(ColumnName.Ticket.MEMBER_ID)
    private Long memberId;

    @Column(ColumnName.Ticket.MEMBER_UID)
    private String memberUid;

    @Column(ColumnName.Ticket.PAYMENT_STATUS)
    private String paymentStatus;

    @Column(ColumnName.Ticket.BET_OPTION)
    private String betOption;

    @Column(ColumnName.Ticket.BRAND)
    private String brand;

    @Column(ColumnName.Ticket.FULL_NAME)
    private String fullName;

    @Column(ColumnName.Ticket.DISPLAY_NAME)
    private String displayName;

    @Column(ColumnName.Ticket.CURRENCY)
    private String currency;

    @Column(ColumnName.Ticket.TYPE)
    private String type;

    @Column(ColumnName.Ticket.WIN_AMOUNT)
    private double winAmount;

    @Column(ColumnName.Ticket.GAME_YOUR_BET)
    private String gameYourBet;

    @Column(ColumnName.Ticket.STATUS)
    private String status;

}

