package io.github.mjcro.interfaces.experimental.integration;

import io.github.mjcro.interfaces.durations.WithElapsed;
import io.github.mjcro.interfaces.exceptions.WithOptionalException;
import io.github.mjcro.interfaces.instants.WithCreatedAt;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.time.Duration;
import java.time.temporal.Temporal;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * Captures telemetry for a single request/response interaction, including the original request,
 * optional response, optional metadata, elapsed time, and any exception that may have occurred.
 *
 * @param <Req>  Type of the request packet.
 * @param <Res>  Type of the response packet, which must also carry elapsed-time information.
 * @param <Meta> Type of arbitrary metadata associated with the telemetry entry.
 * @param <T>    Temporal type used for the creation timestamp.
 */
public interface Telemetry<Req extends Packet, Res extends Packet & WithElapsed, Meta, T extends Temporal> extends WithOptionalException, WithCreatedAt<T> {
    /**
     * @return Request.
     */
    @NonNull Req getRequest();

    /**
     * @return Arbitrary metadata.
     */
    @NonNull Optional<@NonNull Meta> getMetadata();

    /**
     * @return Response.
     */
    @NonNull Optional<@NonNull Res> getResponse();

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
    default void ifHasResponse(@NonNull Consumer<? super @NonNull Res> consumer) {
        getResponse().ifPresent(consumer);
    }

    /**
     * @return Elapsed time.
     */
    default @NonNull Optional<@NonNull Duration> getElapsed() {
        return getResponse().map(WithElapsed::getElapsed);
    }

    /**
     * Sends current telemetry instance to given telemetry consumer.
     * If null is given this method does nothing.
     *
     * @param consumer Telemetry consumer, may be null.
     */
    default void sendTo(@Nullable Consumer<? super @NonNull Telemetry<@NonNull Req, @NonNull Res, @NonNull Meta, @NonNull T>> consumer) {
        if (consumer != null) {
            consumer.accept(this);
        }
    }
}
