package io.github.mjcro.interfaces.integration;

import io.github.mjcro.interfaces.durations.WithElapsed;
import io.github.mjcro.interfaces.exceptions.WithOptionalException;
import io.github.mjcro.interfaces.instants.WithCreatedAt;

import java.time.Duration;
import java.util.Optional;
import java.util.function.Consumer;

public interface Telemetry<Req extends Envelope, Res extends Envelope & WithElapsed, Meta> extends WithOptionalException, WithCreatedAt {
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
     * @return True if response is present.
     */
    default boolean hasResponse() {
        return getResponse().isPresent();
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
    default void sendTo(Consumer<Telemetry<? super Req, ? super Res, ? super Meta>> consumer) {
        if (consumer != null) {
            consumer.accept(this);
        }
    }
}
