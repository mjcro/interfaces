package io.github.mjcro.interfaces.experimental.integration.amqp;

import io.github.mjcro.interfaces.experimental.integration.Option;
import io.github.mjcro.interfaces.experimental.integration.Transport;
import org.jspecify.annotations.NonNull;

/**
 * Synchronous AMQP transport supporting both request-response and fire-and-forget (publish) patterns.
 */
public interface AmqpTransport extends Transport<AmqpRequest, AmqpResponse> {
    /**
     * Publishes request and does not wait for response.
     *
     * @param request Data to send.
     * @param options Transport options.
     */
    void publish(@NonNull AmqpRequest request, @NonNull Option... options);
}
