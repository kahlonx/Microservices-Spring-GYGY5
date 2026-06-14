package com.turkcell.user_service.consumer;

import java.util.function.Consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.turkcell.user_service.event.TestEvent;

@Configuration
public class TestEventConsumer {

    @Bean
    public Consumer<TestEvent> consumeTestEvent() {
        return event -> {
            System.out.println("TestEvent İŞLENDİ: " + event.message() + ", Product ID: " + event.productId() + ", Event ID: " + event.eventId());
        };
    }
}
