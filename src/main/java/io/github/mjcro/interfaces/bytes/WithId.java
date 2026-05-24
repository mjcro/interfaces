package io.github.mjcro.interfaces.bytes;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.Arrays;
import java.util.Base64;

/**
 * Mixin interface for objects that carry a byte-array identifier.
 *
 * <p>Typical use cases include binary UUIDs, hash-based keys, or any
 * fixed-length byte sequence used as a primary key. Convenience methods
 * cover equality checks and Base64 encoding for logging or serialization.
 */
public interface WithId {
    /**
     * Returns the byte-array identifier of this object.
     *
     * <p>The returned array must not be {@code null}; its length and
     * structure are implementation-defined.
     *
     * @return The identifier as a byte array; never {@code null}.
     */
    byte @NonNull [] getId();

    /**
     * Returns whether the identifier of this object equals the given byte array.
     *
     * <p>Comparison is performed using {@link Arrays#equals(byte[], byte[])},
     * which compares content rather than reference.
     *
     * @param given The byte array to compare against; may be {@code null},
     *              in which case {@code false} is returned.
     * @return {@code true} if the identifiers are equal; {@code false} otherwise.
     */
    default boolean hasId(byte @NonNull [] given) {
        return Arrays.equals(getId(), given);
    }

    /**
     * Returns whether the identifier of this object equals the identifier of the given object.
     *
     * <p>Delegates to {@link #hasId(byte[])} with the result of {@code other.getId()}.
     * Comparison is content-based, not reference-based.
     * If {@code other} is {@code null}, {@code false} is returned immediately.
     *
     * @param other The object whose identifier to compare against; may be {@code null}.
     * @return {@code true} if both identifiers are equal; {@code false} otherwise,
     * including when {@code other} is {@code null}.
     */
    default boolean hasId(@Nullable WithId other) {
        return other != null && hasId(other.getId());
    }

    /**
     * Returns the identifier of this object encoded as a Base64 string.
     *
     * <p>Uses the standard Base64 encoding (RFC 4648, with padding).
     * Useful for logging, JSON serialization, or URL-safe transport when
     * combined with URL-safe encoding on the caller side.
     *
     * @return The Base64-encoded identifier; never {@code null}.
     */
    default @NonNull String getIdBase64() {
        return Base64.getEncoder().encodeToString(getId());
    }
}
