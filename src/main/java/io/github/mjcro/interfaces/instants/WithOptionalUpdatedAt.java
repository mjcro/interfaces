package io.github.mjcro.interfaces.instants;

import org.jspecify.annotations.NonNull;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Mixin interface for entities that optionally track the time they were last updated.
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
public interface WithOptionalUpdatedAt<T extends Temporal> {
    /**
     * Returns the update timestamp.
     *
     * @return Entity update time.
     */
    @NonNull Optional<@NonNull T> getUpdatedAt();

    /**
     * Converts the update timestamp to an instant.
     *
     * @return Entity update time as instant.
     */
    default @NonNull Optional<@NonNull Instant> getUpdatedAtInstant() {
        return getUpdatedAt().map(Instant::from);
    }

    /**
     * Checks whether an update timestamp is present.
     *
     * @return True if the entity has an update time.
     */
    default boolean hasUpdatedAt() {
        return getUpdatedAt().isPresent();
    }

    /**
     * Returns the update timestamp or fails when it is absent.
     *
     * @return Entity update time.
     * @throws NoSuchElementException If no update time is present.
     */
    default @NonNull T mustGetUpdatedAt() {
        return getUpdatedAt().orElseThrow(NoSuchElementException::new);
    }

    /**
     * Returns the update timestamp as epoch seconds.
     *
     * @return Entity update time in epoch seconds.
     */
    default @NonNull Optional<@NonNull Long> getUpdatedAtEpochSeconds() {
        return getUpdatedAtInstant().map(Instant::getEpochSecond);
    }

    /**
     * Returns the update timestamp as epoch milliseconds.
     *
     * @return Entity update time in epoch milliseconds.
     */
    default @NonNull Optional<@NonNull Long> getUpdatedAtEpochMilli() {
        return getUpdatedAtInstant().map(Instant::toEpochMilli);
    }

    /**
     * Formats the update timestamp as an ISO-8601 instant string.
     *
     * @return Entity update time in ISO_INSTANT string representation.
     */
    default @NonNull Optional<@NonNull String> formatUpdatedAtISOInstant() {
        return getUpdatedAtInstant().map(DateTimeFormatter.ISO_INSTANT::format);
    }
}
