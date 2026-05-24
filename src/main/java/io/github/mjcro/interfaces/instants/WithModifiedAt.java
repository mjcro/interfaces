package io.github.mjcro.interfaces.instants;

import org.jspecify.annotations.NonNull;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;

/**
 * Mixin interface for entities that track the time they were last modified.
 *
 * @param <T> Temporal type used to represent the modification timestamp.
 *            Must support {@link java.time.temporal.ChronoField#INSTANT_SECONDS} and
 *            {@link java.time.temporal.ChronoField#NANO_OF_SECOND} so that the default
 *            conversion methods (e.g. {@link #getModifiedAtInstant()}) can call
 *            {@link java.time.Instant#from(java.time.temporal.TemporalAccessor)}.
 *            Suitable types: {@link java.time.Instant}, {@link java.time.ZonedDateTime},
 *            {@link java.time.OffsetDateTime}.
 *            {@link java.time.LocalDateTime}, {@link java.time.LocalDate}, and similar
 *            zone-less types will compile but throw {@link java.time.DateTimeException}
 *            at runtime when any conversion method is called.
 */
public interface WithModifiedAt<T extends Temporal> {
    /**
     * Returns the modification timestamp.
     *
     * @return Entity modification time.
     */
    @NonNull T getModifiedAt();

    /**
     * Converts the modification timestamp to an instant.
     *
     * @return Entity modification time as instant.
     */
    default @NonNull Instant getModifiedAtInstant() {
        return Instant.from(getModifiedAt());
    }

    /**
     * Returns the modification timestamp as epoch seconds.
     *
     * @return Entity modification time in epoch seconds.
     */
    default long getModifiedAtEpochSeconds() {
        return getModifiedAtInstant().getEpochSecond();
    }

    /**
     * Returns the modification timestamp as epoch milliseconds.
     *
     * @return Entity modification time in epoch milliseconds.
     */
    default long getModifiedAtEpochMilli() {
        return getModifiedAtInstant().toEpochMilli();
    }

    /**
     * Formats the modification timestamp as an ISO-8601 instant string.
     *
     * @return Entity modification time in ISO_INSTANT string representation.
     */
    default @NonNull String formatModifiedAtISOInstant() {
        return DateTimeFormatter.ISO_INSTANT.format(getModifiedAtInstant());
    }
}
