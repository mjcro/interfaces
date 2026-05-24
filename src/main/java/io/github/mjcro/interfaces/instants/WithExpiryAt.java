package io.github.mjcro.interfaces.instants;

import org.jspecify.annotations.NonNull;

import java.time.Duration;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;

/**
 * Mixin interface for entities that have a mandatory expiration time.
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
public interface WithExpiryAt<T extends Temporal> {
    /**
     * @return Entity expiration time.
     */
    @NonNull T getExpiryAt();

    /**
     * @return Entity expiration time as instant.
     */
    default @NonNull Instant getExpiryAtInstant() {
        return Instant.from(getExpiryAt());
    }

    /**
     * @return Entity expiration time in epoch seconds.
     */
    default long getExpiryAtEpochSeconds() {
        return getExpiryAtInstant().getEpochSecond();
    }

    /**
     * @return Entity expiration time in epoch milliseconds.
     */
    default long getExpiryAtEpochMilli() {
        return getExpiryAtInstant().toEpochMilli();
    }

    /**
     * @return Entity expiration time in ISO_INSTANT string representation.
     */
    default @NonNull String formatExpiryAtISOInstant() {
        return DateTimeFormatter.ISO_INSTANT.format(getExpiryAtInstant());
    }

    /**
     * Checks if entity is expired according to its expiration time.
     *
     * @param against Time to check expiration against (for most cases - current time).
     * @return True if expired, false otherwise.
     */
    default boolean isExpired(@NonNull Temporal against) {
        Duration remaining = Duration.between(against, getExpiryAt());
        return remaining.isNegative() || remaining.isZero();
    }

    /**
     * Checks if entity is expired according to its expiration time.
     *
     * @param against Time to check expiration against (for most cases - current time).
     * @return True if not expired, false otherwise.
     */
    default boolean isNotExpired(@NonNull Temporal against) {
        return !isExpired(against);
    }

    /**
     * Checks if entity is expired according to its expiration time.
     *
     * @return True if expired, false otherwise.
     */
    default boolean isExpired() {
        return isExpired(Instant.now());
    }

    /**
     * Checks if entity is expired according to its expiration time.
     *
     * @return True if not expired, false otherwise.
     */
    default boolean isNotExpired() {
        return isNotExpired(Instant.now());
    }
}
