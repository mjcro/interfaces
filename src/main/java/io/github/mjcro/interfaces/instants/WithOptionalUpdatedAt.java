package io.github.mjcro.interfaces.instants;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.util.NoSuchElementException;
import java.util.Optional;

public interface WithOptionalUpdatedAt<T extends Temporal> {
    /**
     * @return Entity modification time.
     */
    Optional<T> getUpdatedAt();

    /**
     * @return Entity modification time as instant.
     */
    default Optional<Instant> getUpdatedAtInstant() {
        return getUpdatedAt().map(Instant::from);
    }

    /**
     * @return True if entity has modification time.
     */
    default boolean hasUpdatedAt() {
        return getUpdatedAt().isPresent();
    }

    /**
     * @return Entity modification time.
     * @throws NoSuchElementException If no id present.
     */
    @SuppressWarnings("OptionalGetWithoutIsPresent")
    default T mustGetUpdatedAt() {
        return getUpdatedAt().get();
    }

    /**
     * @return Entity modification time in epoch seconds.
     */
    default Optional<Long> getUpdatedAtEpochSeconds() {
        return getUpdatedAtInstant().map(Instant::getEpochSecond);
    }

    /**
     * @return Entity modification time in epoch milliseconds.
     */
    default Optional<Long> getUpdatedAtEpochMilli() {
        return getUpdatedAtInstant().map(Instant::toEpochMilli);
    }

    /**
     * @return Entity modification time in ISO_INSTANT string representation.
     */
    default Optional<String> formatUpdatedAtISOInstant() {
        return getUpdatedAtInstant().map(DateTimeFormatter.ISO_INSTANT::format);
    }
}
