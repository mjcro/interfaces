package io.github.mjcro.interfaces.convert;

import org.jspecify.annotations.Nullable;

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
     * @param <S>      Source type.
     * @param <T>      Target type.
     * @return Converter wrapping the given function.
     */
    static <S, T> Converter<S, T> ofFunction(Function<S, T> function) {
        Objects.requireNonNull(function, "function");
        return function::apply;
    }

    /**
     * Converts source object into type T.
     *
     * @param source Source object.
     * @return Conversion result, may be null.
     */
    @Nullable T convert(S source);

    /**
     * Converts source object into an {@link Optional}.
     *
     * @param source Source object.
     * @return Optional wrapping the conversion result.
     */
    default Optional<T> convertOptionally(S source) {
        return Optional.ofNullable(convert(source));
    }

    /**
     * Constructs a composed converter that first applies this converter and then applies {@code after}.
     * If this converter returns null, the composed converter also returns null.
     *
     * @param after Converter to invoke on the result of this converter.
     * @param <U>   The output type of the composed converter.
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
