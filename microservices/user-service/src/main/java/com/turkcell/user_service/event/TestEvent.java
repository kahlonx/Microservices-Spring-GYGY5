package com.turkcell.user_service.event;
import java.util.UUID;


public record TestEvent(UUID eventId, String message, UUID productId) {}
