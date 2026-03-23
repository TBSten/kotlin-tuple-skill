# Kotlin Tuple Skill

A [Claude Code](https://docs.anthropic.com/en/docs/claude-code) skill that generates type-safe Tuple utilities (Tuple0–Tuple20) for Kotlin (Multiplatform) projects.

> Japanese version: [README.ja.md](./README.ja.md)

## Installation

```bash
npx skills add tbsten/kotlin-tuple-skill
```

## Features

This skill auto-generates the following 4 files:

| File | Description |
|---|---|
| `Tuple.kt` | Data class definitions for Tuple0–Tuple20 |
| `TupleFactory.kt` | `tupleOf()` factory functions (0–20 arguments) |
| `AwaitAll.kt` | Type-safe `awaitAll()` for 1–20 `Deferred` values |
| `AllNotNullOrNull.kt` | `allNotNullOrNull()` top-level and extension functions |

## Usage

After installing the skill, Claude Code will automatically activate it when you make requests like:

- "Add Tuple utilities"
- "Generate tupleOf"
- "I need a type-safe awaitAll"
- "Await multiple Deferred values with type safety"
- "Check multiple nullable values for non-null at once"

The package name and output directory will be inferred from your project structure or confirmed interactively.
