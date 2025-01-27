package io.github.mjcro.interfaces.experimental.integration.amqp;

import io.github.mjcro.interfaces.experimental.integration.Telemetry;

import java.time.temporal.Temporal;

public interface AmqpTelemetry<Meta, T extends Temporal> extends Telemetry<AmqpRequest, AmqpResponse, Meta, T> {
}
