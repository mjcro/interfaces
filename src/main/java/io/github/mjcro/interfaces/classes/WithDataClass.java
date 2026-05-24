package io.github.mjcro.interfaces.classes;

import org.jspecify.annotations.NonNull;


/**
 * Mixin interface for entities that expose a data class descriptor.
 */
public interface WithDataClass {
    /**
     * @return Data class.
     */
    @NonNull Class<?> getDataClass();
}
