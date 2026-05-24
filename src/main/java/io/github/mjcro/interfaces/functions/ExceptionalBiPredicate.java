package io.github.mjcro.interfaces.functions;

import org.jspecify.annotations.NonNull;

import java.util.Objects;
import java.util.function.BiPredicate;

/**
 * Defines behavior like {@link BiPredicate} but able to throw checked exception.
 *
 * @param <T> First input type.
 * @param <U> Second input type.
 */
@FunctionalInterface
public interface ExceptionalBiPredicate<T, U> {
    /**
     * Wraps a standard {@link BiPredicate} as an {@link ExceptionalBiPredicate}.
     *
     * @param biPredicate BiPredicate to wrap.
     * @param <T>         First input type.
     * @param <U>         Second input type.
     * @return Wrapped bi-predicate.
     */
    static <T, U> @NonNull ExceptionalBiPredicate<@NonNull T, @NonNull U> fromBiPredicate(@NonNull BiPredicate<@NonNull T, @NonNull U> biPredicate) {
        Objects.requireNonNull(biPredicate, "biPredicate");
        return biPredicate::test;
    }

    /**
     * Evaluates this predicate on the given arguments.
     *
     * @param t First input argument.
     * @param u Second input argument.
     * @return {@code true} if the input arguments match the predicate, otherwise {@code false}.
     * @throws Exception If an error occurs during evaluation.
     */
    boolean test(@NonNull T t, @NonNull U u) throws Exception;

    /**
     * Returns a composed predicate that represents a short-circuiting logical AND of this predicate and {@code other}.
     *
     * @param other Predicate to logically-AND with this predicate.
     * @return Composed predicate.
     */
    default @NonNull ExceptionalBiPredicate<@NonNull T, @NonNull U> and(@NonNull ExceptionalBiPredicate<? super @NonNull T, ? super @NonNull U> other) {
        Objects.requireNonNull(other, "other");
        return (t, u) -> this.test(t, u) && other.test(t, u);
    }

    /**
     * Returns a composed predicate that represents a short-circuiting logical AND of this predicate and the standard {@code other}.
     *
     * @param other Standard predicate to logically-AND with this predicate.
     * @return Composed predicate.
     */
    default @NonNull ExceptionalBiPredicate<@NonNull T, @NonNull U> and(@NonNull BiPredicate<? super @NonNull T, ? super @NonNull U> other) {
        Objects.requireNonNull(other, "other");
        return (t, u) -> this.test(t, u) && other.test(t, u);
    }

    /**
     * Returns a predicate that represents the logical negation of this predicate.
     *
     * @return Negated predicate.
     */
    default @NonNull ExceptionalBiPredicate<@NonNull T, @NonNull U> negate() {
        return (t, u) -> !this.test(t, u);
    }

    /**
     * Returns a composed predicate that represents a short-circuiting logical OR of this predicate and {@code other}.
     *
     * @param other Predicate to logically-OR with this predicate.
     * @return Composed predicate.
     */
    default @NonNull ExceptionalBiPredicate<@NonNull T, @NonNull U> or(@NonNull ExceptionalBiPredicate<? super @NonNull T, ? super @NonNull U> other) {
        Objects.requireNonNull(other, "other");
        return (t, u) -> this.test(t, u) || other.test(t, u);
    }

    /**
     * Returns a composed predicate that represents a short-circuiting logical OR of this predicate and the standard {@code other}.
     *
     * @param other Standard predicate to logically-OR with this predicate.
     * @return Composed predicate.
     */
    default @NonNull ExceptionalBiPredicate<@NonNull T, @NonNull U> or(@NonNull BiPredicate<? super @NonNull T, ? super @NonNull U> other) {
        Objects.requireNonNull(other, "other");
        return (t, u) -> this.test(t, u) || other.test(t, u);
    }
}
