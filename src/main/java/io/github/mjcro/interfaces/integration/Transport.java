package io.github.mjcro.interfaces.integration;

public interface Transport<Req, Res> {
    /**
     * Sends request producing response.
     *
     * @param req Request to send.
     * @return Response.
     */
    Res send(Req req);
}
