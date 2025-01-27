package io.github.mjcro.interfaces.instants;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.util.NoSuchElementException;
import java.util.Optional;

public interface WithOptionalScheduledAt<T extends Temporal> {
    /**
     * @return Entity schedule time.
     */
    Optional<T> getScheduledAt();

    /**
     * @return Entity schedule time as instant.
     */
    default Optional<Instant> getScheduledAtInstant() {
        return getScheduledAt().map(Instant::from);
    }

    /**
     * @return True if entity has schedule time.
     */
    default boolean hasScheduledAt() {
        return getScheduledAt().isPresent();
    }

    /**
     * @return Entity schedule time.
     * @throws NoSuchElementException If no id present.
     */
    @SuppressWarnings("OptionalGetWithoutIsPresent")
    default T mustGetScheduledAt() {
        return getScheduledAt().get();
    }

    /**
     * @return Entity schedule time in epoch seconds.
     */
    default Optional<Long> getScheduledAtEpochSeconds() {
        return getScheduledAtInstant().map(Instant::getEpochSecond);
    }

    /**
     * @return Entity schedule time in epoch milliseconds.
     */
    default Optional<Long> getScheduledAtEpochMilli() {
        return getScheduledAtInstant().map(Instant::toEpochMilli);
    }

    /**
     * @return Entity schedule time in ISO_INSTANT string representation.
     */
    default Optional<String> formatScheduledAtISOInstant() {
        return getScheduledAtInstant().map(DateTimeFormatter.ISO_INSTANT::format);
    }
}
