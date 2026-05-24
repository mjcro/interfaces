package io.github.mjcro.interfaces.ints;

/**
 * Mixin interface for entities that carry an {@code int} scope identifier.
 */
public interface WithScopeId {
    /**
     * Returns the scope identifier.
     *
     * @return Scope identifier.
     */
    int getScopeId();

    /**
     * Checks whether the entity scope equals the given scope.
     *
     * @param given Scope to compare to.
     * @return True if the scopes are equal.
     */
    default boolean hasScopeId(int given) {
        return getScopeId() == given;
    }
}
