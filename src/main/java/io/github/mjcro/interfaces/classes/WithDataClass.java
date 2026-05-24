package io.github.mjcro.interfaces.classes;

import org.jspecify.annotations.NonNull;


/**
 * Mixin interface for entities that expose a data class descriptor.
 */
public interface WithDataClass {
    /**
     * Returns the data class represented by this object.
     *
     * @return Data class represented by this object.
     */
    @NonNull Class<?> getDataClass();
}
