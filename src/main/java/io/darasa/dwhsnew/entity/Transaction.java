package io.darasa.dwhsnew.entity;

import io.darasa.dwhsnew.constants.ColumnName;
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

    @Column(ColumnName.Transaction.REQUEST_JSON)
    private String requestJson;

    @Column(ColumnName.Transaction.RESPONSE_JSON)
    private String responseJson;

}

