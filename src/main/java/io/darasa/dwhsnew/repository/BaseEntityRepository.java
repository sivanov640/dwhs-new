package io.darasa.dwhsnew.repository;

import io.darasa.dwhsnew.entity.BaseEntity;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.UUID;

@NoRepositoryBean
public interface BaseEntityRepository<T extends BaseEntity> extends CassandraRepository<T, UUID> {
}