package io.github.mjcro.interfaces.instants;

import java.time.Instant;
import java.time.format.DateTimeFormatter;

public interface WithExpiryAt {
    /**
     * @return Entity expiration time.
     */
    Instant getExpiryAt();

    /**
     * @return Entity expiration time in epoch seconds.
     */
    default long getExpiryAtEpochSeconds() {
        return getExpiryAt().getEpochSecond();
    }

    /**
     * @return Entity expiration time in epoch milliseconds.
     */
    default long getExpiryAtEpochMilli() {
        return getExpiryAt().toEpochMilli();
    }

    /**
     * @return Entity expiration time in ISO_INSTANT string representation.
     */
    default String formatExpiryAtISOInstant() {
        return DateTimeFormatter.ISO_INSTANT.format(getExpiryAt());
    }
}
