package io.github.mjcro.interfaces.instants;

import org.jspecify.annotations.NonNull;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Mixin interface for entities that optionally track the time they were last modified.
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
public interface WithOptionalModifiedAt<T extends Temporal> {
    /**
     * Returns the modification timestamp.
     *
     * @return Entity modification time.
     */
    @NonNull Optional<@NonNull T> getModifiedAt();

    /**
     * Converts the modification timestamp to an instant.
     *
     * @return Entity modification time as instant.
     */
    default @NonNull Optional<@NonNull Instant> getModifiedAtInstant() {
        return getModifiedAt().map(Instant::from);
    }

    /**
     * Checks whether a modification timestamp is present.
     *
     * @return True if the entity has a modification time.
     */
    default boolean hasModifiedAt() {
        return getModifiedAt().isPresent();
    }

    /**
     * Returns the modification timestamp or fails when it is absent.
     *
     * @return Entity modification time.
     * @throws NoSuchElementException If no modification time is present.
     */
    default @NonNull T mustGetModifiedAt() {
        return getModifiedAt().orElseThrow(NoSuchElementException::new);
    }

    /**
     * Returns the modification timestamp as epoch seconds.
     *
     * @return Entity modification time in epoch seconds.
     */
    default @NonNull Optional<@NonNull Long> getModifiedAtEpochSeconds() {
        return getModifiedAtInstant().map(Instant::getEpochSecond);
    }

    /**
     * Returns the modification timestamp as epoch milliseconds.
     *
     * @return Entity modification time in epoch milliseconds.
     */
    default @NonNull Optional<@NonNull Long> getModifiedAtEpochMilli() {
        return getModifiedAtInstant().map(Instant::toEpochMilli);
    }

    /**
     * Formats the modification timestamp as an ISO-8601 instant string.
     *
     * @return Entity modification time in ISO_INSTANT string representation.
     */
    default @NonNull Optional<@NonNull String> formatModifiedAtISOInstant() {
        return getModifiedAtInstant().map(DateTimeFormatter.ISO_INSTANT::format);
    }
}
