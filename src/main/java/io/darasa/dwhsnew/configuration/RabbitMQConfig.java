package io.darasa.dwhsnew.configuration;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {


    public static final String RECORDS_EXCHANGE = "records-exchange";
    public static final String RECORDS_QUEUE = "records-queue";
    public static final String RECORDS_ROUTING_KEY = "records";
    public static final String DLX_EXCHANGE = "dlx-exchange";
    public static final String DLQ_QUEUE = "dlq-queue";

    @Bean
    public Queue recordsQueue() {
        return QueueBuilder.durable(RECORDS_QUEUE)
                .deadLetterExchange(DLX_EXCHANGE)
                .build();
    }

    @Bean
    public DirectExchange recordsExchange() {
        return new DirectExchange(RECORDS_EXCHANGE);
    }

    @Bean
    public Binding recordsBinding() {
        return BindingBuilder.bind(recordsQueue())
                .to(recordsExchange())
                .with(RECORDS_ROUTING_KEY);
    }

    @Bean
    public Queue deadLetterQueue() {
        return QueueBuilder.durable(DLQ_QUEUE).build();
    }

    @Bean
    public FanoutExchange deadLetterExchange() {
        return new FanoutExchange(DLX_EXCHANGE);
    }

    @Bean
    public Binding dlqBinding() {
        return BindingBuilder.bind(deadLetterQueue())
                .to(deadLetterExchange());
    }

    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setDefaultRequeueRejected(false);
        return factory;
    }

}