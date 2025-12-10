package io.github.mjcro.interfaces;

import java.util.Objects;

/**
 * Interface defining custom strong types introduced for
 * better contracts and code maintainability. Same as ValueObject for DDD but
 * works only as wrapper over other simple type allowing to create wrappers like
 * 1. FirstName implements StrongType<String>
 * 2. Email implements StrongType<String>
 * 3. UserId implements StrongType<Long>, etc.
 *
 * @param <T> Underlying simple type this class wraps.
 */
public interface StrongType<T> {
    /**
     * @return Value.
     */
    T value();

    /**
     * Alias for {@link #value()}.
     *
     * @return Value.
     */
    default T getValue() {
        return value();
    }

    /**
     * Checks if current wrapper contains same value as given one.
     *
     * @param candidate Value to compare to.
     * @return True if values are the same.
     */
    default boolean hasValue(T candidate) {
        return Objects.equals(value(), candidate);
    }

    /**
     * Checks if current wrapper contains same value as given one.
     *
     * @param candidate Value to compare to.
     * @return True if values are not same.
     */
    default boolean notHasValue(T candidate) {
        return !hasValue(candidate);
    }

    /**
     * Checks if given collection of values contains at least one equal to
     * the value currently holding by wrapper.
     *
     * @param candidates Values collection.
     * @return True if at least one element in collection has same value as this wrapper.
     */
    @SuppressWarnings("unchecked")
    default boolean hasValueOneOf(T... candidates) {
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
     * @param candidates Values collection.
     * @return True if at least one element in collection has same value as this wrapper.
     */
    default boolean hasValueOneOf(Iterable<T> candidates) {
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
     * @param candidates Values collection.
     * @return True if no elements in given collection are not equal to value in this wrapper.
     */
    @SuppressWarnings("unchecked")
    default boolean notHasValueOneOf(T... candidates) {
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
     * @param candidates Values collection.
     * @return True if no elements in given collection are not equal to value in this wrapper.
     */
    default boolean notHasValueOneOf(Iterable<T> candidates) {
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
