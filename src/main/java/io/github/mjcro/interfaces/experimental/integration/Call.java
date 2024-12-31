package io.github.mjcro.interfaces.experimental.integration;

/**
 * Defines a call that can be made using synchronous {@link Transport}.
 * Call encapsulates all necessary logic and options.
 *
 * @param <Req> Transport request type.
 * @param <Res> Transport response type.
 * @param <T>   Call result type.
 */
public interface Call<Req, Res, T> {
    /**
     * Performs call using given transport.
     *
     * @param transport Transport to use.
     * @return Call result.
     */
    T make(Transport<Req, Res> transport);
}
