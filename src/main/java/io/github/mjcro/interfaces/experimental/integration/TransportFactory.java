package io.github.mjcro.interfaces.experimental.integration;

/**
 * Defines factories able to produce transports.
 *
 * @param <Req> Request type.
 * @param <Res> Response type.
 */
public interface TransportFactory<Req, Res> {
    /**
     * Constructs transport instance.
     *
     * @param options Addition transport options.
     * @return Transport instance.
     */
    Transport<Req, Res> getTransport(Option... options);
}
