package io.github.mjcro.interfaces.booleans;

/**
 * Mixin interface for objects that support soft-delete semantics.
 *
 * <p>A soft-deleted object is not physically removed from storage; instead it
 * carries a deletion flag that implementations expose via {@link #isDeleted()}.
 * Use {@link #isNotDeleted()} in queries or filters to exclude logically
 * deleted records without additional negation boilerplate.
 */
public interface WithDeleted {
    /**
     * Returns whether this object has been soft-deleted.
     *
     * @return {@code true} if the object is marked as deleted; {@code false} otherwise.
     */
    boolean isDeleted();

    /**
     * Returns whether this object has <em>not</em> been soft-deleted.
     *
     * <p>This is a convenience negation of {@link #isDeleted()}.
     *
     * @return {@code true} if the object is not deleted; {@code false} if it is deleted.
     */
    default boolean isNotDeleted() {
        return !isDeleted();
    }
}
