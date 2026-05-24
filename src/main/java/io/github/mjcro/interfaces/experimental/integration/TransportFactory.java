package io.github.mjcro.interfaces.experimental.integration;

import org.jspecify.annotations.NonNull;


/**
 * Defines factories that produce transports.
 *
 * @param <Req> Request type.
 * @param <Res> Response type.
 */
public interface TransportFactory<Req, Res> {
    /**
     * Constructs transport instance.
     *
     * @param options Addition transport options.
     * @return Transport instance.
     */
    @NonNull Transport<@NonNull Req, @NonNull Res> getTransport(@NonNull Option... options);
}
