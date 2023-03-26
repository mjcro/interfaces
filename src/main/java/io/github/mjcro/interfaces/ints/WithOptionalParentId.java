package io.github.mjcro.interfaces.ints;

import java.util.NoSuchElementException;
import java.util.Optional;

public interface WithOptionalParentId {
    /**
     * @return Parent identifier.
     */
    Optional<Integer> getParentId();

    /**
     * @return True if entity has parent identifier.
     */
    default boolean hasParentId() {
        return getParentId().isPresent();
    }

    /**
     * Checks if entity parent identifier equals to given one.
     *
     * @param given Identifier to compare to.
     * @return True if identifiers are equal.
     */
    default boolean hasParentId(int given) {
        Optional<Integer> id = getParentId();
        return id.isPresent() && id.get() == given;
    }

    /**
     * @return Parent identifier of entity
     * @throws NoSuchElementException If no id present.
     */
    @SuppressWarnings("OptionalGetWithoutIsPresent")
    default int mustGetParentId() {
        return getParentId().get();
    }
}
