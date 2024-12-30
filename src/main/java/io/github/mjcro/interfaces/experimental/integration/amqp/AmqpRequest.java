package io.github.mjcro.interfaces.experimental.integration.amqp;

import io.github.mjcro.interfaces.experimental.integration.Option;
import io.github.mjcro.interfaces.experimental.integration.Packet;

import java.util.Optional;

public interface AmqpRequest extends Packet {
    /**
     * @return Exchange name to send packet to.
     */
    Optional<String> getExchange();

    /**
     * @return Routing key.
     */
    Optional<String> getRoutingKey();

    /**
     * @return Request properties.
     */
    Optional<Properties> getProperties();

    /**
     * Sends this request using given transport.
     *
     * @param transport Transport to use.
     * @param options   Transport options.
     * @return Response.
     */
    default AmqpResponse sendTo(AmqpTransport transport, Option... options) {
        return transport.send(this, options);
    }

    /**
     * Publishes request to given transport.
     *
     * @param transport Transport to use.
     * @param options   Transport options.
     */
    default void publishTo(AmqpTransport transport, Option... options) {
        transport.publish(this, options);
    }
}
