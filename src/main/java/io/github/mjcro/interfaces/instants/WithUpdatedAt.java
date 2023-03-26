package io.github.mjcro.interfaces.instants;

import java.time.Instant;
import java.time.format.DateTimeFormatter;

public interface WithUpdatedAt {
    /**
     * @return Entity modification time.
     */
    Instant getUpdatedAt();

    /**
     * @return Entity modification time in epoch seconds.
     */
    default long getUpdatedAtEpochSeconds() {
        return getUpdatedAt().getEpochSecond();
    }

    /**
     * @return Entity modification time in epoch milliseconds.
     */
    default long getUpdatedAtEpochMilli() {
        return getUpdatedAt().toEpochMilli();
    }

    /**
     * @return Entity modification time in ISO_INSTANT string representation.
     */
    default String formatUpdatedAtISOInstant() {
        return DateTimeFormatter.ISO_INSTANT.format(getUpdatedAt());
    }
}
