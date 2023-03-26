package io.github.mjcro.interfaces.longs;

public interface WithScopeId {
    /**
     * @return Scope identifier.
     */
    long getScopeId();

    /**
     * Checks if entity scope equals to given one.
     *
     * @param given Scope to compare to.
     * @return True if scopes are equal.
     */
    default boolean hasScopeId(long given) {
        return getScopeId() == given;
    }
}
