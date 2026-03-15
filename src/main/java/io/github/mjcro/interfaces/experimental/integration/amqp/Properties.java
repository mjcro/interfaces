package io.github.mjcro.interfaces.experimental.integration.amqp;

import java.util.Map;
import java.util.Optional;

/**
 * AMQP message properties including headers, content type, delivery mode, and other metadata.
 */
public interface Properties {
    /**
     * @return Custom message headers.
     */
    Map<String, Object> getHeaders();

    /**
     * @return Content type of the message body.
     */
    Optional<String> getContentType();

    /**
     * @return Content encoding of the message body.
     */
    Optional<String> getContentEncoding();

    /**
     * @return Message type identifier.
     */
    Optional<String> getType();

    /**
     * @return Message identifier.
     */
    Optional<String> getMessageId();

    /**
     * @return Correlation identifier, used to correlate responses with requests.
     */
    Optional<String> getCorrelationId();

    /**
     * @return Queue name to send the reply to.
     */
    Optional<String> getReplyTo();

    /**
     * @return Delivery mode (1 = non-persistent, 2 = persistent).
     */
    Optional<Integer> getDeliveryMode();

    /**
     * @return Message priority.
     */
    Optional<Integer> getPriority();
}
