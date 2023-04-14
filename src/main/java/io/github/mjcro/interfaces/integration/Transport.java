package io.github.mjcro.interfaces.integration;

import io.github.mjcro.interfaces.durations.WithElapsed;

public interface Transport<Req extends Packet, Res extends Packet & WithElapsed> {
    /**
     * Sends request producing response.
     *
     * @param req Request to send.
     * @return Response.
     */
    Res send(Req req);
}
