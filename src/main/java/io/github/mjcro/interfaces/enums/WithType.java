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
     * @return Entity type
     */
    @NonNull T getType();

    /**
     * Checks if entity type is equal to given one.
     *
     * @param given State to compare with.
     * @return True is types are equal.
     */
    default boolean hasType(@NonNull T given) {
        return Objects.equals(getType(), given);
    }

    /**
     * Checks if entity type is not equal to given one.
     *
     * @param given State to compare with.
     * @return True is types are not equal.
     */
    default boolean notHasType(@NonNull T given) {
        return !hasType(given);
    }

    /**
     * Checks if entity type is equal to given one.
     *
     * @param given Type container to compare with, may be null.
     * @return True if types are equal.
     */
    default boolean hasType(@Nullable WithType<@NonNull T> given) {
        return given != null && given.hasType(getType());
    }

    /**
     * Checks if entity type is not equal to given one.
     *
     * @param given Type container to compare with, may be null.
     * @return True if types are not equal.
     */
    default boolean notHasType(@Nullable WithType<@NonNull T> given) {
        return !hasType(given);
    }

    /**
     * Checks if entity's type is contained in given types collection.
     *
     * @param collection Collection of types to match against, may be null.
     * @return True if entity's type is contained in the given collection.
     */
    default boolean hasTypeOneOf(@Nullable Collection<@NonNull T> collection) {
        return collection != null && collection.contains(getType());
    }

    /**
     * Checks if entity's type is not contained in given types collection.
     *
     * @param collection Collection of types to match against, may be null.
     * @return True if entity's type is not contained in the given collection.
     */
    default boolean notHasTypeOneOf(@Nullable Collection<@NonNull T> collection) {
        return !hasTypeOneOf(collection);
    }
}
