package io.darasa.dwhsnew.service;

import io.darasa.dwhsnew.constants.ColumnName;
import io.darasa.dwhsnew.constants.Type;
import io.darasa.dwhsnew.dto.request.TicketDto;
import io.darasa.dwhsnew.dto.response.PageResponse;
import io.darasa.dwhsnew.entity.Ticket;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class TicketService extends BaseService<Ticket, TicketDto> {

    public TicketService() {
        super(Type.TICKET);
    }

    public PageResponse<TicketDto> getAll(int page, int size, String id, String roundId, Integer agencyId, String agencyCode, String agencyCode2, String uid, String uuid, String username, String userId) {
        List<Criteria> criteriaList = new ArrayList<>();
        if (id != null) {
            criteriaList.add(Criteria.where(ColumnName.Ticket.TICKET_ID).is(id));
        }
        if (roundId != null) {
            criteriaList.add(Criteria.where(ColumnName.Ticket.ROUND_ID).is(roundId));
        }
        if (agencyId != null) {
            criteriaList.add(Criteria.where(ColumnName.Ticket.AGENCY_ID).is(agencyId));
        }
        if (agencyCode != null) {
            criteriaList.add(Criteria.where(ColumnName.Ticket.AGENCY_CODE).is(agencyCode));
        }
        if (agencyCode2 != null) {
            criteriaList.add(Criteria.where(ColumnName.Ticket.AGENCY_CODE2).is(agencyCode2));
        }
        if (uid != null) {
            criteriaList.add(Criteria.where(ColumnName.Ticket.UID).is(uid));
        }
        if (uuid != null) {
            criteriaList.add(Criteria.where(ColumnName.Ticket.UUID).is(uuid));
        }
        if (username != null) {
            criteriaList.add(Criteria.where(ColumnName.Ticket.USERNAME).is(username));
        }
        if (userId != null) {
            criteriaList.add(Criteria.where(ColumnName.Ticket.USER_ID).is(userId));
        }

        return getAll(page, size, criteriaList);
    }

}