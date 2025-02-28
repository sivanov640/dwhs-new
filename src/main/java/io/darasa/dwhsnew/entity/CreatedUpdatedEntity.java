package io.darasa.dwhsnew.entity;

import io.darasa.dwhsnew.constants.ColumnName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.Instant;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public abstract class CreatedUpdatedEntity extends BaseEntity {

    @Field(name = ColumnName.Base.CREATED_AT, type = FieldType.Date)
    private Instant createdAt;

    @Field(name = ColumnName.Base.UPDATED_AT, type = FieldType.Date)
    private Instant updatedAt;

}