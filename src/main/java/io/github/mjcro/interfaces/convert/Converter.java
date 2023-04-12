package io.github.mjcro.interfaces.convert;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

/**
 * Defines components able to convert data from one type to another.
 *
 * @param <S> Source type.
 * @param <T> Target type.
 */
@FunctionalInterface
public interface Converter<S, T> {
    /**
     * Constructs converter from given function.
     *
     * @param function Conversion function.
     * @return Converter.
     */
    static <S, T> Converter<S, T> ofFunction(Function<S, T> function) {
        Objects.requireNonNull(function, "function");
        return function::apply;
    }

    /**
     * Converts source object into type T.
     *
     * @param source Source object.
     * @return Conversion result, nullable.
     */
    T convert(S source);

    /**
     * Converts source object into type T.
     *
     * @param source Source object.
     * @return Conversion result.
     */
    default Optional<T> convertOptionally(S source) {
        return Optional.ofNullable(convert(source));
    }

    /**
     * Constructs composed converter.
     *
     * @param after Converter to invoke next.
     * @return Composed converter.
     */
    default <U> Converter<S, U> andThen(Converter<? super T, ? extends U> after) {
        Objects.requireNonNull(after, "after");
        return (s) -> {
            T initialResult = this.convert(s);
            return initialResult != null ? after.convert(initialResult) : null;
        };
    }
}
