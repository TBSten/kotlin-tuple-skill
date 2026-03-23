---
name: kotlin-tuple
description: >
  Generates type-safe Tuple utilities (Tuple0–Tuple20) for Kotlin and Kotlin Multiplatform projects.
  Creates Tuple data classes, tupleOf factories, toList conversion, KSerializer for kotlinx.serialization, type-safe awaitAll, and allNotNullOrNull in one go.
  Use when requested: "add Tuple", "generate tupleOf", "type-safe Tuple", "type-safe awaitAll",
  "add allNotNullOrNull", "await multiple Deferred with type safety",
  "null-check multiple nullable values at once".
  For Kotlin/KMP projects where Pair/Triple is not enough for multi-element grouping.
---

# Kotlin Tuple Utility Generation Skill

Generates type-safe Tuple utilities for Kotlin and Kotlin Multiplatform projects.
Produces data classes from Tuple0 to TupleN, along with factory functions and optional utilities.

## Usage

Before generating code, confirm the following with the user in **a single message**.

### Confirmation Items

1. **Target module** (for multi-module projects, which module to generate into)
   - Analyze the project structure and suggest a candidate module
   - Ask the user to confirm or specify a different module
2. **Package name and output directory**
   - Infer from the module's existing package structure and suggest a candidate
   - Ask the user to confirm or specify a different package name
3. **Maximum Tuple size** (default: 20)
   - Ask: "Generate Tuple0–Tuple20 (default)? Enter a different number to change."
4. **File types to generate** (default: all)
   - Let the user select (multiple choice):
     - [x] `Tuple.kt` + `TupleFactory.kt` — Tuple data classes and tupleOf factories (required, always generated)
     - [x] `TupleToList.kt` — `toList()` extension functions (see [tuple-to-list.md](./tuple-to-list.md))
     - [x] `TupleSerializer.kt` — KSerializer for kotlinx.serialization (see [tuple-serializer.md](./tuple-serializer.md))
     - [x] `AwaitAll.kt` — Type-safe awaitAll (see [await-all.md](./await-all.md))
     - [x] `AllNotNullOrNull.kt` — allNotNullOrNull utility (see [all-not-null-or-null.md](./all-not-null-or-null.md))

### Output Directory Detection

Detect the source set directory based on the module type:

| Module type | Source directory pattern |
|---|---|
| Kotlin Multiplatform (commonMain) | `<module>/src/commonMain/kotlin/` |
| JVM / Android (main) | `<module>/src/main/kotlin/` or `<module>/src/main/java/` |
| Single-module project | `src/main/kotlin/` or `src/main/java/` |

Detection steps:
1. Check `build.gradle.kts` / `build.gradle` for KMP plugin (`kotlin("multiplatform")`) or JVM/Android plugin
2. Look for existing `src/commonMain/kotlin`, `src/main/kotlin`, or `src/main/java` directories
3. Append the package path (e.g., `com.example.tuple` → `com/example/tuple/`)

### Example Confirmation Message

```
I'll generate Tuple utilities. Let me confirm the following:

1. Target module: **shared** (detected)
   → Enter a different module name if needed

2. Package: `com.example.tuple` (detected)
   Output: `shared/src/commonMain/kotlin/com/example/tuple/`
   → Enter a different package name if needed

3. Max Tuple size: **20** (default)
   → Enter a number to change

4. Files to generate:
   - [x] Tuple.kt + TupleFactory.kt (required)
   - [x] TupleToList.kt (toList() conversion)
   - [x] TupleSerializer.kt (kotlinx.serialization support)
   - [x] AwaitAll.kt (type-safe awaitAll)
   - [x] AllNotNullOrNull.kt (null-safety utility)
   → Uncheck any you don't need

OK to proceed?
```

### After Confirmation

1. Finalize the generation scope based on the user's answers
2. For each selected optional file, **read the corresponding reference file** to get the detailed generation rules:
   - TupleToList.kt → read [tuple-to-list.md](./tuple-to-list.md)
   - TupleSerializer.kt → read [tuple-serializer.md](./tuple-serializer.md)
   - AwaitAll.kt → read [await-all.md](./await-all.md)
   - AllNotNullOrNull.kt → read [all-not-null-or-null.md](./all-not-null-or-null.md)
3. Generate all selected files **in parallel** (each file is independent — use parallel tool calls to write them simultaneously)
4. If TupleSerializer.kt is selected, verify `kotlinx-serialization` plugin and dependency in build.gradle.kts
5. If AwaitAll.kt is selected, verify `kotlinx-coroutines` dependency in build.gradle.kts

## Files to Generate

Let N be the max size (default N=20).

| File | Description | Required | Reference |
|---|---|---|---|
| `Tuple.kt` | Data class definitions for Tuple0–TupleN | Required | (below) |
| `TupleFactory.kt` | `tupleOf()` factory functions (0–N args) | Required | (below) |
| `TupleToList.kt` | `toList()` extension functions for Tuple → `List<Base>` | Optional | [tuple-to-list.md](./tuple-to-list.md) |
| `TupleSerializer.kt` | `KSerializer` implementations for kotlinx.serialization | Optional | [tuple-serializer.md](./tuple-serializer.md) |
| `AwaitAll.kt` | Type-safe `awaitAll()` for 1–N Deferred values | Optional | [await-all.md](./await-all.md) |
| `AllNotNullOrNull.kt` | `allNotNullOrNull()` top-level and extension functions | Optional | [all-not-null-or-null.md](./all-not-null-or-null.md) |

## Design Rules

### Property Naming Convention

Use ordinal names. Since Tuple2/Tuple3 are typealiases for Pair/Triple, `first/second/third` naturally align.

| Position | Property | Position | Property |
|---:|---|---:|---|
| 1 | `first` | 11 | `eleventh` |
| 2 | `second` | 12 | `twelfth` |
| 3 | `third` | 13 | `thirteenth` |
| 4 | `fourth` | 14 | `fourteenth` |
| 5 | `fifth` | 15 | `fifteenth` |
| 6 | `sixth` | 16 | `sixteenth` |
| 7 | `seventh` | 17 | `seventeenth` |
| 8 | `eighth` | 18 | `eighteenth` |
| 9 | `ninth` | 19 | `nineteenth` |
| 10 | `tenth` | 20 | `twentieth` |

### Tuple.kt

- `Tuple0` is a `data object` (no elements)
- `Tuple1<A0>` is a `data class` (single element)
- `Tuple2<A0, A1>` is a `typealias` for `Pair<A0, A1>` (reuses Kotlin standard Pair)
- `Tuple3<A0, A1, A2>` is a `typealias` for `Triple<A0, A1, A2>` (reuses Kotlin standard Triple)
- `Tuple4`–`TupleN` are `data class`es with ordinal-named properties
- All Tuples override `toString()`: `"($first, $second, ...)"` format
  - Tuple0 returns `"()"`
  - Tuple2/Tuple3 are typealiases, so no toString override needed (uses Pair/Triple defaults)

```kotlin
// Example: Tuple4
data class Tuple4<A0, A1, A2, A3>(
    val first: A0,
    val second: A1,
    val third: A2,
    val fourth: A3,
) {
    override fun toString(): String = "($first, $second, $third, $fourth)"
}
```

### TupleFactory.kt

Define a `tupleOf()` factory function for each Tuple.

```kotlin
fun tupleOf(): Tuple0 = Tuple0
fun <A0> tupleOf(first: A0): Tuple1<A0> = Tuple1(first)
fun <A0, A1> tupleOf(first: A0, second: A1): Tuple2<A0, A1> = Tuple2(first, second)
fun <A0, A1, A2> tupleOf(first: A0, second: A1, third: A2): Tuple3<A0, A1, A2> = Tuple3(first, second, third)
fun <A0, A1, A2, A3> tupleOf(first: A0, second: A1, third: A2, fourth: A3): Tuple4<A0, A1, A2, A3> = Tuple4(first, second, third, fourth)
// ... up to TupleN
```

- `Tuple2(first, second)` is equivalent to `Pair(first, second)` (typealias)
- `Tuple3(first, second, third)` is equivalent to `Triple(first, second, third)` (typealias)

## Code Generation Tips

The code generated by this skill is highly repetitive (N+1 patterns from Tuple0 to TupleN).
Keep the following in mind:

- Type parameter naming: `A0`, `A1`, ..., `A19` (0-indexed)
- Property naming: `first`, `second`, `third`, `fourth`, ... `twentieth` (ordinal names, see naming table above)
- The number of type parameters and properties must match for each Tuple
- Don't forget the Tuple2 = Pair, Tuple3 = Triple typealiases
- Don't forget the `package` declaration at the top of each file
