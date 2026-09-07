package io.github.mjcro.interfaces.strings;

import io.github.mjcro.interfaces.StrongType;

/**
 * Strong type backed by a non-null {@link String} value.
 *
 * <p>Use this interface to distinguish domain values that share the same underlying
 * string representation, such as names, email addresses, or external identifiers.
 * Implementations provide the wrapped value through {@link #value()} and inherit
 * value-comparison helpers from {@link StrongType}.
 *
 * <p>The wrapped value must never be {@code null}.
 */
public interface StrongString extends StrongType<String> {
}
