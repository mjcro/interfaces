package io.github.mjcro.interfaces;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.Objects;

/**
 * Interface defining custom strong types introduced for
 * better contracts and code maintainability. Same as ValueObject for DDD but
 * works only as wrapper over other simple type allowing to create wrappers like
 * 1. FirstName implements StrongType&lt;String&gt;
 * 2. Email implements StrongType&lt;String&gt;
 * 3. UserId implements StrongType&lt;Long&gt;, etc.
 *
 * @param <T> Underlying simple type this class wraps.
 */
public interface StrongType<T> {
    /**
     * Returns the wrapped value.
     *
     * @return Wrapped value.
     */
    @NonNull T value();

    /**
     * Alias for {@link #value()}.
     *
     * @return Wrapped value.
     */
    default @NonNull T getValue() {
        return value();
    }

    /**
     * Checks whether this wrapper contains the given value.
     *
     * @param candidate Value to compare to, may be null.
     * @return True if the values are the same.
     */
    default boolean hasValue(@Nullable T candidate) {
        return Objects.equals(value(), candidate);
    }

    /**
     * Checks whether this wrapper contains the given value.
     *
     * @param candidate Value to compare to, may be null.
     * @return True if the values are different.
     */
    default boolean notHasValue(@Nullable T candidate) {
        return !hasValue(candidate);
    }

    /**
     * Checks whether the given collection contains at least one value equal to
     * the value currently held by this wrapper.
     *
     * @param candidates Collection of values, may be null.
     * @return True if at least one element in the collection has the same value as this wrapper.
     */
    @SuppressWarnings("unchecked")
    default boolean hasValueOneOf(@Nullable T... candidates) {
        if (candidates != null) {
            for (T candidate : candidates) {
                if (hasValue(candidate)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks whether the given collection contains at least one value equal to
     * the value currently held by this wrapper.
     *
     * @param candidates Collection of values, may be null.
     * @return True if at least one element in the collection has the same value as this wrapper.
     */
    default boolean hasValueOneOf(@Nullable Iterable<@NonNull T> candidates) {
        if (candidates != null) {
            for (T candidate : candidates) {
                if (hasValue(candidate)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks whether the given collection contains no values equal to
     * the value currently held by this wrapper.
     *
     * @param candidates Collection of values, may be null.
     * @return True if no elements in the collection are equal to this wrapper value.
     */
    @SuppressWarnings("unchecked")
    default boolean notHasValueOneOf(@Nullable T... candidates) {
        if (candidates != null) {
            for (T candidate : candidates) {
                if (hasValue(candidate)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Checks whether the given collection contains no values equal to
     * the value currently held by this wrapper.
     *
     * @param candidates Collection of values, may be null.
     * @return True if no elements in the collection are equal to this wrapper value.
     */
    default boolean notHasValueOneOf(@Nullable Iterable<@NonNull T> candidates) {
        if (candidates != null) {
            for (T candidate : candidates) {
                if (hasValue(candidate)) {
                    return false;
                }
            }
        }
        return true;
    }
}
