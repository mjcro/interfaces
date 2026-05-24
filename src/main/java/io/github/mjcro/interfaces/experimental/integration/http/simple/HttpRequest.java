package io.github.mjcro.interfaces.experimental.integration.http.simple;

import io.github.mjcro.interfaces.experimental.integration.Option;
import io.github.mjcro.interfaces.experimental.integration.Packet;
import io.github.mjcro.interfaces.strings.WithUrl;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.Future;

/**
 * HTTP request to send using HTTP transports.
 */
public interface HttpRequest extends Packet, WithUrl {
    String
            GET = "GET",
            PUT = "PUT",
            POST = "POST",
            PATCH = "PATCH",
            DELETE = "DELETE";

    /**
     * @return HTTP request method.
     */
    @NonNull String getMethod();

    /**
     * Sends current request to using transport.
     *
     * @param transport Transport to use.
     * @param options   Transport options.
     * @return Response.
     */
    default @NonNull HttpResponse sendTo(@NonNull HttpTransport transport, @NonNull Option... options) {
        return transport.send(this, options);
    }

    /**
     * Sends current request to using async transport transport.
     *
     * @param transport Transport to use.
     * @param options   Transport options.
     * @return Future response.
     */
    default <T extends Future<HttpResponse>> @NonNull T sendTo(@NonNull HttpAsyncTransport<@NonNull T> transport, @NonNull Option... options) {
        return transport.sendAsync(this);
    }
}
