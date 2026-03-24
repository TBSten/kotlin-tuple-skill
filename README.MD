# Kotlin Tuple Skill

[日本語](./README.ja.md) | [DeepWiki](https://deepwiki.com/TBSten/kotlin-tuple-skill)

A [Claude Code](https://docs.anthropic.com/en/docs/claude-code) skill that generates type-safe Tuple utilities (Tuple0–Tuple20) for Kotlin and Kotlin Multiplatform projects.

## Quick Start

### 1. Install the skill:

```bash
npx skills add tbsten/kotlin-tuple-skill
```

### 2. Ask your AI agent:

```
Add type-safe Tuple utilities to this project with default settings.
```

That's it! The skill will detect your project structure, confirm settings, and generate all Tuple files.

## Features

This skill auto-generates up to 6 files:

| File | Description | Required |
|---|---|---|
| `Tuple.kt` | Data class definitions for Tuple0–TupleN | Required |
| `TupleFactory.kt` | `tupleOf()` factory functions (0–N arguments) | Required |
| `TupleToList.kt` | `toList()` extension functions | Optional |
| `TupleSerializer.kt` | `KSerializer` implementations for kotlinx.serialization | Optional |
| `AwaitAll.kt` | Type-safe `awaitAll()` for 1–N `Deferred` values | Optional |
| `AllNotNullOrNull.kt` | `allNotNullOrNull()` top-level and extension functions | Optional |

The max Tuple size (N), target module, and which optional files to generate are all confirmed interactively before generation.

## Usage

After installing the skill, Claude Code will automatically activate it when you make requests like:

- "Add Tuple utilities"
- "Generate tupleOf"
- "I need a type-safe awaitAll"
- "Await multiple Deferred values with type safety"
- "Check multiple nullable values for non-null at once"

The package name and output directory will be inferred from your project structure or confirmed interactively.

## Repository Structure

```
skills/kotlin-tuple/
└── SKILL.md          ← Only this directory is installed by `npx skills add`
```

README and other repo files are not included when installing the skill.
