package io.github.mjcro.interfaces.enums;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.Collection;
import java.util.Objects;

/**
 * Mixin interface for entities that carry an enum-based type.
 *
 * @param <T> Enum type representing the type.
 */
public interface WithType<T extends Enum<T>> {
    /**
     * Returns the entity type.
     *
     * @return Entity type
     */
    @NonNull T getType();

    /**
     * Checks whether the entity type equals the given type.
     *
     * @param given Value to compare with.
     * @return True if the types are equal.
     */
    default boolean hasType(@NonNull T given) {
        return Objects.equals(getType(), given);
    }

    /**
     * Checks whether the entity type differs from the given type.
     *
     * @param given Value to compare with.
     * @return True if the types are different.
     */
    default boolean notHasType(@NonNull T given) {
        return !hasType(given);
    }

    /**
     * Checks whether the entity type equals the given type.
     *
     * @param given Type container to compare with, may be null.
     * @return True if the types are equal.
     */
    default boolean hasType(@Nullable WithType<@NonNull T> given) {
        return given != null && given.hasType(getType());
    }

    /**
     * Checks whether the entity type differs from the given type.
     *
     * @param given Type container to compare with, may be null.
     * @return True if the types are different.
     */
    default boolean notHasType(@Nullable WithType<@NonNull T> given) {
        return !hasType(given);
    }

    /**
     * Checks whether the entity type is contained in the given type collection.
     *
     * @param collection Collection of types to match against, may be null.
     * @return True if the entity type is contained in the given collection.
     */
    default boolean hasTypeOneOf(@Nullable Collection<@NonNull T> collection) {
        return collection != null && collection.contains(getType());
    }

    /**
     * Checks whether the entity type is absent from the given type collection.
     *
     * @param collection Collection of types to match against, may be null.
     * @return True if the entity type is absent from the given collection.
     */
    default boolean notHasTypeOneOf(@Nullable Collection<@NonNull T> collection) {
        return !hasTypeOneOf(collection);
    }
}
