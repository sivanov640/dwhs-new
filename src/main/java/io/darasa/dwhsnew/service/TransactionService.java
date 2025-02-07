package io.darasa.dwhsnew.service;

import io.darasa.dwhsnew.constants.Type;
import io.darasa.dwhsnew.dto.request.TransactionDto;
import io.darasa.dwhsnew.entity.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TransactionService extends BaseService<Transaction, TransactionDto> {

    public TransactionService() {
        super(Type.TRANSACTION);
    }
}