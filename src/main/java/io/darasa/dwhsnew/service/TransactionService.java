package io.darasa.dwhsnew.service;

import io.darasa.dwhsnew.constants.ColumnName;
import io.darasa.dwhsnew.constants.Type;
import io.darasa.dwhsnew.dto.request.TransactionDto;
import io.darasa.dwhsnew.dto.response.PageResponse;
import io.darasa.dwhsnew.entity.Transaction;
import io.darasa.dwhsnew.entity.TransactionPrimaryKey;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.cassandra.core.query.Criteria;
import org.springframework.data.cassandra.core.query.CriteriaDefinition;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class TransactionService extends BaseService<Transaction, TransactionPrimaryKey, TransactionDto> {

    public TransactionService() {
        super(Type.TRANSACTION);
    }

    public PageResponse<TransactionDto> getAll(int page, int size, String gameId, String ticketId, String agencyId, String memberId) {
        List<CriteriaDefinition> criteriaDefinitions = new ArrayList<>();
        if (gameId != null) {
            criteriaDefinitions.add(Criteria.where(ColumnName.Transaction.GAME_ID).is(gameId));
        }
        if (ticketId != null) {
            criteriaDefinitions.add(Criteria.where(ColumnName.Transaction.TICKET_ID).is(ticketId));
        }
        if (agencyId != null) {
            criteriaDefinitions.add(Criteria.where(ColumnName.Transaction.AGENCY_ID).is(agencyId));
        }
        if (memberId != null) {
            criteriaDefinitions.add(Criteria.where(ColumnName.Transaction.MEMBER_ID).is(memberId));
        }

        return super.getAll(page, size, criteriaDefinitions);
    }
}