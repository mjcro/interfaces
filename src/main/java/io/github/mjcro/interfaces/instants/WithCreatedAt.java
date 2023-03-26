package io.github.mjcro.interfaces.instants;

import java.time.Instant;
import java.time.format.DateTimeFormatter;

public interface WithCreatedAt {
    /**
     * @return Entity creation time.
     */
    Instant getCreatedAt();

    /**
     * @return Entity creation time in epoch seconds.
     */
    default long getCreatedAtEpochSeconds() {
        return getCreatedAt().getEpochSecond();
    }

    /**
     * @return Entity creation time in epoch milliseconds.
     */
    default long getCreatedAtEpochMilli() {
        return getCreatedAt().toEpochMilli();
    }

    /**
     * @return Entity creation time in ISO_INSTANT string representation.
     */
    default String formatCreatedAtISOInstant() {
        return DateTimeFormatter.ISO_INSTANT.format(getCreatedAt());
    }
}
