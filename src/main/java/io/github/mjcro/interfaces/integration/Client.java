package io.github.mjcro.interfaces.integration;

/**
 * Marker interface that identifies a high-level integration client.
 *
 * <p>A {@code Client} is the typed facade through which {@link Call} implementations
 * interact with a remote service. It typically wraps one or more {@link Transport}
 * instances and translates domain-level method calls into concrete requests.
 *
 * <p><strong>Domain boundary:</strong> all method signatures on a {@code Client}
 * implementation must deal exclusively in domain entities — the objects that carry
 * business meaning in the application. DTOs, wire formats, and protocol-specific
 * structures must never appear in a {@code Client}'s public API. Internally, it is
 * the {@code Client}'s responsibility to convert domain entities into DTOs before
 * delegating to the {@link Transport}, and to map DTOs back into domain entities
 * from the response before returning to the caller.
 *
 * <p>Implementing this interface allows {@link Call} to constrain its type parameter
 * {@code <C>} to a specific client, ensuring at compile time that only compatible
 * calls are submitted to a given client.
 */
public interface Client {
}
