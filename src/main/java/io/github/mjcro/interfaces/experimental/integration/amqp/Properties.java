package io.github.mjcro.interfaces.experimental.integration.amqp;

import org.jspecify.annotations.NonNull;

import java.util.Map;
import java.util.Optional;

/**
 * AMQP message properties including headers, content type, delivery mode, and other metadata.
 */
public interface Properties {
    /**
     * Returns the custom AMQP message headers.
     *
     * @return Custom message headers.
     */
    @NonNull Map<@NonNull String, @NonNull Object> getHeaders();

    /**
     * Returns the AMQP message content type.
     *
     * @return Content type of the message body.
     */
    @NonNull Optional<@NonNull String> getContentType();

    /**
     * Returns the AMQP message content encoding.
     *
     * @return Content encoding of the message body.
     */
    @NonNull Optional<@NonNull String> getContentEncoding();

    /**
     * Returns the AMQP message type identifier.
     *
     * @return Message type identifier.
     */
    @NonNull Optional<@NonNull String> getType();

    /**
     * Returns the AMQP message identifier.
     *
     * @return Message identifier.
     */
    @NonNull Optional<@NonNull String> getMessageId();

    /**
     * Returns the AMQP correlation identifier.
     *
     * @return Correlation identifier, used to correlate responses with requests.
     */
    @NonNull Optional<@NonNull String> getCorrelationId();

    /**
     * Returns the AMQP reply queue name.
     *
     * @return Reply queue name.
     */
    @NonNull Optional<@NonNull String> getReplyTo();

    /**
     * Returns the AMQP delivery mode.
     *
     * @return Delivery mode (1 = non-persistent, 2 = persistent).
     */
    @NonNull Optional<@NonNull Integer> getDeliveryMode();

    /**
     * Returns the AMQP message priority.
     *
     * @return Message priority.
     */
    @NonNull Optional<@NonNull Integer> getPriority();
}
