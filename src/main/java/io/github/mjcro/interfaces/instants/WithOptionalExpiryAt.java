package io.github.mjcro.interfaces.instants;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.NoSuchElementException;
import java.util.Optional;

public interface WithOptionalExpiryAt<T extends TemporalAccessor> {
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
}
