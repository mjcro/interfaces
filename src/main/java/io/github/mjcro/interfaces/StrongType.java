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
     * @return Value.
     */
    @NonNull T value();

    /**
     * Alias for {@link #value()}.
     *
     * @return Value.
     */
    default @NonNull T getValue() {
        return value();
    }

    /**
     * Checks if current wrapper contains same value as given one.
     *
     * @param candidate Value to compare to, may be null.
     * @return True if values are the same.
     */
    default boolean hasValue(@Nullable T candidate) {
        return Objects.equals(value(), candidate);
    }

    /**
     * Checks if current wrapper contains same value as given one.
     *
     * @param candidate Value to compare to, may be null.
     * @return True if values are not same.
     */
    default boolean notHasValue(@Nullable T candidate) {
        return !hasValue(candidate);
    }

    /**
     * Checks if given collection of values contains at least one equal to
     * the value currently holding by wrapper.
     *
     * @param candidates Values collection, may be null.
     * @return True if at least one element in collection has same value as this wrapper.
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
     * Checks if given collection of values contains at least one equal to
     * the value currently holding by wrapper.
     *
     * @param candidates Values collection, may be null.
     * @return True if at least one element in collection has same value as this wrapper.
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
     * Checks if given collection of values does not contain any equal to
     * the value currently holding by wrapper.
     *
     * @param candidates Values collection, may be null.
     * @return True if no elements in given collection are equal to value in this wrapper.
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
     * Checks if given collection of values does not contain any equal to
     * the value currently holding by wrapper.
     *
     * @param candidates Values collection, may be null.
     * @return True if no elements in given collection are equal to value in this wrapper.
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
