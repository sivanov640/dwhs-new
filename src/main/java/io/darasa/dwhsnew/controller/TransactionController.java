package io.darasa.dwhsnew.controller;

import io.darasa.dwhsnew.dto.request.TransactionDto;
import io.darasa.dwhsnew.dto.response.PageResponse;
import io.darasa.dwhsnew.service.TransactionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("transaction")
@Tag(name = "Transaction Controller")
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping
    @Operation(summary = "Get all transactions")
    public PageResponse<TransactionDto> getTransactions(@RequestParam(defaultValue = "1") int page,
                                                        @RequestParam(defaultValue = "10") int size) {
        return transactionService.getAll(page, size);
    }

    @PostMapping
    @Operation(summary = "Save transaction")
    public String saveTransaction(@RequestBody TransactionDto dto) {
        return transactionService.save(dto);
    }

}
