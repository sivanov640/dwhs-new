package io.darasa.dwhsnew.controller;

import io.darasa.dwhsnew.constants.ColumnName;
import io.darasa.dwhsnew.dto.response.PageResponse;
import io.darasa.dwhsnew.entity.mapped.BaseMap;
import io.darasa.dwhsnew.entity.mapped.Transaction;
import io.darasa.dwhsnew.service.TransactionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("transaction")
@Tag(name = "Transaction Controller")
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping
    @Operation(summary = "Get transactions")
    public PageResponse getTransactions(@RequestParam(defaultValue = "1", required = false) int page,
                                        @RequestParam(defaultValue = "10", required = false) int size,
                                        @Parameter(description = "Find transaction contains provided data in request")
                                        @RequestParam(required = false, value = ColumnName.Transaction.REQUEST) String request,
                                        @Parameter(description = "Find transaction contains provided data in response")
                                        @RequestParam(required = false, value = ColumnName.Transaction.RESPONSE) String response) {
        return transactionService.getAll(page, size, request, response);
    }

    @GetMapping("/schema")
    @Operation(summary = "Get transaction schema")
    public Map<String, Object> getSchema() {
        return BaseMap.getExample(Transaction.fieldMap, Transaction.id);
    }

}
