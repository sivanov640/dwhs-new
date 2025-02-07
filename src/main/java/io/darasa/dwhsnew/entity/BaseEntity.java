package io.darasa.dwhsnew.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.Indexed;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;

import java.time.Instant;
import java.util.UUID;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = "id")
public class BaseEntity {

    @Builder.Default
    @PrimaryKey("id")
    private UUID id = UUID.randomUUID();

    @Indexed
    @Column("table_id")
    private UUID tableId;

    @Indexed
    @Column("deleted")
    private boolean deleted;

    @Indexed
    @Column("created_by")
    private String createdBy;

    @Indexed
    @Builder.Default
    @Column("created_at")
    private Instant createdAt = Instant.now();

    @Builder.Default
    @Column("updated_at")
    private Instant updatedAt = Instant.now();
}