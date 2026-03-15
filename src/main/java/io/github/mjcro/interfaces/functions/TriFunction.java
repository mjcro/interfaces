package io.github.mjcro.interfaces.functions;

/**
 * Extension of {@link java.util.function.BiFunction} design but with three arguments.
 *
 * @param <A> First argument type.
 * @param <B> Second argument type.
 * @param <C> Third argument type.
 * @param <R> Result type.
 */
@FunctionalInterface
public interface TriFunction<A, B, C, R> {
    /**
     * Applies this function to the given arguments.
     *
     * @param a First argument.
     * @param b Second argument.
     * @param c Third argument.
     * @return Result of the function.
     */
    R apply(A a, B b, C c);
}
