package io.github.mjcro.interfaces.instants;

import java.time.Instant;
import java.time.format.DateTimeFormatter;

public interface WithTime {
    /**
     * @return Entity time.
     */
    Instant getTime();

    /**
     * @return Entity time in epoch seconds.
     */
    default long getTimeEpochSeconds() {
        return getTime().getEpochSecond();
    }

    /**
     * @return Entity time in epoch milliseconds.
     */
    default long getTimeEpochMilli() {
        return getTime().toEpochMilli();
    }

    /**
     * @return Entity time in ISO_INSTANT string representation.
     */
    default String formatTimeISOInstant() {
        return DateTimeFormatter.ISO_INSTANT.format(getTime());
    }
}
