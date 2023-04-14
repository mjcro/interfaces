package io.github.mjcro.interfaces.integration.http.simple;

import io.github.mjcro.interfaces.integration.AsyncTransport;

import java.util.concurrent.Future;

public interface SimpleHttpAsyncTransport<T extends Future<SimpleHttpResponse>>
        extends AsyncTransport<SimpleHttpRequest, SimpleHttpResponse, T> {
}
