package io.github.mjcro.interfaces.longs;

import org.jspecify.annotations.NonNull;

import java.util.Objects;

/**
 * Mixin interface for entities that carry a strong-typed long identifier.
 *
 * @param <I> Strong identifier type, must implement {@link StrongLongId}.
 */
public interface WithStrongLongId<I extends StrongLongId> {
    /**
     * Returns the entity identifier.
     *
     * @return Entity identifier.
     */
    @NonNull I getId();

    /**
     * Checks whether the entity identifier equals the given identifier.
     *
     * @param given Identifier to compare to.
     * @return True if the identifiers are equal.
     */
    default boolean hasId(@NonNull I given) {
        return Objects.equals(getId(), given);
    }

    /**
     * Checks whether the entity identifier equals the given identifier.
     *
     * @param given Identifier to compare to.
     * @return True if the identifiers are equal.
     */
    default boolean hasId(long given) {
        return getId().hasId(given);
    }
}
