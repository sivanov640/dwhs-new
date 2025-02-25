package io.darasa.dwhsnew.controller;

import io.darasa.dwhsnew.constants.ColumnName;
import io.darasa.dwhsnew.dto.request.TransactionDto;
import io.darasa.dwhsnew.dto.response.PageResponse;
import io.darasa.dwhsnew.service.TransactionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("transaction")
@Tag(name = "Transaction Controller")
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping
    @Operation(summary = "Get transactions")
    public PageResponse<TransactionDto> getTransactions(@RequestParam(defaultValue = "1", required = false) int page,
                                                        @RequestParam(defaultValue = "10", required = false) int size,
                                                        @RequestParam(required = false, value = ColumnName.Transaction.GAME_ID) String gameId,
                                                        @RequestParam(required = false, value = ColumnName.Transaction.TICKET_ID) String ticketId,
                                                        @RequestParam(required = false, value = ColumnName.Transaction.AGENCY_ID) String agencyId,
                                                        @RequestParam(required = false, value = ColumnName.Transaction.MEMBER_ID) String memberId) {
        return transactionService.getAll(page, size, gameId, ticketId, agencyId, memberId);
    }

}
