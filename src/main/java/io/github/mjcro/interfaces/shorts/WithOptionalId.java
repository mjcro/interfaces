package io.github.mjcro.interfaces.shorts;

import java.util.Optional;

public interface WithOptionalId {
    /**
     * @return Identifier of entity
     */
    Optional<Short> getId();

    /**
     * Checks if entity identifier equals to given one.
     *
     * @param given Identifier to compare to.
     * @return True if identifiers are equal.
     */
    default boolean hasId(short given) {
        Optional<Short> id = getId();
        return id.isPresent() && id.get() == given;
    }
}
