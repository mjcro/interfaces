package io.github.mjcro.interfaces.instants;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Mixin interface for entities that optionally have a scheduled execution or activation time.
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
public interface WithOptionalScheduledAt<T extends Temporal> {
    /**
     * @return Entity schedule time.
     */
    Optional<T> getScheduledAt();

    /**
     * @return Entity schedule time as instant.
     */
    default Optional<Instant> getScheduledAtInstant() {
        return getScheduledAt().map(Instant::from);
    }

    /**
     * @return True if entity has schedule time.
     */
    default boolean hasScheduledAt() {
        return getScheduledAt().isPresent();
    }

    /**
     * @return Entity schedule time.
     * @throws NoSuchElementException If no scheduled time present.
     */
    default T mustGetScheduledAt() {
        return getScheduledAt().orElseThrow(NoSuchElementException::new);
    }

    /**
     * @return Entity schedule time in epoch seconds.
     */
    default Optional<Long> getScheduledAtEpochSeconds() {
        return getScheduledAtInstant().map(Instant::getEpochSecond);
    }

    /**
     * @return Entity schedule time in epoch milliseconds.
     */
    default Optional<Long> getScheduledAtEpochMilli() {
        return getScheduledAtInstant().map(Instant::toEpochMilli);
    }

    /**
     * @return Entity schedule time in ISO_INSTANT string representation.
     */
    default Optional<String> formatScheduledAtISOInstant() {
        return getScheduledAtInstant().map(DateTimeFormatter.ISO_INSTANT::format);
    }
}
