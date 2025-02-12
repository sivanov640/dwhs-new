package io.darasa.dwhsnew.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.Indexed;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.Instant;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table("ticket")
public class Ticket extends BaseEntity<String> {

    @Column("table_id")
    private String tableId;

    @Indexed
    @Column("game_id")
    private String gameId;

    @Column("game_name")
    private String gameName;

    @Indexed
    @Column("agency_id")
    private int agencyId;

    @Indexed
    @Column("round_id")
    private String roundId;

    @Indexed
    @Column("transactionId")
    private String transactionId;

    @Column("action")
    private String action;

    @Column("agency_code")
    private String agencyCode;

    @Column("bet_amount")
    private double betAmount;

    @Column("member_id")
    private String memberId;

    @Column("payment_status")
    private String paymentStatus;

    @Column("round_start_time")
    private Instant roundStartTime;

    @Column("round_end_time")
    private Instant roundEndTime;

    @Column("user_step")
    private String userStep;

    @Column("round_step")
    private String roundStep;

    @Column("brand")
    private String brand;

    @Column("full_name")
    private String fullName;

    @Column("currency")
    private String currency;

}

