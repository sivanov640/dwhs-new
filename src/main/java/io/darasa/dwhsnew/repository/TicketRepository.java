package io.darasa.dwhsnew.repository;

import io.darasa.dwhsnew.entity.Ticket;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends CassandraRepository<Ticket, String> {

}
