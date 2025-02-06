package io.darasa.dwhsnew.configuration;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue recordsQueue() {
        return QueueBuilder.durable("records-queue")
                .deadLetterExchange("dlx-exchange")
                .build();
    }

    @Bean
    public FanoutExchange recordsExchange() {
        return new FanoutExchange("records-exchange");
    }

    @Bean
    public Binding recordsBinding() {
        return BindingBuilder.bind(recordsQueue())
                .to(recordsExchange());
    }

    @Bean
    public Queue deadLetterQueue() {
        return QueueBuilder.durable("dlq-queue").build();
    }

    @Bean
    public FanoutExchange deadLetterExchange() {
        return new FanoutExchange("dlx-exchange");
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