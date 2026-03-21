package io.github.mjcro.interfaces.instants;

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
