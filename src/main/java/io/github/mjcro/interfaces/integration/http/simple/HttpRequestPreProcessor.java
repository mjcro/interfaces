package io.github.mjcro.interfaces.integration.http.simple;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

@FunctionalInterface
public interface HttpRequestPreProcessor {
    /**
     * Constructs HTTP response pre-processor from given function.
     *
     * @param function Function.
     * @return HTTP request pre-processor.
     */
    static HttpRequestPreProcessor fromFunction(Function<HttpRequest, HttpRequest> function) {
        Objects.requireNonNull(function, "function");
        return function::apply;
    }

    /**
     * Constructs HTTP request pre-processor from given unary operator.
     *
     * @param unaryOperator Unary operator.
     * @return HTTP request pre-processor.
     */
    static HttpRequestPreProcessor fromUnary(UnaryOperator<HttpRequest> unaryOperator) {
        Objects.requireNonNull(unaryOperator, "unaryOperator");
        return unaryOperator::apply;
    }

    /**
     * Constructs HTTP request pre-processor over given consumer.
     * Constructed pre-processor will pass HTTP request to consumer and then
     * return it unmodified.
     *
     * @param consumer Consumer to pass HTTP request into.
     * @return HTTP request pre-processor.
     */
    static HttpRequestPreProcessor fromConsumer(Consumer<HttpRequest> consumer) {
        Objects.requireNonNull(consumer, "consumer");
        return request -> {
            consumer.accept(request);
            return request;
        };
    }

    /**
     * Performs pre-processing tasks, injecting or modifying
     * data inside HTTP request.
     *
     * @param request HTTP request with original data.
     * @return Altered HTTP request.
     */
    HttpRequest preProcess(HttpRequest request);
}
