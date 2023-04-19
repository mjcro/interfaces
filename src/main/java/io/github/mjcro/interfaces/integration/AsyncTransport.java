package io.github.mjcro.interfaces.integration;

import java.util.concurrent.Future;

/**
 * Defines transport able to send requests and receive responses,
 * working over futures.
 * Every implementation of this interface should be immutable and thread safe.
 *
 * @param <Req> Request type.
 * @param <Res> Response type.
 * @param <T>   Should be either {@link Future} or {@link java.util.concurrent.CompletableFuture},
 *              or other implementors of {@link Future} interface.
 */
@FunctionalInterface
public interface AsyncTransport<Req, Res, T extends Future<Res>> {
    /**
     * Sends request producing future with response.
     *
     * @param req Request to send.
     * @return Response future.
     */
    T sendAsync(Req req);
}
