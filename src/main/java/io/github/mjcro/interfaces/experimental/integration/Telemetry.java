package io.github.mjcro.interfaces.experimental.integration;

import io.github.mjcro.interfaces.durations.WithElapsed;
import io.github.mjcro.interfaces.exceptions.WithOptionalException;
import io.github.mjcro.interfaces.instants.WithCreatedAt;

import java.time.Duration;
import java.time.temporal.Temporal;
import java.util.Optional;
import java.util.function.Consumer;

public interface Telemetry<Req extends Packet, Res extends Packet & WithElapsed, Meta, T extends Temporal> extends WithOptionalException, WithCreatedAt<T> {
    /**
     * @return Request.
     */
    Req getRequest();

    /**
     * @return Arbitrary metadata.
     */
    Optional<Meta> getMetadata();

    /**
     * @return Response.
     */
    Optional<Res> getResponse();

    /**
     * @return True if metadata is present.
     */
    default boolean hasMetadata() {
        return getMetadata().isPresent();
    }

    /**
     * @return True if response is present.
     */
    default boolean hasResponse() {
        return getResponse().isPresent();
    }

    /**
     * Invokes consumer if telemetry contains response.
     *
     * @param consumer Response consumer.
     */
    default void ifHasResponse(Consumer<? super Res> consumer) {
        getResponse().ifPresent(consumer);
    }

    /**
     * @return Elapsed time.
     */
    default Optional<Duration> getElapsed() {
        return getResponse().map(WithElapsed::getElapsed);
    }

    /**
     * Sends current telemetry instance to given telemetry consumer.
     * If null given should not fail.
     *
     * @param consumer Telemetry consumer.
     */
    default void sendTo(Consumer<? super Telemetry<Req, Res, Meta, T>> consumer) {
        if (consumer != null) {
            consumer.accept(this);
        }
    }
}
