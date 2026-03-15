package io.github.mjcro.interfaces.functions;

import java.util.Objects;
import java.util.function.Function;

/**
 * Defines behavior like {@link Function} but able to throw checked exception.
 *
 * @param <T> Input type.
 * @param <R> Result type.
 */
@FunctionalInterface
public interface ExceptionalFunction<T, R> {
    /**
     * Wraps a standard {@link Function} as an {@link ExceptionalFunction}.
     *
     * @param function Function to wrap.
     * @param <T>      Input type.
     * @param <R>      Result type.
     * @return Wrapped function.
     */
    static <T, R> ExceptionalFunction<T, R> fromFunction(Function<T, R> function) {
        Objects.requireNonNull(function, "function");
        return function::apply;
    }

    /**
     * Returns an identity function that always returns its input argument.
     *
     * @param <T> Input and result type.
     * @return Identity function.
     */
    static <T> ExceptionalFunction<T, T> identity() {
        return (t) -> t;
    }

    /**
     * Applies this function to the given argument.
     *
     * @param in Input argument.
     * @return Result of the function.
     * @throws Exception If an error occurs during function execution.
     */
    R apply(T in) throws Exception;

    /**
     * Returns a composed function that first applies {@code before} to its input,
     * and then applies this function to the result.
     *
     * @param before Function to apply before this function.
     * @param <V>    Input type of the composed function.
     * @return Composed function.
     */
    default <V> ExceptionalFunction<V, R> compose(ExceptionalFunction<? super V, ? extends T> before) {
        Objects.requireNonNull(before, "before");
        return (v) -> this.apply(before.apply(v));
    }

    /**
     * Returns a composed function that first applies this function to its input,
     * and then applies {@code after} to the result.
     *
     * @param after Function to apply after this function.
     * @param <V>   Output type of the composed function.
     * @return Composed function.
     */
    default <V> ExceptionalFunction<T, V> andThen(ExceptionalFunction<? super R, ? extends V> after) {
        Objects.requireNonNull(after, "after");
        return (t) -> after.apply(this.apply(t));
    }

    /**
     * Returns a composed function that first applies {@code before} to its input,
     * and then applies this function to the result.
     *
     * @param before Standard function to apply before this function.
     * @param <V>    Input type of the composed function.
     * @return Composed function.
     */
    default <V> ExceptionalFunction<V, R> compose(Function<? super V, ? extends T> before) {
        Objects.requireNonNull(before, "before");
        return (v) -> this.apply(before.apply(v));
    }

    /**
     * Returns a composed function that first applies this function to its input,
     * and then applies the standard {@code after} function to the result.
     *
     * @param after Standard function to apply after this function.
     * @param <V>   Output type of the composed function.
     * @return Composed function.
     */
    default <V> ExceptionalFunction<T, V> andThen(Function<? super R, ? extends V> after) {
        Objects.requireNonNull(after, "after");
        return (t) -> after.apply(this.apply(t));
    }
}
