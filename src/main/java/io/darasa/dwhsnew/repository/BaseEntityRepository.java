package io.darasa.dwhsnew.repository;

import io.darasa.dwhsnew.entity.BaseEntity;
import lombok.NonNull;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.time.Instant;
import java.util.UUID;

@NoRepositoryBean
public interface BaseEntityRepository<T extends BaseEntity> extends CassandraRepository<T, UUID> {

    default void delete(@NonNull T entity) {
        entity.setDeleted(true);
        entity.setUpdatedAt(Instant.now());
        save(entity);
    }

    default void restore(@NonNull T entity) {
        entity.setDeleted(false);
        entity.setUpdatedAt(Instant.now());
        save(entity);
    }

    default void deleteById(@NonNull UUID id) {
        T entity = findById(id).orElseThrow(() -> new IllegalArgumentException("Entity not found"));
        delete(entity);
    }
}