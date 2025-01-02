package io.github.mjcro.interfaces.experimental.integration;

import java.util.concurrent.Future;

/**
 * Defines factories able to produce transports.
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
    T getAsyncTransport(Option... options);
}
