package io.github.mjcro.interfaces.experimental.integration.http.simple;

import io.github.mjcro.interfaces.experimental.integration.Option;
import io.github.mjcro.interfaces.experimental.integration.Packet;

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
     * @param options   Transport options.
     * @return Response.
     */
    default HttpResponse sendTo(HttpTransport transport, Option... options) {
        return transport.send(this, options);
    }

    /**
     * Sends current request to using async transport transport.
     *
     * @param transport Transport to use.
     * @param options   Transport options.
     * @return Future response.
     */
    default <T extends Future<HttpResponse>> T sendTo(HttpAsyncTransport<T> transport, Option... options) {
        return transport.sendAsync(this);
    }
}
