package io.darasa.dwhsnew.service;

import io.darasa.dwhsnew.constants.ColumnName;
import io.darasa.dwhsnew.constants.Type;
import io.darasa.dwhsnew.dto.request.TransactionDto;
import io.darasa.dwhsnew.dto.response.PageResponse;
import io.darasa.dwhsnew.entity.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class TransactionService extends BaseService<Transaction, TransactionDto> {

    public TransactionService() {
        super(Type.TRANSACTION);
    }

    public PageResponse<TransactionDto> getAll(int page, int size, String request, String response) {
        List<Criteria> criteriaList = new ArrayList<>();
        if (request != null) {
            criteriaList.add(Criteria.where(ColumnName.Transaction.REQUEST).contains(request));
        }
        if (response != null) {
            criteriaList.add(Criteria.where(ColumnName.Transaction.RESPONSE).contains(response));
        }

        return super.getAll(page, size, criteriaList);
    }
}