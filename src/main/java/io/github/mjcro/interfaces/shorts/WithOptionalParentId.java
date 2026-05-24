package io.github.mjcro.interfaces.shorts;

import org.jspecify.annotations.NonNull;

import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Mixin interface for entities that optionally carry a {@code short} parent identifier.
 */
public interface WithOptionalParentId {
    /**
     * Returns the parent entity identifier.
     *
     * @return Parent identifier.
     */
    @NonNull Optional<@NonNull Short> getParentId();

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
    default boolean hasParentId(short given) {
        Optional<Short> id = getParentId();
        return id.isPresent() && id.get() == given;
    }

    /**
     * Returns the parent identifier or fails when it is absent.
     *
     * @return Parent entity identifier.
     * @throws NoSuchElementException If no identifier is present.
     */
    @SuppressWarnings("OptionalGetWithoutIsPresent")
    default short mustGetParentId() {
        return getParentId().get();
    }
}
