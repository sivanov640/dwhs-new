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

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TypeAlias("transaction")
@Document(indexName = "transaction")
public class Transaction extends CreatedUpdatedEntity {

    @Field(ColumnName.Transaction.TRANSACTION_ID)
    private String transactionId;

    @Field(ColumnName.Transaction.REQUEST)
    private String request;

    @Field(ColumnName.Transaction.RESPONSE)
    private String response;

    @Override
    public String getId() {
        return transactionId;
    }
}

