package io.github.mjcro.interfaces.instants;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;
import java.util.Optional;

public interface WithOptionalUpdatedAt {
    /**
     * @return Entity modification time.
     */
    Optional<Instant> getUpdatedAt();

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
    default Instant mustGetUpdatedAt() {
        return getUpdatedAt().get();
    }

    /**
     * @return Entity modification time in epoch seconds.
     */
    default Optional<Long> getUpdatedAtEpochSeconds() {
        return getUpdatedAt().map(Instant::getEpochSecond);
    }

    /**
     * @return Entity modification time in epoch milliseconds.
     */
    default Optional<Long> getUpdatedAtEpochMilli() {
        return getUpdatedAt().map(Instant::toEpochMilli);
    }

    /**
     * @return Entity modification time in ISO_INSTANT string representation.
     */
    default Optional<String> formatUpdatedAtISOInstant() {
        return getUpdatedAt().map(DateTimeFormatter.ISO_INSTANT::format);
    }
}
