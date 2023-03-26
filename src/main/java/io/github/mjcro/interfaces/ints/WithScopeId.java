package io.github.mjcro.interfaces.ints;

public interface WithScopeId {
    /**
     * @return Scope identifier.
     */
    int getScopeId();

    /**
     * Checks if entity scope equals to given one.
     *
     * @param given Scope to compare to.
     * @return True if scopes are equal.
     */
    default boolean hasScopeId(int given) {
        return getScopeId() == given;
    }
}
