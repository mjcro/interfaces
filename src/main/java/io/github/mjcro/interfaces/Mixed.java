package io.github.mjcro.interfaces;

import io.github.mjcro.interfaces.booleans.WithEmpty;

import java.util.Collection;
import java.util.Optional;

/**
 * Container for {@link java.lang.Object} with ability
 * to convert to other type.
 */
public interface Mixed extends WithEmpty {
    /**
     * Returns raw unprocessed value from mixed.
     *
     * @return Value, nullable.
     */
    Object get();

    /**
     * Converts stored in mixed container value.
     *
     * @param clazz Class to convert to.
     * @return Optional converted value.
     */
    <T> Optional<T> getAs(Class<T> clazz);

    /**
     * Converts stored in mixed container value.
     *
     * @param clazz Class to convert to.
     * @return Collection of items.
     */
    <T> Collection<T> getAsCollection(Class<T> clazz);

    /**
     * Converts stored in mixed container value.
     *
     * @param clazz Class to convert to.
     * @return Converted value, never null.
     * @throws java.util.NoSuchElementException If value was null.
     */
    default <T> T mustGetAs(Class<T> clazz) {
        return getAs(clazz).get();
    }

    // @formatter:off
    default Optional<String> getAsString() { return getAs(String.class); }
    default Optional<Long> getAsLong() { return getAs(Long.class); }
    default Optional<Integer> getAsInteger() { return getAs(Integer.class); }
    default Optional<Double> getAsDouble() { return getAs(Double.class); }
    default Optional<Float> getAsFloat() { return getAs(Float.class); }
    default Optional<Boolean> getAsBoolean() { return getAs(Boolean.class); }

    default String mustGetAsString() { return mustGetAs(String.class); }
    default long mustGetAsLong() { return mustGetAs(Long.class); }
    default int mustGetAsInteger() { return mustGetAs(Integer.class); }
    default double mustGetAsDouble() { return mustGetAs(Double.class); }
    default float mustGetAsFloat() { return mustGetAs(Float.class); }
    default boolean mustGetAsBoolean() { return mustGetAs(Boolean.class); }

    default Collection<String> getAsStringCollection() { return getAsCollection(String.class); }
    default Collection<Long> getAsLongCollection() { return getAsCollection(Long.class); }
    default Collection<Integer> getAsIntegerCollection() { return getAsCollection(Integer.class); }
    default Collection<Double> getAsDoubleCollection() { return getAsCollection(Double.class); }
    default Collection<Float> getAsFloatCollection() { return getAsCollection(Float.class); }
    default Collection<Boolean> getAsBooleanCollection() { return getAsCollection(Boolean.class); }
    // @formatter:on
}
