package io.github.mjcro.interfaces.function;

import java.util.Objects;

@FunctionalInterface
public interface ExceptionalTriFunction<A, B, C, R> {
    static <A, B, C, R> ExceptionalTriFunction<A, B, C, R> ofTriFunction(TriFunction<A, B, C, R> triFunction) {
        Objects.requireNonNull(triFunction, "triFunction");
        return triFunction::apply;
    }

    R apply(A a, B b, C c) throws Exception;
}
