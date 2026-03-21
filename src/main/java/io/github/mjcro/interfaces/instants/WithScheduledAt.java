package io.github.mjcro.interfaces.instants;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;

/**
 * Mixin interface for entities that have a scheduled execution or activation time.
 *
 * @param <T> Temporal type used to represent the scheduled timestamp.
 *            Must support {@link java.time.temporal.ChronoField#INSTANT_SECONDS} and
 *            {@link java.time.temporal.ChronoField#NANO_OF_SECOND} so that the default
 *            conversion methods (e.g. {@link #getScheduledAtInstant()}) can call
 *            {@link java.time.Instant#from(java.time.temporal.TemporalAccessor)}.
 *            Suitable types: {@link java.time.Instant}, {@link java.time.ZonedDateTime},
 *            {@link java.time.OffsetDateTime}.
 *            {@link java.time.LocalDateTime}, {@link java.time.LocalDate}, and similar
 *            zone-less types will compile but throw {@link java.time.DateTimeException}
 *            at runtime when any conversion method is called.
 */
public interface WithScheduledAt<T extends Temporal> {
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
