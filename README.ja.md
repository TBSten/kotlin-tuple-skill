# Kotlin Tuple Skill

Kotlin (Multiplatform) プロジェクトに型安全な Tuple ユーティリティ (Tuple0〜Tuple20) を生成する [Claude Code](https://docs.anthropic.com/en/docs/claude-code) スキルです。

> English version: [README.MD](./README.MD)

## インストール

```bash
npx skills add tbsten/kotlin-tuple-skill
```

## 機能

以下の 4 ファイルを自動生成します。

| ファイル | 内容 |
|---|---|
| `Tuple.kt` | Tuple0〜Tuple20 のデータクラス定義 |
| `TupleFactory.kt` | `tupleOf()` ファクトリ関数 (0〜20 引数) |
| `AwaitAll.kt` | 型安全な `awaitAll()` (Deferred 1〜20 個) |
| `AllNotNullOrNull.kt` | `allNotNullOrNull()` トップレベル関数 + 拡張関数 |

## 使い方

スキルをインストール後、Claude Code に以下のようなリクエストをすると自動的にスキルが発動します。

- 「Tuple を追加して」
- 「tupleOf を生成して」
- 「型安全な awaitAll が欲しい」
- 「複数の Deferred を型安全に await したい」
- 「nullable な値をまとめて non-null チェックしたい」

パッケージ名と出力先ディレクトリはプロジェクト構造から推測、または確認の上で生成されます。
