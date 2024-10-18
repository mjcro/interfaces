package io.github.mjcro.interfaces.experimental.integration.amqp;

import io.github.mjcro.interfaces.experimental.integration.Telemetry;

import java.time.temporal.TemporalAccessor;

public interface AmqpTelemetry<Meta, T extends TemporalAccessor> extends Telemetry<AmqpRequest, AmqpResponse, Meta, T> {
}
