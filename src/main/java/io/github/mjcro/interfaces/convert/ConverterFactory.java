package io.github.mjcro.interfaces.convert;

/**
 * Defines converters factory.
 *
 * @param <S> Source type.
 * @param <R> Target subtype.
 */
public interface ConverterFactory<S, R> {
    <T extends R> Converter<S, T> getConverter(Class<T> targetType);
}
