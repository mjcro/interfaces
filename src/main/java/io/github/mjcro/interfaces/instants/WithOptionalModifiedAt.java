package io.github.mjcro.interfaces.instants;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;
import java.util.Optional;

public interface WithOptionalModifiedAt {
    /**
     * @return Entity modification time.
     */
    Optional<Instant> getModifiedAt();

    /**
     * @return True if entity has modification time.
     */
    default boolean hasModifiedAt() {
        return getModifiedAt().isPresent();
    }

    /**
     * @return Entity modification time.
     * @throws NoSuchElementException If no id present.
     */
    @SuppressWarnings("OptionalGetWithoutIsPresent")
    default Instant mustGetModifiedAt() {
        return getModifiedAt().get();
    }

    /**
     * @return Entity modification time in epoch seconds.
     */
    default Optional<Long> getModifiedAtEpochSeconds() {
        return getModifiedAt().map(Instant::getEpochSecond);
    }

    /**
     * @return Entity modification time in epoch milliseconds.
     */
    default Optional<Long> getModifiedAtEpochMilli() {
        return getModifiedAt().map(Instant::toEpochMilli);
    }

    /**
     * @return Entity modification time in ISO_INSTANT string representation.
     */
    default Optional<String> formatModifiedAtISOInstant() {
        return getModifiedAt().map(DateTimeFormatter.ISO_INSTANT::format);
    }
}
