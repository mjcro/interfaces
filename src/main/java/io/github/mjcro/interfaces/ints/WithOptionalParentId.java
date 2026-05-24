package io.github.mjcro.interfaces.ints;

import org.jspecify.annotations.NonNull;

import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Mixin interface for entities that optionally carry an {@code int} parent identifier.
 */
public interface WithOptionalParentId {
    /**
     * Returns the parent entity identifier.
     *
     * @return Parent identifier.
     */
    @NonNull Optional<@NonNull Integer> getParentId();

    /**
     * Checks whether a parent identifier is present.
     *
     * @return True if the entity has a parent identifier.
     */
    default boolean hasParentId() {
        return getParentId().isPresent();
    }

    /**
     * Checks whether the entity parent identifier equals the given identifier.
     *
     * @param given Identifier to compare to.
     * @return True if the identifiers are equal.
     */
    default boolean hasParentId(int given) {
        Optional<Integer> id = getParentId();
        return id.isPresent() && id.get() == given;
    }

    /**
     * Returns the parent identifier or fails when it is absent.
     *
     * @return Parent entity identifier.
     * @throws NoSuchElementException If no identifier is present.
     */
    @SuppressWarnings("OptionalGetWithoutIsPresent")
    default int mustGetParentId() {
        return getParentId().get();
    }
}
