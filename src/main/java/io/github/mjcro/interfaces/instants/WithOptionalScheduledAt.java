package io.github.mjcro.interfaces.instants;

import org.jspecify.annotations.NonNull;

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
     * Returns the scheduled timestamp.
     *
     * @return Entity scheduled time.
     */
    @NonNull Optional<@NonNull T> getScheduledAt();

    /**
     * Converts the scheduled timestamp to an instant.
     *
     * @return Entity scheduled time as instant.
     */
    default @NonNull Optional<@NonNull Instant> getScheduledAtInstant() {
        return getScheduledAt().map(Instant::from);
    }

    /**
     * Checks whether a scheduled timestamp is present.
     *
     * @return True if the entity has a scheduled time.
     */
    default boolean hasScheduledAt() {
        return getScheduledAt().isPresent();
    }

    /**
     * Returns the scheduled timestamp or fails when it is absent.
     *
     * @return Entity scheduled time.
     * @throws NoSuchElementException If no scheduled time is present.
     */
    default @NonNull T mustGetScheduledAt() {
        return getScheduledAt().orElseThrow(NoSuchElementException::new);
    }

    /**
     * Returns the scheduled timestamp as epoch seconds.
     *
     * @return Entity scheduled time in epoch seconds.
     */
    default @NonNull Optional<@NonNull Long> getScheduledAtEpochSeconds() {
        return getScheduledAtInstant().map(Instant::getEpochSecond);
    }

    /**
     * Returns the scheduled timestamp as epoch milliseconds.
     *
     * @return Entity scheduled time in epoch milliseconds.
     */
    default @NonNull Optional<@NonNull Long> getScheduledAtEpochMilli() {
        return getScheduledAtInstant().map(Instant::toEpochMilli);
    }

    /**
     * Formats the scheduled timestamp as an ISO-8601 instant string.
     *
     * @return Entity scheduled time in ISO_INSTANT string representation.
     */
    default @NonNull Optional<@NonNull String> formatScheduledAtISOInstant() {
        return getScheduledAtInstant().map(DateTimeFormatter.ISO_INSTANT::format);
    }
}
