package io.github.mjcro.interfaces.experimental.integration.http.simple;

import io.github.mjcro.interfaces.experimental.integration.Telemetry;

import java.time.temporal.TemporalAccessor;

public interface HttpTelemetry<Meta, T extends TemporalAccessor> extends Telemetry<HttpRequest, HttpResponse, Meta, T> {
}
