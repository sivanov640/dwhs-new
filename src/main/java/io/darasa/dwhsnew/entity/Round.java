package io.darasa.dwhsnew.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.Indexed;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.Instant;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table("round")
public class Round extends BaseEntity {
    @Column("result")
    private String result;

    @Indexed
    @Column("start_time")
    private Instant startTime;

    @Indexed
    @Column("end_time")
    private Instant endTime;

    @Column("round_step")
    private Instant round_step;
}

