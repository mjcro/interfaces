package io.github.mjcro.interfaces.experimental.integration;

import io.github.mjcro.interfaces.durations.WithElapsed;

import java.time.temporal.TemporalAccessor;
import java.util.function.Consumer;

/**
 * Marker interface for telemetry consumers.
 *
 * @param <Req>  Request type.
 * @param <Res>  Response type.
 * @param <Meta> Metadata type.
 */
public interface TelemetryConsumer<Req extends Packet, Res extends Packet & WithElapsed, Meta, T extends TemporalAccessor>
        extends Consumer<Telemetry<? extends Req, ? extends Res, ? extends Meta, T>> {
}
