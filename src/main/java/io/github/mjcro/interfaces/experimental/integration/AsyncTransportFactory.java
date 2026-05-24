package io.github.mjcro.interfaces.experimental.integration;

import org.jspecify.annotations.NonNull;

import java.util.concurrent.Future;

/**
 * Defines factories that produce transports.
 *
 * @param <Req> Request type.
 * @param <Res> Response type.
 * @param <F>   Future type.
 * @param <T>   Transport type.
 */
public interface AsyncTransportFactory<Req, Res, F extends Future<Res>, T extends AsyncTransport<Req, Res, F>> {
    /**
     * Constructs transport instance.
     *
     * @param options Addition transport options.
     * @return Transport instance.
     */
    @NonNull T getAsyncTransport(@NonNull Option... options);
}
