package io.github.mjcro.interfaces.strings;

public interface WithName {
    /**
     * @return Entity name.
     */
    String getName();

    /**
     * Checks if entity name equals to given one.
     *
     * @param given Name to compare to.
     * @return True if names are equal.
     */
    default boolean hasName(String given) {
        return getName().equals(given);
    }
}
