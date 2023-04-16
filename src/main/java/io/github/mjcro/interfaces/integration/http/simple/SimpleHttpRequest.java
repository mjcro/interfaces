package io.github.mjcro.interfaces.integration.http.simple;

import io.github.mjcro.interfaces.integration.Packet;

import java.util.concurrent.Future;

public interface SimpleHttpRequest extends Packet {
    String
            GET = "GET",
            PUT = "PUT",
            POST = "POST",
            PATCH = "PATCH",
            DELETE = "DELETE";

    /**
     * @return HTTP request method.
     */
    String getMethod();

    /**
     * @return URL.
     */
    String getURL();

    /**
     * Sends current request to using transport.
     *
     * @param transport Transport to use.
     * @return Response.
     */
    default SimpleHttpResponse sendTo(SimpleHttpTransport transport) {
        return transport.send(this);
    }

    /**
     * Sends current request to using async transport transport.
     *
     * @param transport Transport to use.
     * @return Future response.
     */
    default <T extends Future<SimpleHttpResponse>> T sendTo(SimpleHttpAsyncTransport<T> transport) {
        return transport.sendAsync(this);
    }
}
