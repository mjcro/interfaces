package io.github.mjcro.interfaces.security;

import io.github.mjcro.interfaces.StrongType;

/**
 * A {@link StrongType} wrapper for a single sensitive value such as a password,
 * API token, private key, or personally identifiable information.
 *
 * <p>Combines two contracts:
 * <ul>
 *   <li>{@link Sensitive} – marks the object as containing sensitive data and
 *       provides {@link AutoCloseable} support;</li>
 *   <li>{@link StrongType} – provides typed access via {@link StrongType#value()}.</li>
 * </ul>
 *
 * <p>Example usage:
 * <pre>{@code
 * try (SensitiveStrongType<char[]> password = acquirePassword()) {
 *     authenticate(password.value());
 * } // password erased here
 * }</pre>
 *
 * <p><strong>Close contract:</strong> once {@link #close()} has been called,
 * the underlying data must be effectively erased (e.g. the array zeroed out,
 * the reference nulled). Any subsequent call to {@link StrongType#value()} must
 * throw {@link java.util.NoSuchElementException} to prevent accidental use of a
 * cleared value.
 *
 * @param <T> Type of the sensitive value (e.g. {@code char[]}, {@code byte[]},
 *            {@code String}).
 * @see Sensitive
 */
public interface SensitiveStrongType<T> extends Sensitive, StrongType<T> {
}
