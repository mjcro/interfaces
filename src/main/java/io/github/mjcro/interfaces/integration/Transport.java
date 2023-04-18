package io.github.mjcro.interfaces.integration;

/**
 * Defines transport able to send requests and receive responses.
 * Every implementation of this interface should be immutable and thread safe.
 *
 * @param <Req> Request type.
 * @param <Res> Response type.
 */
public interface Transport<Req, Res> {
    /**
     * Sends request producing response.
     *
     * @param req Request to send.
     * @return Response.
     */
    Res send(Req req);
}
