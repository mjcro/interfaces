package io.github.mjcro.interfaces.experimental.integration.amqp;

import io.github.mjcro.interfaces.experimental.integration.AsyncTransport;
import io.github.mjcro.interfaces.experimental.integration.Option;

import java.util.concurrent.Future;

public interface AmqpAsyncTransport<T extends Future<AmqpResponse>> extends AsyncTransport<AmqpRequest, AmqpResponse, T> {
    /**
     * Publishes request and does not wait for response.
     *
     * @param request Data to send.
     * @param options Transport options.
     */
    void publish(AmqpRequest request, Option... options);
}
