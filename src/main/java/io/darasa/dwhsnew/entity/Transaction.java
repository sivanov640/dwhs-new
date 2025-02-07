package io.darasa.dwhsnew.entity;

import io.darasa.dwhsnew.constants.TicketStatus;
import io.darasa.dwhsnew.constants.TxAction;
import io.darasa.dwhsnew.constants.TxOption;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.Table;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table("transaction")
public class Transaction extends BaseEntity {

    @Column("member_id")
    private long memberId;

    @Column("ticket_id")
    private String ticketId;

    @Column("amount")
    private double amount;

    @Column("action")
    private TxAction action;

    @Column("option")
    private TxOption option;

    @Column("ticket_status")
    private TicketStatus ticketStatus;

    @Column("error_code")
    private int errorCode;

    @Column("payload")
    private String payload;

    @Column("response")
    private String response;

    @Column("note")
    private String note;
}

