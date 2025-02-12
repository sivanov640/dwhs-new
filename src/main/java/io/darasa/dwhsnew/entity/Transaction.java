package io.darasa.dwhsnew.entity;

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
public class Transaction extends BaseEntity<TransactionPrimaryKey> {

    @Column("request_json")
    private String requestJson;

    @Column("response_json")
    private String responseJson;
}

