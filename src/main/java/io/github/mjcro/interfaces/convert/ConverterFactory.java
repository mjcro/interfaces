package io.github.mjcro.interfaces.convert;

/**
 * Defines converters factory.
 *
 * @param <S> Source type.
 * @param <R> Target supertype.
 */
public interface ConverterFactory<S, R> {
    /**
     * Returns a converter capable of converting from {@code S} to the given target type.
     *
     * @param targetType Target class to convert to.
     * @param <T>        Target type, must be a subtype of {@code R}.
     * @return Converter for the requested target type.
     */
    <T extends R> Converter<S, T> getConverter(Class<T> targetType);
}
