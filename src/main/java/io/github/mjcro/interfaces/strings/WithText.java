package io.github.mjcro.interfaces.strings;

public interface WithText {
    /**
     * @return Entity text.
     */
    String getText();

    /**
     * Checks if entity text equals to given one.
     *
     * @param given Text to compare to.
     * @return True if texts are equal.
     */
    default boolean hasText(String given) {
        return getText().equals(given);
    }
}
