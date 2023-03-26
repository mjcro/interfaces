package io.github.mjcro.interfaces.instants;

import java.time.Instant;
import java.time.format.DateTimeFormatter;

public interface WithModifiedAt {
    /**
     * @return Entity modification time.
     */
    Instant getModifiedAt();

    /**
     * @return Entity modification time in epoch seconds.
     */
    default long getModifiedAtEpochSeconds() {
        return getModifiedAt().getEpochSecond();
    }

    /**
     * @return Entity modification time in epoch milliseconds.
     */
    default long getModifiedAtEpochMilli() {
        return getModifiedAt().toEpochMilli();
    }

    /**
     * @return Entity modification time in ISO_INSTANT string representation.
     */
    default String formatModifiedAtISOInstant() {
        return DateTimeFormatter.ISO_INSTANT.format(getModifiedAt());
    }
}
