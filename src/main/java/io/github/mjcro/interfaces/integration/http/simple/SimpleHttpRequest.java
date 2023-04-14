package io.github.mjcro.interfaces.integration.http.simple;

import io.github.mjcro.interfaces.integration.Envelope;

public interface SimpleHttpRequest extends Envelope {
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
}
