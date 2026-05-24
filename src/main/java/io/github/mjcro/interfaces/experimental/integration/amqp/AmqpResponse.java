package io.github.mjcro.interfaces.experimental.integration.amqp;

import io.github.mjcro.interfaces.durations.WithElapsed;
import io.github.mjcro.interfaces.experimental.integration.Packet;
import org.jspecify.annotations.NonNull;

/**
 * Represents an AMQP response packet received from an AMQP transport.
 */
public interface AmqpResponse extends Packet, WithElapsed {
    /**
     * Returns the AMQP response queue name.
     *
     * @return AMQP response queue name.
     */
    @NonNull String getQueue();

    /**
     * Returns the AMQP message properties.
     *
     * @return AMQP properties.
     */
    @NonNull Properties getProperties();
}
