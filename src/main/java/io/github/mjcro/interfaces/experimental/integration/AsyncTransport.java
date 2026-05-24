package io.github.mjcro.interfaces.experimental.integration;

import org.jspecify.annotations.NonNull;

import java.util.concurrent.Future;

/**
 * Defines a transport that can send requests and receive responses,
 * working over futures.
 * Every implementation of this interface should be immutable and thread-safe.
 *
 * @param <Req> Request type.
 * @param <Res> Response type.
 * @param <T>   Must be either {@link Future} or {@link java.util.concurrent.CompletableFuture},
 *              or other implementors of {@link Future} interface.
 */
@FunctionalInterface
public interface AsyncTransport<Req, Res, T extends Future<Res>> {
    /**
     * Sends request producing future with response.
     *
     * @param req     Request to send.
     * @param options Transport options.
     * @return Response future.
     */
    @NonNull T sendAsync(@NonNull Req req, @NonNull Option... options);
}
