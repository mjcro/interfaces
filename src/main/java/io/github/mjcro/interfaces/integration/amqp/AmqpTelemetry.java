package io.github.mjcro.interfaces.integration.amqp;

import io.github.mjcro.interfaces.integration.Telemetry;

public interface AmqpTelemetry<Meta> extends Telemetry<AmqpRequest, AmqpResponse, Meta> {
}
