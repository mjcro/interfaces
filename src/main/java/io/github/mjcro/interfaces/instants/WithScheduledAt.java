package io.github.mjcro.interfaces.instants;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public interface WithScheduledAt<T extends TemporalAccessor> {
    /**
     * @return Entity schedule time.
     */
    T getScheduledAt();

    /**
     * @return Entity schedule time as instant.
     */
    default Instant getScheduledAtInstant() {
        return Instant.from(getScheduledAt());
    }

    /**
     * @return Entity schedule time in epoch seconds.
     */
    default long getScheduledAtEpochSeconds() {
        return getScheduledAtInstant().getEpochSecond();
    }

    /**
     * @return Entity schedule time in epoch milliseconds.
     */
    default long getScheduledAtEpochMilli() {
        return getScheduledAtInstant().toEpochMilli();
    }

    /**
     * @return Entity schedule time in ISO_INSTANT string representation.
     */
    default String formatScheduledAtISOInstant() {
        return DateTimeFormatter.ISO_INSTANT.format(getScheduledAtInstant());
    }
}
