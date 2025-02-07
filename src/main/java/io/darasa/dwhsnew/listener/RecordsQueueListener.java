package io.darasa.dwhsnew.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.darasa.dwhsnew.constants.Type;
import io.darasa.dwhsnew.dto.request.BaseDto;
import io.darasa.dwhsnew.entity.BaseEntity;
import io.darasa.dwhsnew.exception.InvalidRequestException;
import io.darasa.dwhsnew.service.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class RecordsQueueListener {

    private final ObjectMapper objectMapper;

    private final Map<String, BaseService<? extends BaseEntity, ? extends BaseDto>> serviceMap;

    @RabbitListener(queues = "records-queue")
    public void listen(@Payload String message, @Header String type) {
        Type requiredType = Type.getType(type);

        serviceMap.values().stream()
                .filter(service -> service.getType().equals(requiredType))
                .limit(1)
                .forEach(service -> {
                    try {
                        var baseDto = objectMapper.readValue(message, service.getType().getDtoClass());
                        @SuppressWarnings("unchecked")
                        BaseService<BaseEntity, BaseDto> typedService = (BaseService<BaseEntity, BaseDto>) service;
                        typedService.save(baseDto);
                    } catch (JsonProcessingException e) {
                        throw new InvalidRequestException("Can't parse message to " + requiredType.getDtoClass().getSimpleName());
                    }
                });
    }
}