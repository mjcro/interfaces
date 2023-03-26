Micro-J interfaces
==================

| Name             |                Support                 | Methods                                                                                                       |
|------------------|:--------------------------------------:|---------------------------------------------------------------------------------------------------------------|
| `WithActive`     |               `boolean`                | `isActive`, `isNotActive*`                                                                                    |
| `WithDeleted`    |               `boolean`                | `isDeleted`, `isNotDeleted*`                                                                                  |
| `WithEnabled`    |               `boolean`                | `isEnabled`, `isNotEnabled*`, `isDisabled*`                                                                   |
| `WithVisible`    |               `boolean`                | `isVisible`, `isNotVisible*`, `isHidden*`                                                                     |
| `WithId`         | `int`,`long`,`short`,`string`,`byte[]` | `getId`, `hasId*`, `getIdBase64`                                                                              |
| `WithOptionalId` |     `int`,`long`,`short`,`string`      | `getId`, `hasId*`                                                                                             |
| `WithName`       |                `string`                | `getName`, `hasName*`                                                                                         |
| `WithTime`       |               `instant`                | `getTime`, `getTimeEpochSeconds*`,<br/>`getTimeEpochMilli*`, `formatTimeISOInstant*`                          |
 | `WithByteBody`   |                `byte[]`                | `getBody`, `isBodyEmpty*`,<br/>`isBodyPresent*`, `getBodyString*`,<br>`getBodyBase64*`, `getBodyInputStream*` |

- Marked with `*` are default implementations.