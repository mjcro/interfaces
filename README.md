Micro-J interfaces
==================

Easy to adopt zero-dependency collection of helpful common interfaces,
sugared with some consistent default methods.

## Basic interfaces

| Name                      |                Supports                | Methods                                                                                                                                              |
|---------------------------|:--------------------------------------:|------------------------------------------------------------------------------------------------------------------------------------------------------|
| `WithActive`              |               `boolean`                | `isActive`, `isNotActive*`                                                                                                                           |
| `WithDeleted`             |               `boolean`                | `isDeleted`, `isNotDeleted*`                                                                                                                         |
| `WithEmpty`               |               `boolean`                | `isEmpty`, `isNotEmpty*`                                                                                                                             |
| `WithEnabled`             |               `boolean`                | `isEnabled`, `isNotEnabled*`, `isDisabled*`                                                                                                          |
| `WithPublich`             |               `boolean`                | `isPublic`, `isNotPublic*`                                                                                                                           |
| `WithVisible`             |               `boolean`                | `isVisible`, `isNotVisible*`, `isHidden*`                                                                                                            |
| `WithState`               |                 `enum`                 | `getState`, `hasState*`, `hasStateOneOf*`                                                                                                            |
| `WithStatus`              |                 `enum`                 | `getStatus`, `hasStatus*`, `hasStatusOneOf*`                                                                                                         |
| `WithType`                |                 `enum`                 | `getType`, `hasType*`, `hasTypeOneOf*`                                                                                                               |
| `WithId`                  | `int`,`long`,`short`,`string`,`byte[]` | `getId`, `hasId*`, `getIdBase64*`                                                                                                                    |
| `WithParentId`            |          `int`,`long`,`short`          | `getParentId`, `hasParentId*`                                                                                                                        |
| `WithGateId`              |          `int`,`long`,`short`          | `getGateId`, `hasGateId*`                                                                                                                            |
| `WithScopeId`             |          `int`,`long`,`short`          | `getScopeId`, `hasScopeId*`                                                                                                                          |
| `WithOptionalId`          |     `int`,`long`,`short`,`string`      | `getId`, `hasId*`, `mustGetId*`                                                                                                                      |
| `WithOptionalParentId`    |          `int`,`long`,`short`          | `getParentId`, `hasParentId*`,<br/>`mustGetParentId`                                                                                                 |
| `WithSize`                |                 `int`                  | `size`, `isEmpty*`, `isNotEmpty*`                                                                                                                    |
| `WithName`                |                `string`                | `getName`, `hasName*`                                                                                                                                |
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

- Marked with `*` are default implementations.

## Design hints

- Any interface with `get*` has corresponding `has*` returning `boolean`
- Any interface with `get*` returning `Optional<?>`:
    - Has corresponding `mustGet*` getter
    - Has corresponding `has*` method with no arguments