package io.darasa.dwhsnew.controller;

import io.darasa.dwhsnew.dto.request.TicketDto;
import io.darasa.dwhsnew.dto.response.PageResponse;
import io.darasa.dwhsnew.service.TicketService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("ticket")
@Tag(name = "Ticket Controller")
public class TicketController {

    private final TicketService ticketService;

    @GetMapping
    @Operation(summary = "Get all tickets")
    public PageResponse<TicketDto> getTickets(@RequestParam(defaultValue = "1") int page,
                                              @RequestParam(defaultValue = "10") int size) {
        return ticketService.getAll(page, size);
    }

    @PostMapping
    @Operation(summary = "Save ticket")
    public String saveTicket(@RequestBody TicketDto dto) {
        return ticketService.save(dto);
    }

}
