package io.darasa.dwhsnew.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.darasa.dwhsnew.constants.ColumnName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class TransactionDto extends CreatedUpdatedDto {

    @JsonProperty(ColumnName.Transaction.TRANSACTION_ID)
    private String transactionId;
    @JsonProperty(ColumnName.Transaction.REQUEST)
    private String request;
    @JsonProperty(ColumnName.Transaction.RESPONSE)
    private String response;

}

