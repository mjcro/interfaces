package io.github.mjcro.interfaces.instants;

import org.jspecify.annotations.NonNull;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;

/**
 * Mixin interface for entities that carry a generic temporal timestamp.
 *
 * @param <T> Temporal type used to represent the timestamp.
 *            Must support {@link java.time.temporal.ChronoField#INSTANT_SECONDS} and
 *            {@link java.time.temporal.ChronoField#NANO_OF_SECOND} so that the default
 *            conversion methods (e.g. {@link #getTimeInstant()}) can call
 *            {@link java.time.Instant#from(java.time.temporal.TemporalAccessor)}.
 *            Suitable types: {@link java.time.Instant}, {@link java.time.ZonedDateTime},
 *            {@link java.time.OffsetDateTime}.
 *            {@link java.time.LocalDateTime}, {@link java.time.LocalDate}, and similar
 *            zone-less types will compile but throw {@link java.time.DateTimeException}
 *            at runtime when any conversion method is called.
 */
public interface WithTime<T extends Temporal> {
    /**
     * Returns the timestamp.
     *
     * @return Entity time.
     */
    @NonNull T getTime();

    /**
     * Converts the timestamp to an instant.
     *
     * @return Entity time as instant.
     */
    default @NonNull Instant getTimeInstant() {
        return Instant.from(getTime());
    }

    /**
     * Returns the timestamp as epoch seconds.
     *
     * @return Entity time in epoch seconds.
     */
    default long getTimeEpochSeconds() {
        return getTimeInstant().getEpochSecond();
    }

    /**
     * Returns the timestamp as epoch milliseconds.
     *
     * @return Entity time in epoch milliseconds.
     */
    default long getTimeEpochMilli() {
        return getTimeInstant().toEpochMilli();
    }

    /**
     * Formats the timestamp as an ISO-8601 instant string.
     *
     * @return Entity time in ISO_INSTANT string representation.
     */
    default @NonNull String formatTimeISOInstant() {
        return DateTimeFormatter.ISO_INSTANT.format(getTimeInstant());
    }
}
