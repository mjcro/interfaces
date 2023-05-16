package io.github.mjcro.interfaces.experimental.integration.amqp;

import java.util.Map;
import java.util.Optional;

public interface Properties {
    Map<String, Object> getHeaders();

    Optional<String> getContentType();

    Optional<String> getContentEncoding();

    Optional<String> getType();

    Optional<String> getMessageId();

    Optional<String> getCorrelationId();

    Optional<String> getReplyTo();

    Optional<Integer> getDeliveryMode();

    Optional<Integer> getPriority();
}
