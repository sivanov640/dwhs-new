package io.darasa.dwhsnew.controller;

import io.darasa.dwhsnew.constants.ColumnName;
import io.darasa.dwhsnew.dto.response.PageResponse;
import io.darasa.dwhsnew.entity.mapped.BaseMap;
import io.darasa.dwhsnew.entity.mapped.Ticket;
import io.darasa.dwhsnew.service.TicketService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("ticket")
@Tag(name = "Ticket Controller")
public class TicketController {

    private final TicketService ticketService;

    @GetMapping
    @Operation(summary = "Get tickets")
    public PageResponse getTickets(@RequestParam(defaultValue = "1", required = false) int page,
                                   @RequestParam(defaultValue = "10", required = false) int size,
                                   @RequestParam(required = false, value = ColumnName.Ticket.TICKET_ID) String ticketId,
                                   @RequestParam(required = false, value = ColumnName.Ticket.ROUND_ID) String roundId,
                                   @RequestParam(required = false, value = ColumnName.Ticket.AGENCY_ID) Integer agencyId,
                                   @RequestParam(required = false, value = ColumnName.Ticket.AGENCY_CODE) String agencyCode,
                                   @RequestParam(required = false, value = ColumnName.Ticket.AGENCY_CODE2) String agencyCode2,
                                   @RequestParam(required = false, value = ColumnName.Ticket.UID) String uid,
                                   @RequestParam(required = false, value = ColumnName.Ticket.UUID) String uuid,
                                   @RequestParam(required = false, value = ColumnName.Ticket.USERNAME) String username,
                                   @RequestParam(required = false, value = ColumnName.Ticket.USER_ID) String userId
    ) {
        return ticketService.getAll(page, size, ticketId, roundId, agencyId, agencyCode, agencyCode2, uid, uuid, username, userId);
    }

    @GetMapping("/schema")
    @Operation(summary = "Get ticket schema")
    public Map<String, Object> getSchema() {
        return BaseMap.getExample(Ticket.fieldMap, Ticket.id);
    }
}
