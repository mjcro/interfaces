package io.github.mjcro.interfaces.experimental.integration.http.simple;

import io.github.mjcro.interfaces.experimental.integration.Telemetry;

import java.time.temporal.Temporal;

public interface HttpTelemetry<Meta, T extends Temporal> extends Telemetry<HttpRequest, HttpResponse, Meta, T> {
}
