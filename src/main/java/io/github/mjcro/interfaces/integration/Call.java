package io.github.mjcro.interfaces.integration;

import org.jspecify.annotations.Nullable;

/**
 * Encapsulates a single API call as a self-contained command.
 *
 * <p>Implementations follow the <em>command pattern</em>: all parameters needed
 * to describe the request (endpoint path, query arguments, request body, etc.)
 * are injected at construction time, so the object is effectively immutable.
 * The {@link #execute(Client)} method then dispatches through the supplied
 * {@link Client}, keeping the call logic decoupled from the transport layer.
 *
 * <p>Typical usage:
 * <pre>{@code
 * Call<User, UserClient> call = new GetUserCall(userId);
 * User user = call.execute(client);
 * }</pre>
 *
 * @param <R> Type of the value returned by this call.
 * @param <C> Concrete {@link Client} subtype required to perform this call;
 *            the bound ensures only compatible clients can be passed to
 *            {@link #execute(Client)}.
 */
public interface Call<R, C extends Client> {
    /**
     * Executes this API call using the provided client.
     *
     * @param client Client instance through which the call is dispatched;
     *               must not be {@code null}.
     * @return The result of the call, or {@code null} when the remote endpoint
     *         returns an explicitly empty response.
     * @throws Exception If the call fails due to a network error, a non-success
     *                   status, or any other exceptional condition.
     */
    @Nullable R execute(C client) throws Exception;
}
