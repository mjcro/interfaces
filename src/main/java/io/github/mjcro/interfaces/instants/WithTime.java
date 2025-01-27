package io.github.mjcro.interfaces.instants;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;

public interface WithTime<T extends Temporal> {
    /**
     * @return Entity time.
     */
    T getTime();

    /**
     * @return Entity time as instant.
     */
    default Instant getTimeInstant() {
        return Instant.from(getTime());
    }

    /**
     * @return Entity time in epoch seconds.
     */
    default long getTimeEpochSeconds() {
        return getTimeInstant().getEpochSecond();
    }

    /**
     * @return Entity time in epoch milliseconds.
     */
    default long getTimeEpochMilli() {
        return getTimeInstant().toEpochMilli();
    }

    /**
     * @return Entity time in ISO_INSTANT string representation.
     */
    default String formatTimeISOInstant() {
        return DateTimeFormatter.ISO_INSTANT.format(getTimeInstant());
    }
}
