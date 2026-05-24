package io.github.mjcro.interfaces.experimental.integration.amqp;

import io.github.mjcro.interfaces.experimental.integration.Option;
import io.github.mjcro.interfaces.experimental.integration.Packet;
import org.jspecify.annotations.NonNull;

import java.util.Optional;

/**
 * Represents an AMQP request packet that can be sent or published via an AMQP transport.
 */
public interface AmqpRequest extends Packet {
    /**
     * @return Exchange name to send packet to.
     */
    @NonNull Optional<@NonNull String> getExchange();

    /**
     * @return Routing key.
     */
    @NonNull Optional<@NonNull String> getRoutingKey();

    /**
     * @return Request properties.
     */
    @NonNull Optional<@NonNull Properties> getProperties();

    /**
     * Sends this request using given transport.
     *
     * @param transport Transport to use.
     * @param options   Transport options.
     * @return Response.
     */
    default @NonNull AmqpResponse sendTo(@NonNull AmqpTransport transport, @NonNull Option... options) {
        return transport.send(this, options);
    }

    /**
     * Publishes request to given transport.
     *
     * @param transport Transport to use.
     * @param options   Transport options.
     */
    default void publishTo(@NonNull AmqpTransport transport, @NonNull Option... options) {
        transport.publish(this, options);
    }
}
