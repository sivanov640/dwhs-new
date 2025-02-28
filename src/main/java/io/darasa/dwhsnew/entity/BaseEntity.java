package io.darasa.dwhsnew.entity;

import io.darasa.dwhsnew.constants.ColumnName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.Instant;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseEntity implements Persistable<String> {

    @CreatedDate
    @Field(name = ColumnName.Base._CREATED_AT, type = FieldType.Date, format = DateFormat.date_optional_time)
    private Instant _createdAt;

    @LastModifiedDate
    @Field(name = ColumnName.Base._UPDATED_AT, type = FieldType.Date, format = DateFormat.date_optional_time)
    private Instant _updatedAt;

    @Override
    public boolean isNew() {
        return getId() == null || _createdAt == null;
    }

}