package io.github.mjcro.interfaces.experimental.integration;

/**
 * Defines factories able to produce transports.
 *
 * @param <Req> Request type.
 * @param <Res> Response type.
 * @param <T>   Transport type.
 */
public interface TransportFactory<Req, Res, T extends Transport<Req, Res>> {
    /**
     * Constructs transport instance.
     *
     * @param options Addition transport options.
     * @return Transport instance.
     */
    T getTransport(Option... options);
}
