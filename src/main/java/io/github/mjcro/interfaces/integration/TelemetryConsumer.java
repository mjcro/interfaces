package io.github.mjcro.interfaces.integration;

import io.github.mjcro.interfaces.durations.WithElapsed;

import java.util.function.Consumer;

/**
 * Marker interface for telemetry consumers.
 *
 * @param <Req>  Request type.
 * @param <Res>  Response type.
 * @param <Meta> Metadata type.
 */
public interface TelemetryConsumer<Req extends Packet, Res extends Packet & WithElapsed, Meta>
        extends Consumer<Telemetry<? extends Req, ? extends Res, ? extends Meta>> {
}
