package io.github.mjcro.interfaces.strings;

public interface WithId {
    /**
     * @return Identifier of entity, should be not null.
     */
    String getId();

    /**
     * Checks if entity identifier equals to given one.
     *
     * @param given Identifier to compare to.
     * @return True if identifiers are equal.
     */
    default boolean hasId(String given) {
        return getId().equals(given);
    }
}
