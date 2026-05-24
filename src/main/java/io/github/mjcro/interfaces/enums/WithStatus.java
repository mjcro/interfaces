package io.github.mjcro.interfaces.enums;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.Collection;
import java.util.Objects;

/**
 * Mixin interface for entities that carry an enum-based status.
 *
 * @param <T> Enum type representing the status.
 */
public interface WithStatus<T extends Enum<T>> {
    /**
     * Returns the entity status.
     *
     * @return Entity status.
     */
    @NonNull T getStatus();

    /**
     * Checks whether the entity status equals the given status.
     *
     * @param given Value to compare with.
     * @return True if the statuses are equal.
     */
    default boolean hasStatus(@NonNull T given) {
        return Objects.equals(getStatus(), given);
    }

    /**
     * Checks whether the entity status differs from the given status.
     *
     * @param given Value to compare with.
     * @return True if the statuses are different.
     */
    default boolean notHasStatus(@NonNull T given) {
        return !hasStatus(given);
    }

    /**
     * Checks whether the entity status equals the given status.
     *
     * @param given Status container to compare with, may be null.
     * @return True if the statuses are equal.
     */
    default boolean hasStatus(@Nullable WithStatus<@NonNull T> given) {
        return given != null && given.hasStatus(getStatus());
    }

    /**
     * Checks whether the entity status differs from the given status.
     *
     * @param given Status container to compare with, may be null.
     * @return True if the statuses are different.
     */
    default boolean notHasStatus(@Nullable WithStatus<@NonNull T> given) {
        return !hasStatus(given);
    }

    /**
     * Checks whether the entity status is contained in the given status collection.
     *
     * @param collection Collection of statuses to match against, may be null.
     * @return True if the entity status is contained in the given collection.
     */
    default boolean hasStatusOneOf(@Nullable Collection<@NonNull T> collection) {
        return collection != null && collection.contains(getStatus());
    }

    /**
     * Checks whether the entity status is absent from the given status collection.
     *
     * @param collection Collection of statuses to match against, may be null.
     * @return True if the entity status is absent from the given collection.
     */
    default boolean notHasStatusOneOf(@Nullable Collection<@NonNull T> collection) {
        return !hasStatusOneOf(collection);
    }
}
