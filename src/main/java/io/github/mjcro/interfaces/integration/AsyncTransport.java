package io.github.mjcro.interfaces.integration;

import io.github.mjcro.interfaces.durations.WithElapsed;

import java.util.concurrent.Future;

/**
 * Integration transport (HTTP, TCP, etc.) working over futures.
 *
 * @param <Req> Request type.
 * @param <Res> Response type.
 * @param <T>   Future type.
 */
public interface AsyncTransport<Req extends Packet, Res extends Packet & WithElapsed, T extends Future<Res>> {
    /**
     * Sends request producing future with response.
     *
     * @param req Request to send.
     * @return Response future.
     */
    T sendAsync(Req req);
}
