Micro-J interfaces
==================

![Java8](https://img.shields.io/badge/Java-8-brightgreen)
![GitHub](https://img.shields.io/github/license/mjcro/interfaces)
![Snyk Vulnerabilities for GitHub Repo](https://img.shields.io/snyk/vulnerabilities/github/mjcro/interfaces)

Easy to adopt zero-dependency collection of helpful common interfaces,
sugared with some consistent default methods.

## Motivation

1. Interoperability. Utilizing this library increases chances of writing interoperable software.
2. Sugar. This library contains some utility default method for interfaces it provides.

## Distribution

```xml
<dependency>
    <groupId>io.github.mjcro</groupId>
    <artifactId>interfaces</artifactId>
    <version>1.0.3</version>
</dependency>
```

## Basic interfaces

| Name                      |                Supports                | Methods                                                                                                                                              |
|---------------------------|:--------------------------------------:|------------------------------------------------------------------------------------------------------------------------------------------------------|
| `WithActive`              |               `boolean`                | `isActive`, `isNotActive*`                                                                                                                           |
| `WithDeleted`             |               `boolean`                | `isDeleted`, `isNotDeleted*`                                                                                                                         |
| `WithEmpty`               |               `boolean`                | `isEmpty`, `isNotEmpty*`                                                                                                                             |
| `WithEnabled`             |               `boolean`                | `isEnabled`, `isNotEnabled*`, `isDisabled*`                                                                                                          |
| `WithPublich`             |               `boolean`                | `isPublic`, `isNotPublic*`                                                                                                                           |
| `WithVisible`             |               `boolean`                | `isVisible`, `isNotVisible*`, `isHidden*`                                                                                                            |
| `WithState`               |                 `enum`                 | `getState`, `hasState*`, `notHasState*`,<br/>`hasStateOneOf*`, `notHasStateOneOf*`                                                                   |
| `WithStatus`              |                 `enum`                 | `getStatus`, `hasStatus*`, `notHasStatus*`,<br/>`hasStatusOneOf*`, `notHasStatusOneOf*`                                                              |
| `WithType`                |                 `enum`                 | `getType`, `hasType*`, `notHasType*`,<br/>`hasTypeOneOf*`, `notHasTypeOneOf*`                                                                        |
| `WithId`                  | `int`,`long`,`short`,`string`,`byte[]` | `getId`, `hasId*`, `getIdBase64*`                                                                                                                    |
| `WithParentId`            |          `int`,`long`,`short`          | `getParentId`, `hasParentId*`                                                                                                                        |
| `WithGateId`              |          `int`,`long`,`short`          | `getGateId`, `hasGateId*`                                                                                                                            |
| `WithScopeId`             |          `int`,`long`,`short`          | `getScopeId`, `hasScopeId*`                                                                                                                          |
| `WithOptionalId`          |     `int`,`long`,`short`,`string`      | `getId`, `hasId*`, `mustGetId*`                                                                                                                      |
| `WithOptionalParentId`    |          `int`,`long`,`short`          | `getParentId`, `hasParentId*`,<br/>`mustGetParentId`                                                                                                 |
| `WithSize`                |                 `int`                  | `size`, `isEmpty*`, `isNotEmpty*`                                                                                                                    |
| `WithTypeId`              |                 `int`                  | `getTypeId`, `hasTypeId*`                                                                                                                            |
| `WithName`                |                `string`                | `getName`, `hasName*`                                                                                                                                |
| `WithUri`                 |                `string`                | `getURI`, `hasURI*`                                                                                                                                  |
| `WithOptionalName`        |                `string`                | `getName`, `hasName*`, `mustGetName*`                                                                                                                |
| `WithElapsed`             |               `duration`               | `getElapsed`, `getElapsedSeconds*`,<br/>`getElapsedMillis*`, `getElapsedNanos*`                                                                      |
| `WithTime`                |               `instant`                | `getTime`, `getTimeEpochSeconds*`,<br/>`getTimeEpochMilli*`, `formatTimeISOInstant*`                                                                 |
| `WithCreatedAt`           |               `instant`                | `getCreatedAt`, `getCreatedAtEpochSeconds*`,<br/>`getCreatedAtEpochMilli*`,`formatCreatedAtISOInstant*`                                              |
| `WithExpiryAt`            |               `instant`                | `getExpiryAt`, `getExpiryAtEpochSeconds*`,<br/>`getExpiryAtEpochMilli*`,`formatExpiryAtISOInstant*`                                                  |
| `WithModifiedAt`          |               `instant`                | `getModifiedAt`, `getModifiedAtEpochSeconds*`,<br/>`getModifiedAtEpochMilli*`,`formatModifiedAtISOInstant*`                                          |
| `WithScheduledAt`         |               `instant`                | `getScheduledAt`, `getScheduledAtEpochSeconds*`,<br/>`getScheduledAtEpochMilli*`,`formatScheduledAtISOInstant*`                                      |
| `WithUpdatedAt`           |               `instant`                | `getUpdatedAt`, `getUpdatedAtEpochSeconds*`,<br/>`getUpdatedAtEpochMilli*`,`formatUpdatedAtISOInstant*`                                              |
| `WithOptionalExpiryAt`    |               `instant`                | `getUpdatedAt`, `hasExpiryAt*`,<br/>`mustGetExpiryAt`, `getUpdatedAtEpochSeconds*`,<br/>`getUpdatedAtEpochMilli*`,`formatUpdatedAtISOInstant*`       |
| `WithOptionalModifiedAt`  |               `instant`                | `getUpdatedAt`, `hasModifiedAt*`,<br/>`mustGetModifiedAt`, `getUpdatedAtEpochSeconds*`,<br/>`getUpdatedAtEpochMilli*`,`formatUpdatedAtISOInstant*`   |
| `WithOptionalScheduledAt` |               `instant`                | `getUpdatedAt`, `hasScheduledAt*`,<br/>`mustGetScheduledAt`, `getUpdatedAtEpochSeconds*`,<br/>`getUpdatedAtEpochMilli*`,`formatUpdatedAtISOInstant*` |
| `WithOptionalUpdatedAt`   |               `instant`                | `getUpdatedAt`, `hasUpdatedAt*`,<br/>`mustGetUpdatedAt`, `getUpdatedAtEpochSeconds*`,<br/>`getUpdatedAtEpochMilli*`,`formatUpdatedAtISOInstant*`     |
| `WithByteBody`            |                `byte[]`                | `getBody`, `isBodyEmpty*`,<br/>`isBodyPresent*`, `getBodyString*`,<br>`getBodyBase64*`, `getBodyInputStream*`                                        |
| `WithDataClass`           |                `class`                 | `getDataClass`                                                                                                                                       |
| `WithException`           |              `exception`               | `getException`                                                                                                                                       |
| `WithOptionalException`   |              `exception`               | `getException`, `hasException*`, `hasNoException*`                                                                                                   | 

- Marked with `*` are default implementations.

## Design hints

- Any interface with `get*` has corresponding `has*` returning `boolean`
- Any interface with `get*` returning `Optional<?>`:
    - Has corresponding `mustGet*` getter
    - Has corresponding `has*` method with no arguments

## Functional interfaces

- `TriConsumer<A, B, C>` - like `BiConsumer` but with three arguments
- `TriFunction<A, B, C, R>` - like `BiFunction` but with three arguments
- `TriPredicate<A, B, C>` - like `BiPredicate` but with three arguments

### Exceptional

Set of interfaces mirroring `java.util.function.*` but able to throw checked exceptions.
All of them are `@FunctionalInterface`, all have `from*` static methods to convert plain Java functions into
exceptionals.

- `ExceptionalBiConsumer<T, U>`
- `ExceptionalBiFunction<T, U, R>`
- `ExceptionalConsumer<T>`
- `ExceptionalFunction<T, R>`
- `ExceptionalSupplier<T>`
- `ExceptionalTriConsumer<A, B, C>`
- `ExceptionalTriFunction<A, B, C, R>`
- `ExceptionalUnaryOperator<T>`