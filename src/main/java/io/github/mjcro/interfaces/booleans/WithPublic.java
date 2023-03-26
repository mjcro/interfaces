package io.github.mjcro.interfaces.booleans;

public interface WithPublic {
    /**
     * @return True if entity is marked as public.
     */
    boolean isPublic();

    /**
     * @return True if entity is not marked as public.
     */
    default boolean isNotPublic() {
        return !isPublic();
    }
}
