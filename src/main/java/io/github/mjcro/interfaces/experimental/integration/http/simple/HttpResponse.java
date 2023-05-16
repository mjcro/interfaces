package io.github.mjcro.interfaces.experimental.integration.http.simple;

import io.github.mjcro.interfaces.durations.WithElapsed;
import io.github.mjcro.interfaces.experimental.integration.Packet;

public interface HttpResponse extends Packet, WithElapsed {
    /**
     * @return HTTP response status code.
     */
    int getStatusCode();

    /**
     * Compares status code to given.
     *
     * @param given Status code to check against.
     * @return True if codes matches.
     */
    default boolean hasStatusCode(int given) {
        return given == getStatusCode();
    }

    /**
     * @return True if status code is 200.
     */
    default boolean hasStatusCode200() {
        return hasStatusCode(200);
    }
}
