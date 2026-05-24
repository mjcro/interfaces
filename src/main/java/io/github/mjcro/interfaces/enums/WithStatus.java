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
     * @return Entity status.
     */
    @NonNull T getStatus();

    /**
     * Checks if entity status is equal to given one.
     *
     * @param given State to compare with.
     * @return True is statuses are equal.
     */
    default boolean hasStatus(@NonNull T given) {
        return Objects.equals(getStatus(), given);
    }

    /**
     * Checks if entity status is not equal to given one.
     *
     * @param given State to compare with.
     * @return True is statuses are not equal.
     */
    default boolean notHasStatus(@NonNull T given) {
        return !hasStatus(given);
    }

    /**
     * Checks if entity status is equal to given one.
     *
     * @param given Status container to compare with, may be null.
     * @return True if statuses are equal.
     */
    default boolean hasStatus(@Nullable WithStatus<@NonNull T> given) {
        return given != null && given.hasStatus(getStatus());
    }

    /**
     * Checks if entity status is not equal to given one.
     *
     * @param given Status container to compare with, may be null.
     * @return True if statuses are not equal.
     */
    default boolean notHasStatus(@Nullable WithStatus<@NonNull T> given) {
        return !hasStatus(given);
    }

    /**
     * Checks if entity's status is contained in given statuses collection.
     *
     * @param collection Collection of statuses to match against, may be null.
     * @return True if entity's status is contained in the given collection.
     */
    default boolean hasStatusOneOf(@Nullable Collection<@NonNull T> collection) {
        return collection != null && collection.contains(getStatus());
    }

    /**
     * Checks if entity's status is not contained in given statuses collection.
     *
     * @param collection Collection of statuses to match against, may be null.
     * @return True if entity's status is not contained in the given collection.
     */
    default boolean notHasStatusOneOf(@Nullable Collection<@NonNull T> collection) {
        return !hasStatusOneOf(collection);
    }
}
