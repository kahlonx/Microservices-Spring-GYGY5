package com.turkcell.product_service.controller;

import java.util.UUID;

import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.product_service.event.TestEvent;

@RequestMapping("/api/products")
@RestController
public class ProductsController {
    private final StreamBridge streamBridge;

    public ProductsController(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    @GetMapping
    public String test(@RequestParam String message) {
        UUID id = UUID.randomUUID();
        UUID eventId = UUID.randomUUID();
        var event = new TestEvent(eventId, message, id);

        // Publish the event directly to Kafka via Spring Cloud Stream (no CDC/outbox).
        streamBridge.send("testEvent-out-0", event);

        return "Başarılı";
    }
}
