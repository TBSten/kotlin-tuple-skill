# Kotlin Tuple Skill

[English](./README.md) | [DeepWiki](https://deepwiki.com/TBSten/kotlin-tuple-skill)

Kotlin / Kotlin Multiplatform プロジェクトに型安全な Tuple ユーティリティ (Tuple0〜Tuple20) を生成する [Claude Code](https://docs.anthropic.com/en/docs/claude-code) スキルです。

## クイックスタート

### 1. スキルをインストール:

```bash
npx skills add tbsten/kotlin-tuple-skill
```

### 2. AI エージェントに依頼:

```
このプロジェクトに型安全な Tuple ユーティリティをデフォルト設定で追加して。
```

これだけで、スキルがプロジェクト構造を検出し、設定を確認した上で Tuple ファイルを生成します。

## 機能

最大 6 ファイルを自動生成します。

| ファイル | 内容 | 必須 |
|---|---|---|
| `Tuple.kt` | Tuple0〜TupleN のデータクラス定義 | 必須 |
| `TupleFactory.kt` | `tupleOf()` ファクトリ関数 (0〜N 引数) | 必須 |
| `TupleToList.kt` | `toList()` 拡張関数 | 選択 |
| `TupleSerializer.kt` | kotlinx.serialization 用 `KSerializer` 実装 | 選択 |
| `AwaitAll.kt` | 型安全な `awaitAll()` (Deferred 1〜N 個) | 選択 |
| `AllNotNullOrNull.kt` | `allNotNullOrNull()` トップレベル関数 + 拡張関数 | 選択 |

Tuple の最大サイズ (N)、生成先モジュール、どのオプションファイルを生成するかは、生成前に対話的に確認されます。

## 使い方

スキルをインストール後、Claude Code に以下のようなリクエストをすると自動的にスキルが発動します。

- 「Tuple を追加して」
- 「tupleOf を生成して」
- 「型安全な awaitAll が欲しい」
- 「複数の Deferred を型安全に await したい」
- 「nullable な値をまとめて non-null チェックしたい」

パッケージ名と出力先ディレクトリはプロジェクト構造から推測、または確認の上で生成されます。

## リポジトリ構成

```
skills/kotlin-tuple/
└── SKILL.md          ← `npx skills add` でインストールされるのはこのディレクトリのみ
```

README などのリポジトリファイルはスキルのインストールには含まれません。
