package io.github.mjcro.interfaces.instants;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;
import java.util.Optional;

public interface WithOptionalScheduledAt {
    /**
     * @return Entity schedule time.
     */
    Optional<Instant> getScheduledAt();

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
    default Instant mustGetScheduledAt() {
        return getScheduledAt().get();
    }

    /**
     * @return Entity schedule time in epoch seconds.
     */
    default Optional<Long> getScheduledAtEpochSeconds() {
        return getScheduledAt().map(Instant::getEpochSecond);
    }

    /**
     * @return Entity schedule time in epoch milliseconds.
     */
    default Optional<Long> getScheduledAtEpochMilli() {
        return getScheduledAt().map(Instant::toEpochMilli);
    }

    /**
     * @return Entity schedule time in ISO_INSTANT string representation.
     */
    default Optional<String> formatScheduledAtISOInstant() {
        return getScheduledAt().map(DateTimeFormatter.ISO_INSTANT::format);
    }
}
