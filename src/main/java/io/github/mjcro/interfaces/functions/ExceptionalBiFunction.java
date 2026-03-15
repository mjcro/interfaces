package io.github.mjcro.interfaces.functions;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Defines behavior like {@link BiFunction} but able to throw checked exception.
 *
 * @param <T> First input type.
 * @param <U> Second input type.
 * @param <R> Result type.
 */
@FunctionalInterface
public interface ExceptionalBiFunction<T, U, R> {
    /**
     * Wraps a standard {@link BiFunction} as an {@link ExceptionalBiFunction}.
     *
     * @param biFunction BiFunction to wrap.
     * @param <T>        First input type.
     * @param <U>        Second input type.
     * @param <R>        Result type.
     * @return Wrapped bi-function.
     */
    static <T, U, R> ExceptionalBiFunction<T, U, R> fromBiFunction(BiFunction<T, U, R> biFunction) {
        Objects.requireNonNull(biFunction, "biFunction");
        return biFunction::apply;
    }

    /**
     * Applies this function to the given arguments.
     *
     * @param t First argument.
     * @param u Second argument.
     * @return Result of the function.
     * @throws Exception If an error occurs during function execution.
     */
    R apply(T t, U u) throws Exception;

    /**
     * Returns a composed function that first applies this function, and then applies {@code after}.
     *
     * @param after Function to apply after this function.
     * @param <V>   Output type of the composed function.
     * @return Composed function.
     */
    default <V> ExceptionalBiFunction<T, U, V> andThen(ExceptionalFunction<? super R, ? extends V> after) {
        Objects.requireNonNull(after, "after");
        return (t, u) -> after.apply(this.apply(t, u));
    }

    /**
     * Returns a composed function that first applies this function, and then applies the standard {@code after} function.
     *
     * @param after Standard function to apply after this function.
     * @param <V>   Output type of the composed function.
     * @return Composed function.
     */
    default <V> ExceptionalBiFunction<T, U, V> andThen(Function<? super R, ? extends V> after) {
        Objects.requireNonNull(after, "after");
        return (t, u) -> after.apply(this.apply(t, u));
    }
}
