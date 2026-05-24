package io.github.mjcro.interfaces.experimental.integration.http.simple;

import io.github.mjcro.interfaces.durations.WithElapsed;
import io.github.mjcro.interfaces.experimental.integration.Packet;
import io.github.mjcro.interfaces.strings.WithUrl;

/**
 * Represents an HTTP response received from an HTTP transport,
 * providing access to the status code, body, headers, and elapsed time.
 */
public interface HttpResponse extends Packet, WithElapsed, WithUrl {
    /**
     * Returns the HTTP status code.
     *
     * @return HTTP response status code.
     */
    int getStatusCode();

    /**
     * Compares the status code to the given value.
     *
     * @param given Status code to check against.
     * @return True if the status codes match.
     */
    default boolean hasStatusCode(int given) {
        return given == getStatusCode();
    }

    /**
     * Checks whether the HTTP response status is OK.
     *
     * @return True if the status code is 200.
     */
    default boolean hasStatusCode200() {
        return hasStatusCode(200);
    }
}
