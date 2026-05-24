package io.github.mjcro.interfaces.strings;

import org.jspecify.annotations.NonNull;

import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Mixin interface for entities that optionally carry a {@link String} identifier.
 */
public interface WithOptionalId {
    /**
     * @return Identifier of entity
     */
    @NonNull Optional<@NonNull String> getId();

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
    default boolean hasId(@NonNull String given) {
        Optional<String> id = getId();
        return id.isPresent() && id.get().equals(given);
    }

    /**
     * @return Identifier of entity
     * @throws NoSuchElementException If no id present.
     */
    @SuppressWarnings("OptionalGetWithoutIsPresent")
    default @NonNull String mustGetId() {
        return getId().get();
    }
}
