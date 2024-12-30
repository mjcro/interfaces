package io.github.mjcro.interfaces.experimental.integration;

/**
 * Defines transport able to send requests and receive responses.
 * Every implementation of this interface should be immutable and thread safe.
 *
 * @param <Req> Request type.
 * @param <Res> Response type.
 */
@FunctionalInterface
public interface Transport<Req, Res> {
    /**
     * Sends request producing response.
     *
     * @param req     Request to send.
     * @param options Transport options.
     * @return Response.
     */
    Res send(Req req, Option... options);
}
