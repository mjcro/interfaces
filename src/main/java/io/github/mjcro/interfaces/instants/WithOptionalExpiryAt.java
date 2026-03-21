package io.github.mjcro.interfaces.instants;

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
     * @return Entity expiration time.
     */
    Optional<T> getExpiryAt();

    /**
     * @return Entity expiration time as instant.
     */
    default Optional<Instant> getExpiryAtInstant() {
        return getExpiryAt().map(Instant::from);
    }

    /**
     * @return True if entity has expiration time.
     */
    default boolean hasExpiryAt() {
        return getExpiryAt().isPresent();
    }

    /**
     * @return Entity expiration time.
     * @throws NoSuchElementException If no expiration time present.
     */
    default T mustGetExpiryAt() {
        return getExpiryAt().orElseThrow(NoSuchElementException::new);
    }

    /**
     * @return Entity expiration time in epoch seconds.
     */
    default Optional<Long> getExpiryAtEpochSeconds() {
        return getExpiryAtInstant().map(Instant::getEpochSecond);
    }

    /**
     * @return Entity expiration time in epoch milliseconds.
     */
    default Optional<Long> getExpiryAtEpochMilli() {
        return getExpiryAtInstant().map(Instant::toEpochMilli);
    }

    /**
     * @return Entity expiration time in ISO_INSTANT string representation.
     */
    default Optional<String> formatExpiryAtISOInstant() {
        return getExpiryAtInstant().map(DateTimeFormatter.ISO_INSTANT::format);
    }

    /**
     * Checks if entity is expired according to its expiration time.
     * Entity is not expired if it has no expiration data.
     *
     * @param against Time to check expiration against (for most cases - current time).
     * @return True if expired, false otherwise.
     */
    default boolean isExpired(Temporal against) {
        return getExpiryAt()
                .map($ -> Duration.between(against, $))
                .map(d -> d.isNegative() || d.isZero())
                .orElse(false);
    }

    /**
     * Checks if entity is expired according to its expiration time.
     * Entity is not expired if it has no expiration data.
     *
     * @param against Time to check expiration against (for most cases - current time).
     * @return True if not expired, false otherwise.
     */
    default boolean isNotExpired(Temporal against) {
        return !isExpired(against);
    }

    /**
     * Checks if entity is expired according to its expiration time.
     * Entity is not expired if it has no expiration data.
     *
     * @return True if expired, false otherwise.
     */
    default boolean isExpired() {
        return isExpired(Instant.now());
    }

    /**
     * Checks if entity is expired according to its expiration time.
     * Entity is not expired if it has no expiration data.
     *
     * @return True if not expired, false otherwise.
     */
    default boolean isNotExpired() {
        return isNotExpired(Instant.now());
    }
}
