package io.github.mjcro.interfaces.security;

import io.github.mjcro.interfaces.StrongType;

/**
 * A {@link StrongType} wrapper for sensitive data such as passwords, API tokens,
 * private keys, or personally identifiable information.
 *
 * <p>Implements {@link AutoCloseable} to support the try-with-resources idiom,
 * which guarantees that the sensitive value is erased from memory as soon as it
 * is no longer needed:
 * <pre>{@code
 * try (Sensitive<char[]> password = acquirePassword()) {
 *     authenticate(password.value());
 * } // password erased here
 * }</pre>
 *
 * <p><strong>Close contract:</strong> once {@link #close()} has been called,
 * the underlying data must be effectively erased (e.g. the array zeroed out,
 * the reference nulled). Any subsequent call to {@link #value()} must throw
 * {@link java.util.NoSuchElementException} to prevent accidental use of a
 * cleared value.
 *
 * @param <T> Type of the sensitive value (e.g. {@code char[]}, {@code byte[]},
 *            {@code String}).
 */
public interface Sensitive<T> extends StrongType<T>, AutoCloseable {
}
