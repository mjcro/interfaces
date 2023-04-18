package io.github.mjcro.interfaces.integration.http.simple;

import io.github.mjcro.interfaces.integration.Packet;

import java.util.concurrent.Future;

/**
 * HTTP request to send using HTTP transports.
 */
public interface HttpRequest extends Packet {
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
    default HttpResponse sendTo(HttpTransport transport) {
        return transport.send(this);
    }

    /**
     * Sends current request to using async transport transport.
     *
     * @param transport Transport to use.
     * @return Future response.
     */
    default <T extends Future<HttpResponse>> T sendTo(HttpAsyncTransport<T> transport) {
        return transport.sendAsync(this);
    }
}
