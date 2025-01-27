package io.github.mjcro.interfaces.instants;

import java.time.Duration;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.util.NoSuchElementException;
import java.util.Optional;

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
     * @throws NoSuchElementException If no id present.
     */
    @SuppressWarnings("OptionalGetWithoutIsPresent")
    default T mustGetExpiryAt() {
        return getExpiryAt().get();
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
                .map($ -> Duration.between(against, $).isNegative())
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
