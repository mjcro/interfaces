package io.github.mjcro.interfaces.instants;

import org.jspecify.annotations.NonNull;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;

/**
 * Mixin interface for entities that track the time they were last updated.
 *
 * @param <T> Temporal type used to represent the update timestamp.
 *            Must support {@link java.time.temporal.ChronoField#INSTANT_SECONDS} and
 *            {@link java.time.temporal.ChronoField#NANO_OF_SECOND} so that the default
 *            conversion methods (e.g. {@link #getUpdatedAtInstant()}) can call
 *            {@link java.time.Instant#from(java.time.temporal.TemporalAccessor)}.
 *            Suitable types: {@link java.time.Instant}, {@link java.time.ZonedDateTime},
 *            {@link java.time.OffsetDateTime}.
 *            {@link java.time.LocalDateTime}, {@link java.time.LocalDate}, and similar
 *            zone-less types will compile but throw {@link java.time.DateTimeException}
 *            at runtime when any conversion method is called.
 */
public interface WithUpdatedAt<T extends Temporal> {
    /**
     * @return Entity modification time.
     */
    @NonNull T getUpdatedAt();

    /**
     * @return Entity modification time as instant.
     */
    default @NonNull Instant getUpdatedAtInstant() {
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
    default @NonNull String formatUpdatedAtISOInstant() {
        return DateTimeFormatter.ISO_INSTANT.format(getUpdatedAtInstant());
    }
}
