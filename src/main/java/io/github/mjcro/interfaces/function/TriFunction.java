package io.github.mjcro.interfaces.function;

/**
 * Extension of {@link java.util.function.BiFunction} design but with three arguments.
 */
@FunctionalInterface
public interface TriFunction<A, B, C, R> {
    R apply(A a, B b, C c);
}
