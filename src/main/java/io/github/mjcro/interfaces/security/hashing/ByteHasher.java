package io.github.mjcro.interfaces.security.hashing;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

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
    byte[] hash(byte[] source);

    /**
     * Performs hashing of given string.
     *
     * @param source Source string.
     * @return Hash.
     */
    default byte[] hash(String source) {
        return source.getBytes(getStringCharset());
    }

    /**
     * Performs hashing of given bytes.
     *
     * @param source Source bytes.
     * @return Hash in Base64.
     */
    default String hashToBase64(byte[] source) {
        return Base64.getEncoder().encodeToString(hash(source));
    }

    /**
     * Performs hashing of given string.
     *
     * @param source Source bytes.
     * @return Hash in Base64.
     */
    default String hashToBase64(String source) {
        return Base64.getEncoder().encodeToString(hash(source));
    }

    /**
     * @return Charset to use
     */
    default Charset getStringCharset() {
        return StandardCharsets.UTF_8;
    }
}
