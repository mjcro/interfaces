package io.github.mjcro.interfaces.instants;

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
     * @return Entity modification time.
     */
    Optional<T> getModifiedAt();

    /**
     * @return Entity modification time as instant.
     */
    default Optional<Instant> getModifiedAtInstant() {
        return getModifiedAt().map(Instant::from);
    }

    /**
     * @return True if entity has modification time.
     */
    default boolean hasModifiedAt() {
        return getModifiedAt().isPresent();
    }

    /**
     * @return Entity modification time.
     * @throws NoSuchElementException If no modification time present.
     */
    default T mustGetModifiedAt() {
        return getModifiedAt().orElseThrow(NoSuchElementException::new);
    }

    /**
     * @return Entity modification time in epoch seconds.
     */
    default Optional<Long> getModifiedAtEpochSeconds() {
        return getModifiedAtInstant().map(Instant::getEpochSecond);
    }

    /**
     * @return Entity modification time in epoch milliseconds.
     */
    default Optional<Long> getModifiedAtEpochMilli() {
        return getModifiedAtInstant().map(Instant::toEpochMilli);
    }

    /**
     * @return Entity modification time in ISO_INSTANT string representation.
     */
    default Optional<String> formatModifiedAtISOInstant() {
        return getModifiedAtInstant().map(DateTimeFormatter.ISO_INSTANT::format);
    }
}
