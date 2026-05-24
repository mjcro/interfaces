package io.github.mjcro.interfaces.shorts;

/**
 * Mixin interface for entities that carry a {@code short} scope identifier.
 */
public interface WithScopeId {
    /**
     * Returns the scope identifier.
     *
     * @return Scope identifier.
     */
    short getScopeId();

    /**
     * Checks whether the entity scope equals the given scope.
     *
     * @param given Scope to compare to.
     * @return True if the scopes are equal.
     */
    default boolean hasScopeId(short given) {
        return getScopeId() == given;
    }
}
