package io.github.mjcro.interfaces.instants;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public interface WithExpiryAt<T extends TemporalAccessor> {
    /**
     * @return Entity expiration time.
     */
    Instant getExpiryAt();

    /**
     * @return Entity expiration time as instant.
     */
    default Instant getExpiryAtInstant() {
        return Instant.from(getExpiryAt());
    }

    /**
     * @return Entity expiration time in epoch seconds.
     */
    default long getExpiryAtEpochSeconds() {
        return getExpiryAtInstant().getEpochSecond();
    }

    /**
     * @return Entity expiration time in epoch milliseconds.
     */
    default long getExpiryAtEpochMilli() {
        return getExpiryAtInstant().toEpochMilli();
    }

    /**
     * @return Entity expiration time in ISO_INSTANT string representation.
     */
    default String formatExpiryAtISOInstant() {
        return DateTimeFormatter.ISO_INSTANT.format(getExpiryAtInstant());
    }
}
