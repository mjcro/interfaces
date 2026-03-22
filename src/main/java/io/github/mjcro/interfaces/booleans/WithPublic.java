package io.github.mjcro.interfaces.booleans;

/**
 * Mixin interface for objects that expose a public/private visibility flag.
 *
 * <p>Implement this interface on entities such as posts, documents, or
 * profiles that can be either publicly accessible or restricted. The
 * convenience method {@link #isNotPublic()} covers the common filtering
 * case without extra negation.
 */
public interface WithPublic {
    /**
     * Returns whether this object is publicly accessible.
     *
     * @return {@code true} if the object is public; {@code false} if it is private or restricted.
     */
    boolean isPublic();

    /**
     * Returns whether this object is <em>not</em> publicly accessible.
     *
     * <p>This is a convenience negation of {@link #isPublic()}.
     *
     * @return {@code true} if the object is not public; {@code false} if it is public.
     */
    default boolean isNotPublic() {
        return !isPublic();
    }
}
