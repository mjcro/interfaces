package io.github.mjcro.interfaces;

import io.github.mjcro.interfaces.booleans.WithEmpty;
import org.jspecify.annotations.NonNull;

import java.util.Optional;

/**
 * Container for {@link java.lang.Object} with ability
 * to convert to another type.
 */
public interface Mixed extends WithEmpty {
    /**
     * Returns raw unprocessed value from mixed.
     *
     * @return Optional value.
     */
    @NonNull Optional<@NonNull Object> get();

    @Override
    default boolean isEmpty() {
        return !get().isPresent();
    }

    /**
     * Converts the value stored in this mixed container.
     *
     * @param clazz Target class.
     * @return Optional converted value.
     */
    <T> @NonNull Optional<@NonNull T> getAs(@NonNull Class<@NonNull T> clazz);

    /**
     * Converts the value stored in this mixed container.
     *
     * @param clazz Target class.
     * @return Converted value, never null.
     * @throws java.util.NoSuchElementException If the value is absent.
     */
    default <T> @NonNull T mustGetAs(@NonNull Class<@NonNull T> clazz) {
        return getAs(clazz).get();
    }

    // @formatter:off
    default @NonNull Optional<@NonNull String> getAsString() { return getAs(String.class); }
    default @NonNull Optional<@NonNull Long> getAsLong() { return getAs(Long.class); }
    default @NonNull Optional<@NonNull Integer> getAsInteger() { return getAs(Integer.class); }
    default @NonNull Optional<@NonNull Double> getAsDouble() { return getAs(Double.class); }
    default @NonNull Optional<@NonNull Float> getAsFloat() { return getAs(Float.class); }
    default @NonNull Optional<@NonNull Boolean> getAsBoolean() { return getAs(Boolean.class); }

    default @NonNull String mustGetAsString() { return mustGetAs(String.class); }
    default long mustGetAsLong() { return mustGetAs(Long.class); }
    default int mustGetAsInteger() { return mustGetAs(Integer.class); }
    default double mustGetAsDouble() { return mustGetAs(Double.class); }
    default float mustGetAsFloat() { return mustGetAs(Float.class); }
    default boolean mustGetAsBoolean() { return mustGetAs(Boolean.class); }
    // @formatter:on
}
