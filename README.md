Micro-J interfaces
==================

![Java8](https://img.shields.io/badge/Java-8-brightgreen)
![GitHub](https://img.shields.io/github/license/mjcro/interfaces)
![Snyk Vulnerabilities for GitHub Repo](https://img.shields.io/snyk/vulnerabilities/github/mjcro/interfaces)

A zero-dependency collection of lightweight Java interfaces designed for interoperability, domain modeling, and clean API contracts. Comes with useful default methods so you rarely need to write boilerplate.

## Features

- **Zero runtime dependencies** — only `jspecify` annotations at compile time
- **Java 8 compatible** — tested against Java 8, 11, 17, 21, and 25
- **Mix-in friendly** — small, single-purpose interfaces meant to be composed
- **Rich default methods** — each interface ships with derived helpers (e.g. `isNotEmpty`, `mustGetId`, `getTimeEpochMilli`)
- **Strong typing utilities** — `StrongType<T>`, `StrongLong`, `StrongInt` for value-object patterns
- **Functional extras** — tri-arity and exception-aware mirrors of `java.util.function.*`

## Installation

```xml
<dependency>
    <groupId>io.github.mjcro</groupId>
    <artifactId>interfaces</artifactId>
    <version>1.0.31</version>
</dependency>
```

## Contents

### Boolean flag interfaces (`io.github.mjcro.interfaces.booleans`)

Single-method interfaces that expose a boolean property, each with complementary default helpers.

| Interface     | Abstract method | Default helpers                   |
|---------------|-----------------|-----------------------------------|
| `WithActive`  | `isActive()`    | `isNotActive()`                   |
| `WithDeleted` | `isDeleted()`   | `isNotDeleted()`                  |
| `WithEmpty`   | `isEmpty()`     | `isNotEmpty()`                    |
| `WithEnabled` | `isEnabled()`   | `isNotEnabled()`, `isDisabled()`  |
| `WithPublic`  | `isPublic()`    | `isNotPublic()`                   |
| `WithVisible` | `isVisible()`   | `isNotVisible()`, `isHidden()`    |

### Enum-backed state interfaces (`io.github.mjcro.interfaces.enums`)

| Interface      | Abstract method | Default helpers                                              |
|----------------|-----------------|--------------------------------------------------------------|
| `WithState<E>` | `getState()`    | `hasState`, `notHasState`, `hasStateOneOf`, `notHasStateOneOf` |
| `WithStatus<E>`| `getStatus()`   | same pattern as above                                        |
| `WithType<E>`  | `getType()`     | same pattern as above                                        |

### Numeric ID interfaces

Available in three flavours — `ints`, `longs`, and `shorts` — each containing the same set:

| Interface             | Abstract method  | Default helpers               |
|-----------------------|------------------|-------------------------------|
| `WithId`              | `getId()`        | `hasId()`                     |
| `WithParentId`        | `getParentId()`  | `hasParentId()`               |
| `WithGateId`          | `getGateId()`    | `hasGateId()`                 |
| `WithScopeId`         | `getScopeId()`   | `hasScopeId()`                |
| `WithOptionalId`      | `getId()`        | `hasId()`, `mustGetId()`      |
| `WithOptionalParentId`| `getParentId()`  | `hasParentId()`, `mustGetParentId()` |
| `WithOrder`           | `getOrder()`     | —                             |
| `WithSize`            | `size()`         | `isEmpty()`, `isNotEmpty()`   |
| `WithTypeId`          | `getTypeId()`    | `hasTypeId()`                 |

### String interfaces (`io.github.mjcro.interfaces.strings`)

| Interface          | Abstract method | Default helpers         |
|--------------------|-----------------|-------------------------|
| `WithId`           | `getId()`       | `hasId()`               |
| `WithName`         | `getName()`     | `hasName()`             |
| `WithOptionalName` | `getName()`     | `hasName()`, `mustGetName()` |
| `WithText`         | `getText()`     | —                       |
| `WithUri`          | `getURI()`      | `hasURI()`              |
| `WithUrl`          | `getURL()`      | `hasURL()`              |

### Temporal interfaces (`io.github.mjcro.interfaces.instants`)

All `Instant`-based interfaces expose epoch-second, epoch-milli, and ISO-8601 formatting helpers by default.

| Interface               | Abstract method     |
|-------------------------|---------------------|
| `WithCreatedAt`         | `getCreatedAt()`    |
| `WithUpdatedAt`         | `getUpdatedAt()`    |
| `WithModifiedAt`        | `getModifiedAt()`   |
| `WithScheduledAt`       | `getScheduledAt()`  |
| `WithExpiryAt`          | `getExpiryAt()`     |
| `WithOptionalUpdatedAt`   | `getUpdatedAt()`  |
| `WithOptionalModifiedAt`  | `getModifiedAt()` |
| `WithOptionalScheduledAt` | `getScheduledAt()`|
| `WithOptionalExpiryAt`    | `getExpiryAt()`   |
| `WithTime`              | `getTime()`         |

Duration interfaces (`io.github.mjcro.interfaces.durations`):

| Interface     | Abstract method  | Default helpers                                                       |
|---------------|------------------|-----------------------------------------------------------------------|
| `WithElapsed` | `getElapsed()`   | `getElapsedSeconds()`, `getElapsedMillis()`, `getElapsedNanos()`     |

### Byte-body interface (`io.github.mjcro.interfaces.bytes`)

| Interface      | Abstract method | Default helpers                                                    |
|----------------|-----------------|-------------------------------------------------------------------|
| `WithByteBody` | `getBody()`     | `isBodyEmpty()`, `isBodyPresent()`, `getBodyString()`, `getBodyBase64()`, `getBodyInputStream()` |

### Strong types

Wrap primitives or objects in named types for compile-time safety and better domain modelling.

```java
// Define once
record UserId(long value) implements StrongLong {}
record Email(String value) implements StrongType<String> {}

// Use with confidence
boolean same = userId.hasValue(42L);
boolean valid = email.hasValueOneOf("a@b.com", "c@d.com");
```

| Interface          | Underlying type | Key methods                               |
|--------------------|-----------------|-------------------------------------------|
| `StrongType<T>`    | generic `T`     | `value()`, `hasValue()`, `hasValueOneOf()`|
| `StrongLong`       | `long`          | `value()`, `hasValue()`                   |
| `StrongInt`        | `int`           | `value()`, `hasValue()`                   |
| `StrongLongId`     | `long`          | extends `StrongLong` + `WithId`           |
| `StrongIntId`      | `int`           | extends `StrongInt` + `WithId`            |

### Functional interfaces (`io.github.mjcro.interfaces.functions`)

**Tri-arity extensions** of `java.util.function.*`:

- `TriConsumer<A, B, C>`
- `TriFunction<A, B, C, R>`
- `TriPredicate<A, B, C>`

**Exceptional variants** — mirrors of the standard functional interfaces that declare `throws Exception`, with static `from*` factory methods for bridging plain lambdas:

- `ExceptionalConsumer<T>` / `ExceptionalBiConsumer<T, U>` / `ExceptionalTriConsumer<A, B, C>`
- `ExceptionalFunction<T, R>` / `ExceptionalBiFunction<T, U, R>` / `ExceptionalTriFunction<A, B, C, R>`
- `ExceptionalPredicate<T>` / `ExceptionalBiPredicate<T, U>` / `ExceptionalTriPredicate<A, B, C>`
- `ExceptionalSupplier<T>`
- `ExceptionalUnaryOperator<T>`

### Utility interfaces

| Interface             | Package                | Purpose                                                    |
|-----------------------|------------------------|------------------------------------------------------------|
| `Decorator<T>`        | root                   | Wrapper pattern; `getDecoratedRoot()` recursively unwraps  |
| `Mixed`               | root                   | Typed access to an `Object` value (`getAs(Class)`, `mustGetAs`, typed shortcuts) |
| `Converter<F, T>`     | `convert`              | Single-method type conversion                              |
| `ConverterFactory`    | `convert`              | Factory producing `Converter` instances                    |
| `SelfTyped<S>`        | `builders`             | Self-referential type for fluent builders                  |
| `SelfTypedBuilder<S>` | `builders`             | Builder variant of `SelfTyped`                             |
| `Starter`             | `lifecycle`            | `start()` — component startup hook                        |
| `Stopper`             | `lifecycle`            | `stop()` — component shutdown hook                        |
| `Cache<K, V>`         | `cache`                | Simple get/put cache contract                              |
| `Invalidator`         | `cache`                | Cache invalidation                                         |
| `NamedCacheFactory`   | `cache`                | Creates named cache instances                              |
| `Statement`           | `database`             | Database statement abstraction                             |
| `Tuple` / `Pair<F,S>` / `OptionalPair<F,S>` | `tuples` | Immutable tuple types                     |
| `IdRepository<T>`     | `longs`                | CRUD repository keyed by `long` ID                         |

### Security (`io.github.mjcro.interfaces.security`)

| Interface                | Package            | Purpose                                                                 |
|--------------------------|--------------------|-------------------------------------------------------------------------|
| `Sensitive`              | `security`         | Marker interface for any object that holds or contains sensitive data    |
| `SensitiveStrongType<T>` | `security`        | `AutoCloseable` wrapper for sensitive values (passwords, tokens, keys); erases the underlying data on `close()` and throws `NoSuchElementException` on any subsequent `value()` call |
| `ByteHasher`             | `security.hashing` | Byte-array hashing contract                                            |

```java
try (SensitiveStrongType<char[]> password = acquirePassword()) {
    authenticate(password.value());
} // underlying char[] zeroed here; further value() calls throw NoSuchElementException
```

### Integration (`io.github.mjcro.interfaces.integration`)

A layered abstraction for synchronous integration with external services built around three distinct concerns:

| Interface       | Role |
|-----------------|------|
| `Option`        | Immutable configuration value (timeout, credentials, retry policy, …) passed to a `Transport` at construction time |
| `Transport`     | Low-level wire layer; works exclusively with **DTOs** that mirror the remote service's wire format |
| `Client`        | High-level facade; works exclusively with **domain entities**; converts domain → DTO before calling `Transport` and DTO → domain on the way back |
| `Call<R, C extends Client>` | Command object: captures all request parameters at construction time and dispatches through a `Client` via `execute(client)` |

**Layering rule:** `Call` → `Client` (domain entities) → `Transport` (DTOs) → wire.

```java
// All request data bound at construction time
Call<Order, OrderClient> call = new GetOrderCall(orderId);

// Execute against any compatible client
Order order = call.execute(client);
```

### Experimental: integration (`io.github.mjcro.interfaces.experimental.integration`)

> These interfaces are subject to change.

Abstractions for synchronous and asynchronous transports:

- `Transport` / `AsyncTransport`
- `TransportFactory` / `AsyncTransportFactory`
- `Call`, `Packet`, `Option`, `TelemetryConsumer`
- HTTP specialisation: `HttpTransport`, `HttpAsyncTransport`, `HttpRequest`

## Design conventions

- Every `get*` method has a corresponding `has*` returning `boolean`.
- Every `get*` returning `Optional<?>` has:
  - a `mustGet*` throwing `NoSuchElementException` when empty
  - a `has*()` boolean shortcut
- Default implementations are additive — only the one abstract method needs implementing.

## License

[MIT](LICENSE)
