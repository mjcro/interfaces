package io.github.mjcro.interfaces.experimental.integration.amqp;

import io.github.mjcro.interfaces.durations.WithElapsed;
import io.github.mjcro.interfaces.experimental.integration.Packet;
import org.jspecify.annotations.NonNull;

/**
 * Represents an AMQP response packet received from an AMQP transport.
 */
public interface AmqpResponse extends Packet, WithElapsed {
    /**
     * @return Queue name.
     */
    @NonNull String getQueue();

    /**
     * @return AMQP properties.
     */
    @NonNull Properties getProperties();
}
