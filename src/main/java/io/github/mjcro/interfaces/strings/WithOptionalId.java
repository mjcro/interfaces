package io.github.mjcro.interfaces.strings;

import java.util.Optional;

public interface WithOptionalId {
    /**
     * @return Identifier of entity
     */
    Optional<String> getId();

    /**
     * Checks if entity identifier equals to given one.
     *
     * @param given Identifier to compare to.
     * @return True if identifiers are equal.
     */
    default boolean hasId(String given) {
        Optional<String> id = getId();
        return id.isPresent() && id.get().equals(given);
    }
}
