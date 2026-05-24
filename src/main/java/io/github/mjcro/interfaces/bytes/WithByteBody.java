package io.github.mjcro.interfaces.bytes;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * Mixin interface for objects that carry a raw byte-array body.
 *
 * <p>Suitable for HTTP responses, binary messages, file contents, or any
 * entity whose payload is represented as a byte sequence. The body may be
 * {@code null} or empty; all convenience methods handle both cases
 * consistently, returning empty strings or zero-length streams rather than
 * throwing exceptions.
 */
public interface WithByteBody {
    /**
     * Returns the raw byte-array body of this object.
     *
     * @return The body bytes, or {@code null} if no body is present.
     */
    byte @Nullable [] getBody();

    /**
     * Returns whether the body is absent or empty.
     *
     * <p>Returns {@code true} when {@link #getBody()} is {@code null} or a
     * zero-length array.
     *
     * @return {@code true} if the body is {@code null} or has zero length; {@code false} otherwise.
     */
    default boolean isBodyEmpty() {
        byte[] body = this.getBody();
        return body == null || body.length == 0;
    }

    /**
     * Returns whether the body contains at least one byte.
     *
     * <p>This is a convenience negation of {@link #isBodyEmpty()}.
     *
     * @return {@code true} if the body is non-null and non-empty; {@code false} otherwise.
     */
    default boolean isBodyPresent() {
        return !isBodyEmpty();
    }

    /**
     * Returns the body decoded as a string using the specified charset.
     *
     * <p>If the body is {@code null} or empty, an empty string is returned.
     * If {@code charset} is {@code null}, the platform default charset is used.
     *
     * @param charset The charset to use for decoding; may be {@code null} to use the platform default.
     * @return The decoded body string, or an empty string if the body is absent; never {@code null}.
     */
    default @NonNull String getBodyString(@Nullable Charset charset) {
        byte[] body = this.getBody();
        return body == null || body.length == 0
                ? ""
                : (charset == null ? new String(body, Charset.defaultCharset()) : new String(body, charset));
    }

    /**
     * Returns the body encoded as a Base64 string.
     *
     * <p>Uses standard Base64 encoding (RFC 4648, with padding).
     * If the body is {@code null} or empty, an empty string is returned.
     *
     * @return The Base64-encoded body, or an empty string if the body is absent; never {@code null}.
     */
    default @NonNull String getBodyBase64() {
        byte[] body = this.getBody();
        return body == null || body.length == 0
                ? ""
                : Base64.getEncoder().encodeToString(body);
    }

    /**
     * Returns the body decoded as a UTF-8 string.
     *
     * <p>Delegates to {@link #getBodyString(Charset)} with
     * {@link StandardCharsets#UTF_8}. If the body is {@code null} or empty,
     * an empty string is returned.
     *
     * @return The UTF-8 decoded body string, or an empty string if the body is absent; never {@code null}.
     */
    default @NonNull String getBodyString() {
        return this.getBodyString(StandardCharsets.UTF_8);
    }

    /**
     * Returns the body as an {@link InputStream}.
     *
     * <p>If the body is {@code null}, an empty {@link ByteArrayInputStream}
     * is returned so callers can always stream without null checks.
     *
     * @return An {@link InputStream} over the body bytes; never {@code null}.
     */
    default @NonNull InputStream getBodyInputStream() {
        byte[] body = getBody();
        return new ByteArrayInputStream(body == null ? new byte[0] : body);
    }
}
