package io.github.mjcro.interfaces.experimental.integration.http.simple;

import org.jspecify.annotations.NonNull;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * Functional interface for preprocessing HTTP requests before they are sent,
 * e.g. to inject authentication headers or modify request parameters.
 */
@FunctionalInterface
public interface HttpRequestPreProcessor {
    /**
     * Constructs an HTTP request preprocessor from the given function.
     *
     * @param function Function.
     * @return HTTP request preprocessor.
     */
    static @NonNull HttpRequestPreProcessor fromFunction(@NonNull Function<@NonNull HttpRequest, @NonNull HttpRequest> function) {
        Objects.requireNonNull(function, "function");
        return function::apply;
    }

    /**
     * Constructs an HTTP request preprocessor from the given unary operator.
     *
     * @param unaryOperator Unary operator.
     * @return HTTP request preprocessor.
     */
    static @NonNull HttpRequestPreProcessor fromUnary(@NonNull UnaryOperator<@NonNull HttpRequest> unaryOperator) {
        Objects.requireNonNull(unaryOperator, "unaryOperator");
        return unaryOperator::apply;
    }

    /**
     * Constructs an HTTP request preprocessor from the given consumer.
     * The constructed preprocessor passes the HTTP request to the consumer and then
     * return it unmodified.
     *
     * @param consumer Consumer that receives the HTTP request.
     * @return HTTP request preprocessor.
     */
    static @NonNull HttpRequestPreProcessor fromConsumer(@NonNull Consumer<@NonNull HttpRequest> consumer) {
        Objects.requireNonNull(consumer, "consumer");
        return request -> {
            consumer.accept(request);
            return request;
        };
    }

    /**
     * Performs preprocessing tasks, injecting or modifying
     * data inside the HTTP request.
     *
     * @param request HTTP request with original data.
     * @return Modified HTTP request.
     */
    @NonNull HttpRequest preProcess(@NonNull HttpRequest request);
}
