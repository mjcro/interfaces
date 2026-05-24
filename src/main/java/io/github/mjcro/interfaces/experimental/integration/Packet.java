package io.github.mjcro.interfaces.experimental.integration;

import io.github.mjcro.interfaces.bytes.WithByteBody;
import org.jspecify.annotations.NonNull;

/**
 * Base interface for request/response packets.
 */
public interface Packet extends WithByteBody {
    /**
     * Returns the packet headers.
     *
     * @return Envelope request/response headers.
     */
    @NonNull Headers getHeaders();
}
