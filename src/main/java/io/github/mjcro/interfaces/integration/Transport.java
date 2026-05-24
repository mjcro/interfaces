package io.github.mjcro.interfaces.integration;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Represents the low-level component responsible for the actual data exchange
 * with a remote service.
 *
 * <p>A {@code Transport} abstracts the wire protocol (HTTP, gRPC, message queue,
 * etc.) and carries the {@link Option}s it was configured with. Higher-level
 * {@link Client} implementations delegate serialization and I/O to a
 * {@code Transport}, keeping business logic free of protocol details.
 *
 * <p><strong>DTO boundary:</strong> a {@code Transport} works exclusively with
 * Data Transfer Objects — structures that mirror the remote service's wire format.
 * It must not reference domain entities; mapping between DTOs and domain objects
 * is the responsibility of the {@link Client} sitting above it.
 *
 * <p>Implementations are typically constructed once and reused across many
 * {@link Call} executions.
 */
public interface Transport {
    /**
     * Returns the options this transport was configured with at construction time.
     *
     * @return Array of options, or {@code null} if none were provided.
     */
    @NonNull Option @Nullable [] getOptions();

    /**
     * Returns the options this transport was configured with as an unmodifiable
     * list, never {@code null}.
     *
     * <p>This is a convenience alternative to {@link #getOptions()} that avoids
     * null checks and defensive copying by the caller.
     *
     * @return Immutable list of options; empty if no options were provided.
     */
    default @NonNull List<? extends @NonNull Option> getOptionsList() {
        Option[] options = getOptions();
        return options == null || options.length == 0
                ? Collections.emptyList()
                : Arrays.asList(options);
    }
}
