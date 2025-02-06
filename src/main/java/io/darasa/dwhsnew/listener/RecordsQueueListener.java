package io.darasa.dwhsnew.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.darasa.dwhsnew.entity.Round;
import io.darasa.dwhsnew.service.RoundService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RecordsQueueListener {

    private final ObjectMapper objectMapper;

    private final RoundService roundService;

    @RabbitListener(queues = "records-queue")
    public void listen(@Payload String message, @Header(required = false) String type) throws JsonProcessingException {
        switch (Type.getType(type)) {
            case ROUND:
                roundService.create(objectMapper.readValue(message, Round.class));
                break;
            case TRANSACTION:
                break;
            case TICKET:
                break;
        }
    }
}