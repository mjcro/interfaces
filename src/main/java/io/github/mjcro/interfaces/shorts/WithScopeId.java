package io.github.mjcro.interfaces.shorts;

public interface WithScopeId {
    /**
     * @return Scope identifier.
     */
    short getScopeId();

    /**
     * Checks if entity scope equals to given one.
     *
     * @param given Scope to compare to.
     * @return True if scopes are equal.
     */
    default boolean hasScopeId(short given) {
        return getScopeId() == given;
    }
}
