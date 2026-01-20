package io.github.mjcro.interfaces.integration;

/**
 * Represents single API call.
 * By design implementors of this interface should receive all required
 * data in their constructor and then just make a {@link #call} using
 * given transport.
 *
 * @param <T> API transport/client type.
 * @param <R> Response type.
 */
public interface Api<T, R> {
    /**
     * Performs API call.
     *
     * @param transport Transport/client to use while performing call.
     * @return API call result.
     * @throws Exception If any error occurs.
     */
    R call(T transport) throws Exception;
}
