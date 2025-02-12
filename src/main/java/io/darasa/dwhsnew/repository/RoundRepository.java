package io.darasa.dwhsnew.repository;

import io.darasa.dwhsnew.entity.Round;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoundRepository extends CassandraRepository<Round, String> {

}
