package io.github.mjcro.interfaces.integration;

import java.util.concurrent.Future;

/**
 * Integration transport (HTTP, TCP, etc.) working over futures.
 *
 * @param <Req> Request type.
 * @param <Res> Response type.
 * @param <T>   Future type.
 */
public interface AsyncTransport<Req, Res, T extends Future<Res>> {
    /**
     * Sends request producing future with response.
     *
     * @param req Request to send.
     * @return Response future.
     */
    T sendAsync(Req req);
}
