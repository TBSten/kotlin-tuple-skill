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

Generates type-safe Tuple utilities for Kotlin/KMP projects by copying pre-built example files and adjusting package names.

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
     - [x] `TupleToList.kt` — `toList()` extension functions
     - [x] `TupleSerializer.kt` — KSerializer for kotlinx.serialization
     - [x] `AwaitAll.kt` — Type-safe awaitAll
     - [x] `AllNotNullOrNull.kt` — allNotNullOrNull utility

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

## Generation Method: Copy from Example

This skill ships pre-built example files under `example/src/commonMain/kotlin/com/example/tuple/`.
**Do NOT generate code from scratch.** Instead, copy example files and adjust them.

### Step-by-step

1. Determine the absolute path of the example directory relative to this skill's location:
   - Example files: `<skill_dir>/example/src/commonMain/kotlin/com/example/tuple/`
2. Create the target output directory (if not exists)
3. **Copy selected files** from the example directory to the target output directory using Bash `cp`
   - Always copy: `Tuple.kt`, `TupleFactory.kt`
   - Copy if selected: `TupleToList.kt`, `TupleSerializer.kt`, `AwaitAll.kt`, `AllNotNullOrNull.kt`
4. **Replace package name** in all copied files using Bash `sed`:
   ```bash
   sed -i '' 's/package com\.example\.tuple/package <USER_PACKAGE>/g' <TARGET_DIR>/*.kt
   ```
   Also replace import statements if the package is used in imports:
   ```bash
   sed -i '' 's/import com\.example\.tuple\./import <USER_PACKAGE>./g' <TARGET_DIR>/*.kt
   ```
5. **If max Tuple size < 20**: Read each copied file and remove Tuple definitions beyond N.
   - Each file has clearly separated blocks per Tuple size — remove lines for Tuple(N+1) through Tuple20
6. **If max Tuple size > 20**: Read the reference `.md` files to understand the pattern, then extend the copied files.
   - Reference files: [tuple-to-list.md](./tuple-to-list.md), [tuple-serializer.md](./tuple-serializer.md), [await-all.md](./await-all.md), [all-not-null-or-null.md](./all-not-null-or-null.md)
7. **Verify dependencies** in `build.gradle.kts`:
   - If TupleSerializer.kt is included → verify `kotlinx-serialization` plugin and dependency
   - If AwaitAll.kt is included → verify `kotlinx-coroutines` dependency

### Why This Approach

- The example files contain ~2,600 lines of repetitive Kotlin code (Tuple0–Tuple20)
- Copying and `sed`-replacing is far more efficient than generating from scratch
- Minimizes context consumption and eliminates generation errors
