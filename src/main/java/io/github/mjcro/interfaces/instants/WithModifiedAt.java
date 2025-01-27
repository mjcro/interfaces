package io.github.mjcro.interfaces.instants;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;

public interface WithModifiedAt<T extends Temporal> {
    /**
     * @return Entity modification time.
     */
    T getModifiedAt();

    /**
     * @return Entity modification time as instant.
     */
    default Instant getModifiedAtInstant() {
        return Instant.from(getModifiedAt());
    }

    /**
     * @return Entity modification time in epoch seconds.
     */
    default long getModifiedAtEpochSeconds() {
        return getModifiedAtInstant().getEpochSecond();
    }

    /**
     * @return Entity modification time in epoch milliseconds.
     */
    default long getModifiedAtEpochMilli() {
        return getModifiedAtInstant().toEpochMilli();
    }

    /**
     * @return Entity modification time in ISO_INSTANT string representation.
     */
    default String formatModifiedAtISOInstant() {
        return DateTimeFormatter.ISO_INSTANT.format(getModifiedAtInstant());
    }
}
