package io.github.mjcro.interfaces.instants;

import org.jspecify.annotations.NonNull;

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
     * Returns the scheduled timestamp.
     *
     * @return Entity scheduled time.
     */
    @NonNull T getScheduledAt();

    /**
     * Converts the scheduled timestamp to an instant.
     *
     * @return Entity scheduled time as instant.
     */
    default @NonNull Instant getScheduledAtInstant() {
        return Instant.from(getScheduledAt());
    }

    /**
     * Returns the scheduled timestamp as epoch seconds.
     *
     * @return Entity scheduled time in epoch seconds.
     */
    default long getScheduledAtEpochSeconds() {
        return getScheduledAtInstant().getEpochSecond();
    }

    /**
     * Returns the scheduled timestamp as epoch milliseconds.
     *
     * @return Entity scheduled time in epoch milliseconds.
     */
    default long getScheduledAtEpochMilli() {
        return getScheduledAtInstant().toEpochMilli();
    }

    /**
     * Formats the scheduled timestamp as an ISO-8601 instant string.
     *
     * @return Entity scheduled time in ISO_INSTANT string representation.
     */
    default @NonNull String formatScheduledAtISOInstant() {
        return DateTimeFormatter.ISO_INSTANT.format(getScheduledAtInstant());
    }
}
