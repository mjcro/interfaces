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
     * Returns the hash size.
     *
     * @return Length of produced hashes in bytes.
     */
    int getHashSize();

    /**
     * Hashes the given bytes.
     *
     * @param source Source bytes.
     * @return Hash bytes.
     */
    byte @NonNull [] hash(byte @NonNull [] source);

    /**
     * Hashes the given string.
     *
     * @param source Source string.
     * @return Hash bytes.
     */
    default byte @NonNull [] hash(@NonNull String source) {
        return source.getBytes(getStringCharset());
    }

    /**
     * Hashes the given bytes.
     *
     * @param source Source bytes.
     * @return Hash in Base64.
     */
    default @NonNull String hashToBase64(byte @NonNull [] source) {
        return Base64.getEncoder().encodeToString(hash(source));
    }

    /**
     * Hashes the given string.
     *
     * @param source Source bytes.
     * @return Hash in Base64.
     */
    default @NonNull String hashToBase64(@NonNull String source) {
        return Base64.getEncoder().encodeToString(hash(source));
    }

    /**
     * Returns the charset used to hash strings.
     *
     * @return Charset used to encode strings before hashing.
     */
    default @NonNull Charset getStringCharset() {
        return StandardCharsets.UTF_8;
    }
}
