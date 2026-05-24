package io.github.mjcro.interfaces.longs;

/**
 * Mixin interface for entities that carry a {@code long} scope identifier.
 */
public interface WithScopeId {
    /**
     * Returns the scope identifier.
     *
     * @return Scope identifier.
     */
    long getScopeId();

    /**
     * Checks whether the entity scope equals the given scope.
     *
     * @param given Scope to compare to.
     * @return True if the scopes are equal.
     */
    default boolean hasScopeId(long given) {
        return getScopeId() == given;
    }
}
