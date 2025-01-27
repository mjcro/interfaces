package io.github.mjcro.interfaces.instants;

import java.time.Duration;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;

public interface WithExpiryAt<T extends Temporal> {
    /**
     * @return Entity expiration time.
     */
    T getExpiryAt();

    /**
     * @return Entity expiration time as instant.
     */
    default Instant getExpiryAtInstant() {
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
    default String formatExpiryAtISOInstant() {
        return DateTimeFormatter.ISO_INSTANT.format(getExpiryAtInstant());
    }

    /**
     * Checks if entity is expired according to its expiration time.
     *
     * @param against Time to check expiration against (for most cases - current time).
     * @return True if expired, false otherwise.
     */
    default boolean isExpired(Temporal against) {
        return Duration.between(against, getExpiryAt()).isNegative();
    }

    /**
     * Checks if entity is expired according to its expiration time.
     *
     * @param against Time to check expiration against (for most cases - current time).
     * @return True if not expired, false otherwise.
     */
    default boolean isNotExpired(Temporal against) {
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
