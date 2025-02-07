package io.darasa.dwhsnew.entity;

import io.darasa.dwhsnew.constants.Currency;
import io.darasa.dwhsnew.constants.TicketStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table("ticket")
public class Ticket extends BaseEntity {

    @Column("user_step")
    private String userStep;

    @Column("round_step")
    private String roundStep;

    @Column("member_id")
    private long memberId;

    @Column("brand")
    private String brand;

    @Column("agency_id")
    private int agencyId;

    @Column("agency_code")
    private String agencyCode;

    @Column("full_name")
    private String fullName;

    @Column("currency")
    private Currency currency;

    @Column("round_id")
    private UUID roundId;

    @Column("status")
    private TicketStatus status;

    @Column("amount")
    private double amount;

    @Column("amount_win")
    private double amountWin;

    @Column("note")
    private String note;

    @Column("rate")
    private double rate;

    @Column("paid")
    private boolean paid;
}

