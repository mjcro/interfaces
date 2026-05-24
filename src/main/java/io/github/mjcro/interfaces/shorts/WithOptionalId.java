package io.github.mjcro.interfaces.shorts;

import org.jspecify.annotations.NonNull;

import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Mixin interface for entities that optionally carry a {@code short} identifier.
 */
public interface WithOptionalId {
    /**
     * Returns the entity identifier.
     *
     * @return Entity identifier.
     */
    @NonNull Optional<@NonNull Short> getId();

    /**
     * Checks whether an identifier is present.
     *
     * @return True if the entity has an identifier.
     */
    default boolean hasId() {
        return getId().isPresent();
    }

    /**
     * Checks whether the entity identifier equals the given identifier.
     *
     * @param given Identifier to compare to.
     * @return True if the identifiers are equal.
     */
    default boolean hasId(short given) {
        Optional<Short> id = getId();
        return id.isPresent() && id.get() == given;
    }

    /**
     * Returns the identifier or fails when it is absent.
     *
     * @return Entity identifier.
     * @throws NoSuchElementException If no identifier is present.
     */
    @SuppressWarnings("OptionalGetWithoutIsPresent")
    default short mustGetId() {
        return getId().get();
    }
}
