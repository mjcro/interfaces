package io.github.mjcro.interfaces.instants;

import org.jspecify.annotations.NonNull;

import java.time.Duration;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Mixin interface for entities that optionally have an expiration time.
 *
 * @param <T> Temporal type used to represent the expiration timestamp.
 *            Must support {@link java.time.temporal.ChronoField#INSTANT_SECONDS} and
 *            {@link java.time.temporal.ChronoField#NANO_OF_SECOND} so that the default
 *            conversion methods (e.g. {@link #getExpiryAtInstant()}) can call
 *            {@link java.time.Instant#from(java.time.temporal.TemporalAccessor)}, and
 *            so that {@link #isExpired(java.time.temporal.Temporal)} can compute a
 *            {@link java.time.Duration} between two instants.
 *            Suitable types: {@link java.time.Instant}, {@link java.time.ZonedDateTime},
 *            {@link java.time.OffsetDateTime}.
 *            {@link java.time.LocalDateTime}, {@link java.time.LocalDate}, and similar
 *            zone-less types will compile but throw {@link java.time.DateTimeException}
 *            at runtime when any conversion or expiry-check method is called.
 */
public interface WithOptionalExpiryAt<T extends Temporal> {
    /**
     * Returns the expiration timestamp.
     *
     * @return Entity expiration time.
     */
    @NonNull Optional<@NonNull T> getExpiryAt();

    /**
     * Converts the expiration timestamp to an instant.
     *
     * @return Entity expiration time as instant.
     */
    default @NonNull Optional<@NonNull Instant> getExpiryAtInstant() {
        return getExpiryAt().map(Instant::from);
    }

    /**
     * Checks whether an expiration timestamp is present.
     *
     * @return True if the entity has an expiration time.
     */
    default boolean hasExpiryAt() {
        return getExpiryAt().isPresent();
    }

    /**
     * Returns the expiration timestamp or fails when it is absent.
     *
     * @return Entity expiration time.
     * @throws NoSuchElementException If no expiration time is present.
     */
    default @NonNull T mustGetExpiryAt() {
        return getExpiryAt().orElseThrow(NoSuchElementException::new);
    }

    /**
     * Returns the expiration timestamp as epoch seconds.
     *
     * @return Entity expiration time in epoch seconds.
     */
    default @NonNull Optional<@NonNull Long> getExpiryAtEpochSeconds() {
        return getExpiryAtInstant().map(Instant::getEpochSecond);
    }

    /**
     * Returns the expiration timestamp as epoch milliseconds.
     *
     * @return Entity expiration time in epoch milliseconds.
     */
    default @NonNull Optional<@NonNull Long> getExpiryAtEpochMilli() {
        return getExpiryAtInstant().map(Instant::toEpochMilli);
    }

    /**
     * Formats the expiration timestamp as an ISO-8601 instant string.
     *
     * @return Entity expiration time in ISO_INSTANT string representation.
     */
    default @NonNull Optional<@NonNull String> formatExpiryAtISOInstant() {
        return getExpiryAtInstant().map(DateTimeFormatter.ISO_INSTANT::format);
    }

    /**
     * Checks whether the entity is expired according to its expiration time.
     * An entity without expiration data is treated as not expired.
     *
     * @param against Time to compare with the expiration timestamp, typically the current time.
     * @return True if the entity is expired, false otherwise.
     */
    default boolean isExpired(@NonNull Temporal against) {
        return getExpiryAt()
                .map($ -> Duration.between(against, $))
                .map(d -> d.isNegative() || d.isZero())
                .orElse(false);
    }

    /**
     * Checks whether the entity is expired according to its expiration time.
     * An entity without expiration data is treated as not expired.
     *
     * @param against Time to compare with the expiration timestamp, typically the current time.
     * @return True if the entity is not expired, false otherwise.
     */
    default boolean isNotExpired(@NonNull Temporal against) {
        return !isExpired(against);
    }

    /**
     * Checks whether the entity is expired according to its expiration time.
     * An entity without expiration data is treated as not expired.
     *
     * @return True if the entity is expired, false otherwise.
     */
    default boolean isExpired() {
        return isExpired(Instant.now());
    }

    /**
     * Checks whether the entity is expired according to its expiration time.
     * An entity without expiration data is treated as not expired.
     *
     * @return True if the entity is not expired, false otherwise.
     */
    default boolean isNotExpired() {
        return isNotExpired(Instant.now());
    }
}
