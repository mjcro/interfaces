package io.github.mjcro.interfaces.booleans;

/**
 * Mixin interface for objects that expose an empty/non-empty state.
 *
 * <p>Suitable for collections, strings, optional wrappers, or any domain
 * object that has a meaningful notion of emptiness. The companion method
 * {@link #isNotEmpty()} eliminates the need for callers to write
 * {@code !obj.isEmpty()} in conditional expressions.
 */
public interface WithEmpty {
    /**
     * Returns whether this object is empty.
     *
     * @return {@code true} if the object contains no elements or data; {@code false} otherwise.
     */
    boolean isEmpty();

    /**
     * Returns whether this object is <em>not</em> empty.
     *
     * <p>This is a convenience negation of {@link #isEmpty()}.
     *
     * @return {@code true} if the object contains at least one element or some data;
     *         {@code false} if it is empty.
     */
    default boolean isNotEmpty() {
        return !isEmpty();
    }
}
