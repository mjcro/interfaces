package io.github.mjcro.interfaces.instants;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public interface WithUpdatedAt<T extends TemporalAccessor> {
    /**
     * @return Entity modification time.
     */
    T getUpdatedAt();

    /**
     * @return Entity modification time as instant.
     */
    default Instant getUpdatedAtInstant() {
        return Instant.from(getUpdatedAt());
    }

    /**
     * @return Entity modification time in epoch seconds.
     */
    default long getUpdatedAtEpochSeconds() {
        return getUpdatedAtInstant().getEpochSecond();
    }

    /**
     * @return Entity modification time in epoch milliseconds.
     */
    default long getUpdatedAtEpochMilli() {
        return getUpdatedAtInstant().toEpochMilli();
    }

    /**
     * @return Entity modification time in ISO_INSTANT string representation.
     */
    default String formatUpdatedAtISOInstant() {
        return DateTimeFormatter.ISO_INSTANT.format(getUpdatedAtInstant());
    }
}
