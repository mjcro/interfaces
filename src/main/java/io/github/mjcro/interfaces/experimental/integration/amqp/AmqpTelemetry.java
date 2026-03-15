package io.github.mjcro.interfaces.experimental.integration.amqp;

import io.github.mjcro.interfaces.experimental.integration.Telemetry;

import java.time.temporal.Temporal;

/**
 * Telemetry specialization for AMQP request/response pairs.
 *
 * @param <Meta> Metadata type.
 * @param <T>    Temporal type for the creation timestamp.
 */
public interface AmqpTelemetry<Meta, T extends Temporal> extends Telemetry<AmqpRequest, AmqpResponse, Meta, T> {
}
