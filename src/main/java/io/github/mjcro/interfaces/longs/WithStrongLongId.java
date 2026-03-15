package io.github.mjcro.interfaces.longs;

import java.util.Objects;

/**
 * Mixin interface for entities that carry a strong-typed long identifier.
 *
 * @param <I> Strong identifier type, must implement {@link StrongLongId}.
 */
public interface WithStrongLongId<I extends StrongLongId> {
    /**
     * @return Identifier of entity
     */
    I getId();

    /**
     * Checks if entity identifier equals to given one.
     *
     * @param given Identifier to compare to.
     * @return True if identifiers are equal.
     */
    default boolean hasId(I given) {
        return Objects.equals(getId(), given);
    }

    /**
     * Checks if entity identifier equals to given one.
     *
     * @param given Identifier to compare to.
     * @return True if identifiers are equal.
     */
    default boolean hasId(long given) {
        return getId().hasId(given);
    }
}
