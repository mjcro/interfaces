package io.github.mjcro.interfaces.integration;

import io.github.mjcro.interfaces.bytes.WithByteBody;

/**
 * Base interface for request/response packets.
 */
public interface Envelope extends WithByteBody {
    /**
     * @return Envelope request/response headers.
     */
    Headers getHeaders();
}
