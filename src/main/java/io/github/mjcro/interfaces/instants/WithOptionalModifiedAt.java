package io.github.mjcro.interfaces.instants;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.NoSuchElementException;
import java.util.Optional;

public interface WithOptionalModifiedAt<T extends TemporalAccessor> {
    /**
     * @return Entity modification time.
     */
    Optional<T> getModifiedAt();

    /**
     * @return Entity modification time as instant.
     */
    default Optional<Instant> getModifiedAtInstant() {
        return getModifiedAt().map(Instant::from);
    }

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
    default T mustGetModifiedAt() {
        return getModifiedAt().get();
    }

    /**
     * @return Entity modification time in epoch seconds.
     */
    default Optional<Long> getModifiedAtEpochSeconds() {
        return getModifiedAtInstant().map(Instant::getEpochSecond);
    }

    /**
     * @return Entity modification time in epoch milliseconds.
     */
    default Optional<Long> getModifiedAtEpochMilli() {
        return getModifiedAtInstant().map(Instant::toEpochMilli);
    }

    /**
     * @return Entity modification time in ISO_INSTANT string representation.
     */
    default Optional<String> formatModifiedAtISOInstant() {
        return getModifiedAtInstant().map(DateTimeFormatter.ISO_INSTANT::format);
    }
}
