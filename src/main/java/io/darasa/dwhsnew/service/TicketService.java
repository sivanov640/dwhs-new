package io.darasa.dwhsnew.service;

import io.darasa.dwhsnew.constants.ColumnName;
import io.darasa.dwhsnew.constants.Type;
import io.darasa.dwhsnew.dto.request.TicketDto;
import io.darasa.dwhsnew.dto.response.PageResponse;
import io.darasa.dwhsnew.entity.Ticket;
import io.darasa.dwhsnew.entity.TicketPrimaryKey;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.cassandra.core.query.Criteria;
import org.springframework.data.cassandra.core.query.CriteriaDefinition;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class TicketService extends BaseService<Ticket, TicketPrimaryKey, TicketDto> {

    public TicketService() {
        super(Type.TICKET);
    }

    public PageResponse<TicketDto> getAll(int page, int size, String id, String roundId) {
        List<CriteriaDefinition> criteriaDefinitions = new ArrayList<>();
        if (id != null) {
            criteriaDefinitions.add(Criteria.where(ColumnName.Ticket.TICKET_ID).is(id));
        }
        if (roundId != null) {
            criteriaDefinitions.add(Criteria.where(ColumnName.Ticket.ROUND_ID).is(roundId));
        }

        return getAll(page, size, criteriaDefinitions);
    }

}