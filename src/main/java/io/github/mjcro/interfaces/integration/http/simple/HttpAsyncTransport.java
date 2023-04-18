package io.github.mjcro.interfaces.integration.http.simple;

import io.github.mjcro.interfaces.integration.AsyncTransport;

import java.util.concurrent.Future;

/**
 * Asynchronous HTTP transport.
 * Every implementation of this interface should be immutable and thread safe.
 *
 * @param <T> Should be either {@link Future} or {@link java.util.concurrent.CompletableFuture},
 *            or other implementors of {@link Future} interface.
 */
public interface HttpAsyncTransport<T extends Future<HttpResponse>>
        extends AsyncTransport<HttpRequest, HttpResponse, T> {
}
