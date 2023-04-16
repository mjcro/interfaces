package io.github.mjcro.interfaces.integration.amqp;

import io.github.mjcro.interfaces.durations.WithElapsed;
import io.github.mjcro.interfaces.integration.Packet;

public interface AmqpResponse extends Packet, WithElapsed {
    /**
     * @return Queue name.
     */
    String getQueue();

    /**
     * @return AMQP properties.
     */
    Properties getProperties();
}
