package io.darasa.dwhsnew.listener;

import io.darasa.dwhsnew.dto.request.UnknownDto;
import io.darasa.dwhsnew.service.UnknownService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static io.darasa.dwhsnew.configuration.RabbitMQConfig.DLQ_QUEUE;

@Component
@RequiredArgsConstructor
public class DlqQueueListener {

    private final UnknownService unknownService;

    @RabbitListener(queues = DLQ_QUEUE)
    public void listen(@Payload String message) {
        unknownService.save(UnknownDto.of(message));
    }
}