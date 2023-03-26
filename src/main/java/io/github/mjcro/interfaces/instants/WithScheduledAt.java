package io.github.mjcro.interfaces.instants;

import java.time.Instant;
import java.time.format.DateTimeFormatter;

public interface WithScheduledAt {
    /**
     * @return Entity expiration time.
     */
    Instant getScheduledAt();

    /**
     * @return Entity expiration time in epoch seconds.
     */
    default long getScheduledAtEpochSeconds() {
        return getScheduledAt().getEpochSecond();
    }

    /**
     * @return Entity expiration time in epoch milliseconds.
     */
    default long getScheduledAtEpochMilli() {
        return getScheduledAt().toEpochMilli();
    }

    /**
     * @return Entity expiration time in ISO_INSTANT string representation.
     */
    default String formatScheduledAtISOInstant() {
        return DateTimeFormatter.ISO_INSTANT.format(getScheduledAt());
    }
}
