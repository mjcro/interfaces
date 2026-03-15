package io.github.mjcro.interfaces.instants;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;

/**
 * Mixin interface for entities that track their creation time.
 *
 * @param <T> Temporal type used to represent the creation timestamp.
 */
public interface WithCreatedAt<T extends Temporal> {
    /**
     * @return Entity creation time.
     */
    T getCreatedAt();

    /**
     * @return Entity creation time as instant.
     */
    default Instant getCreatedAtInstant() {
        return Instant.from(getCreatedAt());
    }

    /**
     * @return Entity creation time in epoch seconds.
     */
    default long getCreatedAtEpochSeconds() {
        return getCreatedAtInstant().getEpochSecond();
    }

    /**
     * @return Entity creation time in epoch milliseconds.
     */
    default long getCreatedAtEpochMilli() {
        return getCreatedAtInstant().toEpochMilli();
    }

    /**
     * @return Entity creation time in ISO_INSTANT string representation.
     */
    default String formatCreatedAtISOInstant() {
        return DateTimeFormatter.ISO_INSTANT.format(getCreatedAtInstant());
    }
}
