package io.github.mjcro.interfaces.integration.amqp;

import io.github.mjcro.interfaces.integration.Transport;

public interface AmqpTransport extends Transport<AmqpRequest, AmqpResponse> {
    /**
     * Publishes request and does not wait for response.
     *
     * @param request Data to send.
     */
    void publish(AmqpRequest request);
}
