package io.github.mjcro.interfaces.integration.http.simple;

import io.github.mjcro.interfaces.durations.WithElapsed;
import io.github.mjcro.interfaces.integration.Packet;

public interface SimpleHttpResponse extends Packet, WithElapsed {
    /**
     * @return HTTP response status code.
     */
    int getStatusCode();

    default boolean hasStatusCode(int given) {
        return given == getStatusCode();
    }

    default boolean hasStatusCode200() {
        return hasStatusCode(200);
    }
}
