package io.darasa.dwhsnew.entity;

import io.darasa.dwhsnew.constants.ColumnName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.cassandra.core.mapping.Column;

import java.time.Instant;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CreatedUpdatedEntity<T> extends BaseEntity<T> {

    @Column(ColumnName.Base.CREATED_AT)
    private Instant createdAt;

    @Column(ColumnName.Base.UPDATED_AT)
    private Instant updatedAt;
}