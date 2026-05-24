package io.github.mjcro.interfaces.experimental.integration.amqp;

import org.jspecify.annotations.NonNull;

import java.util.Map;
import java.util.Optional;

/**
 * AMQP message properties including headers, content type, delivery mode, and other metadata.
 */
public interface Properties {
    /**
     * @return Custom message headers.
     */
    @NonNull Map<@NonNull String, @NonNull Object> getHeaders();

    /**
     * @return Content type of the message body.
     */
    @NonNull Optional<@NonNull String> getContentType();

    /**
     * @return Content encoding of the message body.
     */
    @NonNull Optional<@NonNull String> getContentEncoding();

    /**
     * @return Message type identifier.
     */
    @NonNull Optional<@NonNull String> getType();

    /**
     * @return Message identifier.
     */
    @NonNull Optional<@NonNull String> getMessageId();

    /**
     * @return Correlation identifier, used to correlate responses with requests.
     */
    @NonNull Optional<@NonNull String> getCorrelationId();

    /**
     * @return Queue name to send the reply to.
     */
    @NonNull Optional<@NonNull String> getReplyTo();

    /**
     * @return Delivery mode (1 = non-persistent, 2 = persistent).
     */
    @NonNull Optional<@NonNull Integer> getDeliveryMode();

    /**
     * @return Message priority.
     */
    @NonNull Optional<@NonNull Integer> getPriority();
}
