package io.darasa.dwhsnew.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.darasa.dwhsnew.constants.Type;
import io.darasa.dwhsnew.exception.InvalidRequestException;
import io.darasa.dwhsnew.service.BaseService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;

import static io.darasa.dwhsnew.configuration.RabbitMQConfig.RECORDS_QUEUE;

@Component
@RequiredArgsConstructor
public class RecordsQueueListener {

    private final ObjectMapper objectMapper;

    private final ElasticsearchTemplate elasticsearchTemplate;

    private final Map<String, BaseService> serviceMap;

    @RabbitListener(queues = RECORDS_QUEUE)
    public void listen(@Payload(required = false) String message, @Header(required = false) String type) {
        if (StringUtils.isBlank(message)) {
            throw new InvalidRequestException("Message must not be blank");
        }
        Type requiredType = Type.getType(type);
        serviceMap.values().stream()
                .filter(service -> service.getType().equals(requiredType))
                .limit(1)
                .forEach(service -> service.save(message));
    }
}