package io.github.mjcro.interfaces.integration.amqp;

import io.github.mjcro.interfaces.integration.Packet;

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
     * @return Response.
     */
    default AmqpResponse sendTo(AmqpTransport transport) {
        return transport.send(this);
    }

    /**
     * Publishes request to given transport.
     *
     * @param transport Transport to use.
     */
    default void publishTo(AmqpTransport transport) {
        transport.publish(this);
    }
}
