package io.github.mjcro.interfaces.security.hashing;

import org.jspecify.annotations.NonNull;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * Interface for byte-level hashing operations.
 */
public interface ByteHasher {
    /**
     * @return Byte size length of produced hash.
     */
    int getHashSize();

    /**
     * Performs hashing of given bytes.
     *
     * @param source Source bytes.
     * @return Hash.
     */
    byte @NonNull [] hash(byte @NonNull [] source);

    /**
     * Performs hashing of given string.
     *
     * @param source Source string.
     * @return Hash.
     */
    default byte @NonNull [] hash(@NonNull String source) {
        return source.getBytes(getStringCharset());
    }

    /**
     * Performs hashing of given bytes.
     *
     * @param source Source bytes.
     * @return Hash in Base64.
     */
    default @NonNull String hashToBase64(byte @NonNull [] source) {
        return Base64.getEncoder().encodeToString(hash(source));
    }

    /**
     * Performs hashing of given string.
     *
     * @param source Source bytes.
     * @return Hash in Base64.
     */
    default @NonNull String hashToBase64(@NonNull String source) {
        return Base64.getEncoder().encodeToString(hash(source));
    }

    /**
     * @return Charset to use
     */
    default @NonNull Charset getStringCharset() {
        return StandardCharsets.UTF_8;
    }
}
