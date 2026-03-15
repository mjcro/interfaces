package io.github.mjcro.interfaces.functions;

import java.util.Objects;

/**
 * Defines behavior like {@link TriFunction} but able to throw checked exception.
 *
 * @param <A> First argument type.
 * @param <B> Second argument type.
 * @param <C> Third argument type.
 * @param <R> Result type.
 */
@FunctionalInterface
public interface ExceptionalTriFunction<A, B, C, R> {
    /**
     * Wraps a {@link TriFunction} as an {@link ExceptionalTriFunction}.
     *
     * @param triFunction TriFunction to wrap.
     * @param <A>         First argument type.
     * @param <B>         Second argument type.
     * @param <C>         Third argument type.
     * @param <R>         Result type.
     * @return Wrapped tri-function.
     */
    static <A, B, C, R> ExceptionalTriFunction<A, B, C, R> ofTriFunction(TriFunction<A, B, C, R> triFunction) {
        Objects.requireNonNull(triFunction, "triFunction");
        return triFunction::apply;
    }

    /**
     * Applies this function to the given arguments.
     *
     * @param a First argument.
     * @param b Second argument.
     * @param c Third argument.
     * @return Result of the function.
     * @throws Exception If an error occurs during function execution.
     */
    R apply(A a, B b, C c) throws Exception;
}
