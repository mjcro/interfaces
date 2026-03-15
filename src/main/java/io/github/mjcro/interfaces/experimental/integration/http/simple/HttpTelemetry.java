package io.github.mjcro.interfaces.experimental.integration.http.simple;

import io.github.mjcro.interfaces.experimental.integration.Telemetry;

import java.time.temporal.Temporal;

/**
 * Telemetry interface specialized for HTTP request/response pairs.
 *
 * @param <Meta> Type of arbitrary metadata associated with the telemetry entry.
 * @param <T>    Temporal type used for the creation timestamp.
 */
public interface HttpTelemetry<Meta, T extends Temporal> extends Telemetry<HttpRequest, HttpResponse, Meta, T> {
}
