Micro-J interfaces
==================

| Name             |                Supports                | Methods                                                                                                       |
|------------------|:--------------------------------------:|---------------------------------------------------------------------------------------------------------------|
| `WithActive`     |               `boolean`                | `isActive`, `isNotActive*`                                                                                    |
| `WithDeleted`    |               `boolean`                | `isDeleted`, `isNotDeleted*`                                                                                  |
| `WithEnabled`    |               `boolean`                | `isEnabled`, `isNotEnabled*`, `isDisabled*`                                                                   |
| `WithVisible`    |               `boolean`                | `isVisible`, `isNotVisible*`, `isHidden*`                                                                     |
| `WithState`      |                 `enum`                 | `getState`, `hasState*`, `hasStateOneOf*`                                                                     |
| `WithStatus`     |                 `enum`                 | `getStatus`, `hasStatus*`, `hasStatusOneOf*`                                                                  |
| `WithType`       |                 `enum`                 | `getType`, `hasType*`, `hasTypeOneOf*`                                                                        |
| `WithId`         | `int`,`long`,`short`,`string`,`byte[]` | `getId`, `hasId*`, `getIdBase64`                                                                              |
| `WithOptionalId` |     `int`,`long`,`short`,`string`      | `getId`, `hasId*`                                                                                             |
| `WithName`       |                `string`                | `getName`, `hasName*`                                                                                         |
| `WithTime`       |               `instant`                | `getTime`, `getTimeEpochSeconds*`,<br/>`getTimeEpochMilli*`, `formatTimeISOInstant*`                          |
 | `WithByteBody`   |                `byte[]`                | `getBody`, `isBodyEmpty*`,<br/>`isBodyPresent*`, `getBodyString*`,<br>`getBodyBase64*`, `getBodyInputStream*` |

- Marked with `*` are default implementations.