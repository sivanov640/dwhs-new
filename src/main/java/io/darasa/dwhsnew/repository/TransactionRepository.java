package io.darasa.dwhsnew.repository;

import io.darasa.dwhsnew.entity.Transaction;
import io.darasa.dwhsnew.entity.TransactionPrimaryKey;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CassandraRepository<Transaction, TransactionPrimaryKey> {

}
