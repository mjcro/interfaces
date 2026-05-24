package io.github.mjcro.interfaces.functions;

import org.jspecify.annotations.NonNull;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * Defines {@link Predicate}-like behavior that can throw checked exceptions.
 *
 * @param <T> Input type.
 */
@FunctionalInterface
public interface ExceptionalPredicate<T> {
    /**
     * Wraps a standard {@link Predicate} as an {@link ExceptionalPredicate}.
     *
     * @param predicate Predicate to wrap.
     * @param <T>       Input type.
     * @return Wrapped predicate.
     */
    static <T> @NonNull ExceptionalPredicate<@NonNull T> fromPredicate(@NonNull Predicate<@NonNull T> predicate) {
        Objects.requireNonNull(predicate, "predicate");
        return predicate::test;
    }

    /**
     * Evaluates this predicate on the given argument.
     *
     * @param t Input argument.
     * @return {@code true} if the input argument matches the predicate, otherwise {@code false}.
     * @throws Exception If an error occurs during evaluation.
     */
    boolean test(@NonNull T t) throws Exception;

    /**
     * Returns a composed predicate that represents a short-circuiting logical AND of this predicate and {@code other}.
     *
     * @param other Predicate to logically-AND with this predicate.
     * @return Composed predicate.
     */
    default @NonNull ExceptionalPredicate<@NonNull T> and(@NonNull ExceptionalPredicate<? super @NonNull T> other) {
        Objects.requireNonNull(other, "other");
        return (t) -> this.test(t) && other.test(t);
    }

    /**
     * Returns a composed predicate that represents a short-circuiting logical AND of this predicate and the standard {@code other}.
     *
     * @param other Standard predicate to logically-AND with this predicate.
     * @return Composed predicate.
     */
    default @NonNull ExceptionalPredicate<@NonNull T> and(@NonNull Predicate<? super @NonNull T> other) {
        Objects.requireNonNull(other, "other");
        return (t) -> this.test(t) && other.test(t);
    }

    /**
     * Returns a predicate that represents the logical negation of this predicate.
     *
     * @return Negated predicate.
     */
    default @NonNull ExceptionalPredicate<@NonNull T> negate() {
        return (t) -> !this.test(t);
    }

    /**
     * Returns a composed predicate that represents a short-circuiting logical OR of this predicate and {@code other}.
     *
     * @param other Predicate to logically-OR with this predicate.
     * @return Composed predicate.
     */
    default @NonNull ExceptionalPredicate<@NonNull T> or(@NonNull ExceptionalPredicate<? super @NonNull T> other) {
        Objects.requireNonNull(other, "other");
        return (t) -> this.test(t) || other.test(t);
    }

    /**
     * Returns a composed predicate that represents a short-circuiting logical OR of this predicate and the standard {@code other}.
     *
     * @param other Standard predicate to logically-OR with this predicate.
     * @return Composed predicate.
     */
    default @NonNull ExceptionalPredicate<@NonNull T> or(@NonNull Predicate<? super @NonNull T> other) {
        Objects.requireNonNull(other, "other");
        return (t) -> this.test(t) || other.test(t);
    }
}
