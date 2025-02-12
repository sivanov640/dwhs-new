package io.darasa.dwhsnew.service;

import io.darasa.dwhsnew.constants.Type;
import io.darasa.dwhsnew.dto.request.TicketDto;
import io.darasa.dwhsnew.entity.Ticket;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TicketService extends BaseService<Ticket, String, TicketDto> {

    public TicketService() {
        super(Type.TICKET);
    }
}