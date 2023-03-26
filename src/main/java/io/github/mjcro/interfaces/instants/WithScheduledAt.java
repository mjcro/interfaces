package io.github.mjcro.interfaces.instants;

import java.time.Instant;
import java.time.format.DateTimeFormatter;

public interface WithScheduledAt {
    /**
     * @return Entity schedule time.
     */
    Instant getScheduledAt();

    /**
     * @return Entity schedule time in epoch seconds.
     */
    default long getScheduledAtEpochSeconds() {
        return getScheduledAt().getEpochSecond();
    }

    /**
     * @return Entity schedule time in epoch milliseconds.
     */
    default long getScheduledAtEpochMilli() {
        return getScheduledAt().toEpochMilli();
    }

    /**
     * @return Entity schedule time in ISO_INSTANT string representation.
     */
    default String formatScheduledAtISOInstant() {
        return DateTimeFormatter.ISO_INSTANT.format(getScheduledAt());
    }
}
