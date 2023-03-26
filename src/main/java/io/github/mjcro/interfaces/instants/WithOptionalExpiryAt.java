package io.github.mjcro.interfaces.instants;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;
import java.util.Optional;

public interface WithOptionalExpiryAt {
    /**
     * @return Entity expiration time.
     */
    Optional<Instant> getExpiryAt();

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
    default Instant mustGetExpiryAt() {
        return getExpiryAt().get();
    }

    /**
     * @return Entity expiration time in epoch seconds.
     */
    default Optional<Long> getExpiryAtEpochSeconds() {
        return getExpiryAt().map(Instant::getEpochSecond);
    }

    /**
     * @return Entity expiration time in epoch milliseconds.
     */
    default Optional<Long> getExpiryAtEpochMilli() {
        return getExpiryAt().map(Instant::toEpochMilli);
    }

    /**
     * @return Entity expiration time in ISO_INSTANT string representation.
     */
    default Optional<String> formatExpiryAtISOInstant() {
        return getExpiryAt().map(DateTimeFormatter.ISO_INSTANT::format);
    }
}
