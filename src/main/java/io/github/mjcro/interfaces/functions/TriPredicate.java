package io.github.mjcro.interfaces.functions;

import java.util.Objects;

/**
 * Extension of {@link java.util.function.BiPredicate} design but with three arguments.
 *
 * @param <A> First argument type.
 * @param <B> Second argument type.
 * @param <C> Third argument type.
 */
@FunctionalInterface
public interface TriPredicate<A, B, C> {
    /**
     * Evaluates this predicate on the given arguments.
     *
     * @param a First argument.
     * @param b Second argument.
     * @param c Third argument.
     * @return {@code true} if the arguments match the predicate, otherwise {@code false}.
     */
    boolean test(A a, B b, C c);

    /**
     * Returns a composed predicate representing a short-circuiting logical AND of this predicate and {@code other}.
     *
     * @param other Predicate to logically-AND with this predicate.
     * @return Composed predicate.
     */
    default TriPredicate<A, B, C> and(TriPredicate<? super A, ? super B, ? super C> other) {
        Objects.requireNonNull(other, "other");
        return (a, b, c) -> this.test(a, b, c) && other.test(a, b, c);
    }

    /**
     * Returns a predicate that represents the logical negation of this predicate.
     *
     * @return Negated predicate.
     */
    default TriPredicate<A, B, C> negate() {
        return (a, b, c) -> !this.test(a, b, c);
    }

    /**
     * Returns a composed predicate representing a short-circuiting logical OR of this predicate and {@code other}.
     *
     * @param other Predicate to logically-OR with this predicate.
     * @return Composed predicate.
     */
    default TriPredicate<A, B, C> or(TriPredicate<? super A, ? super B, ? super C> other) {
        Objects.requireNonNull(other, "other");
        return (a, b, c) -> this.test(a, b, c) || other.test(a, b, c);
    }
}
