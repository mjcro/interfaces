package io.github.mjcro.interfaces.longs;

import org.jspecify.annotations.NonNull;

import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Mixin interface for entities that optionally carry a {@code long} identifier.
 */
public interface WithOptionalId {
    /**
     * @return Identifier of entity
     */
    @NonNull Optional<@NonNull Long> getId();

    /**
     * @return True if entity has id.
     */
    default boolean hasId() {
        return getId().isPresent();
    }

    /**
     * Checks if entity identifier equals to given one.
     *
     * @param given Identifier to compare to.
     * @return True if identifiers are equal.
     */
    default boolean hasId(long given) {
        Optional<Long> id = getId();
        return id.isPresent() && id.get() == given;
    }

    /**
     * @return Identifier of entity
     * @throws NoSuchElementException If no id present.
     */
    @SuppressWarnings("OptionalGetWithoutIsPresent")
    default long mustGetId() {
        return getId().get();
    }
}
