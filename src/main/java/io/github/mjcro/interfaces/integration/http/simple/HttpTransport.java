package io.github.mjcro.interfaces.integration.http.simple;

import io.github.mjcro.interfaces.integration.Transport;

/**
 * Synchronous HTTP transport.
 * Every implementation of this interface should be immutable and thread safe.
 */
public interface HttpTransport extends Transport<HttpRequest, HttpResponse> {
}
