package io.darasa.dwhsnew.listener;

import io.darasa.dwhsnew.dto.request.DroppedDto;
import io.darasa.dwhsnew.service.DroppedService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static io.darasa.dwhsnew.configuration.RabbitMQConfig.DLQ_QUEUE;

@Component
@RequiredArgsConstructor
public class DlqQueueListener {

    private final DroppedService droppedService;

    @RabbitListener(queues = DLQ_QUEUE)
    public void listen(@Payload String message) {
        droppedService.save(DroppedDto.of(message));
    }
}