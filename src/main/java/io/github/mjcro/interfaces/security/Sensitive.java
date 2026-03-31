package io.github.mjcro.interfaces.security;

/**
 * Interface for any object that holds or contains sensitive data
 * such as passwords, API tokens, private keys, or personally identifiable
 * information.
 *
 * <p>Extends {@link AutoCloseable} so that every sensitive object supports
 * the try-with-resources idiom, allowing implementations to erase or release
 * sensitive data when they are no longer needed.
 *
 * <p>Use this interface to tag both strong-type wrappers around raw sensitive
 * values (see {@link SensitiveStrongType}) and higher-level containers that
 * include sensitive fields among other data:
 * <pre>{@code
 * // Strong-type wrapper – use SensitiveStrongType instead
 * class Password implements SensitiveStrongType<char[]> { … }
 *
 * // Container with a sensitive field
 * class UserCredentials implements Sensitive {
 *     private final String username;
 *     private final SensitiveStrongType&lt;char[]&gt; password;
 *     …
 * }
 * }</pre>
 *
 * <p>Code that handles logging, serialization, or debugging output should
 * check for this interface and redact or omit the object's content accordingly.
 *
 * @see SensitiveStrongType
 */
public interface Sensitive extends AutoCloseable {
}
