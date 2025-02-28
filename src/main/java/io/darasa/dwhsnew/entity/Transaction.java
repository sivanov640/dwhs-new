package io.darasa.dwhsnew.entity;

import io.darasa.dwhsnew.constants.ColumnName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.util.UUID;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Document(indexName = "transaction")
public class Transaction extends CreatedUpdatedEntity {

    @Id
    private final String id = UUID.randomUUID().toString();

    @Field(ColumnName.Transaction.REQUEST)
    private String request;

    @Field(ColumnName.Transaction.RESPONSE)
    private String response;

}

