package io.github.mjcro.interfaces.bytes;

import java.util.Arrays;
import java.util.Base64;

public interface WithId {
    /**
     * @return Identifier of entity
     */
    byte[] getId();

    /**
     * Checks if entity identifier equals to given one.
     *
     * @param given Identifier to compare to.
     * @return True if identifiers are equal.
     */
    default boolean hasId(byte[] given) {
        return Arrays.equals(getId(), given);
    }

    /**
     * @return Identifier of entity represented in Base64 format.
     */
    default String getIdBase64() {
        return Base64.getEncoder().encodeToString(getId());
    }
}
