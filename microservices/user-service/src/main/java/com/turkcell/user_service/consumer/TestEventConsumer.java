package com.turkcell.user_service.consumer;

import java.time.Instant;
import java.util.function.Consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.turkcell.user_service.entity.ProcessedEvent;
import com.turkcell.user_service.event.TestEvent;
import com.turkcell.user_service.repository.ProcessedEventRepository;

@Configuration
public class TestEventConsumer {
    private final ProcessedEventRepository processedEventRepository;

    public TestEventConsumer(ProcessedEventRepository processedEventRepository) {
        this.processedEventRepository = processedEventRepository;
    }



    @Bean
    public Consumer<TestEvent> consumeTestEvent() {
        return event -> {
            var processedEvent = processedEventRepository.findById(event.eventId()).orElse(null);

            if(processedEvent != null) {
                System.out.println("Bu event zaten işlendi: " + event.eventId());
                return;
            }

            System.out.println("TestEvent İŞLENDİ: " + event.message() + ", Product ID: " + event.productId() + ", Event ID: " + event.eventId());
        
            processedEvent = new ProcessedEvent();
            processedEvent.setEventId(event.eventId());
            processedEvent.setProcessedAt(Instant.now());
            processedEventRepository.save(processedEvent);
        };
    }
}
