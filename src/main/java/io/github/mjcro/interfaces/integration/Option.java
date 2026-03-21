package io.github.mjcro.interfaces.integration;

/**
 * Marker interface for configuration options passed to a {@link Transport}.
 *
 * <p>Options are immutable value objects that influence how transport operates,
 * such as connection timeouts, authentication credentials, retry policies, or
 * protocol-specific headers. They are supplied at {@link Transport} construction
 * time and can be inspected later via {@link Transport#getOptions()}.
 *
 * <p>Each concrete option type should represent a single, orthogonal concern so
 * that callers can compose behaviour by providing multiple options rather than
 * relying on complex configuration objects.
 */
public interface Option {
}
