---
name: kotlin-tuple
description: >
  Kotlin (Multiplatform) プロジェクトで型安全な Tuple ユーティリティ (Tuple0〜Tuple20) を生成するスキル。
  Tuple データクラス、tupleOf ファクトリ、型安全な awaitAll、allNotNullOrNull を一括生成する。
  「Tuple を追加して」「tupleOf を生成して」「型安全な Tuple を作って」「awaitAll の型安全版」
  「allNotNullOrNull を追加して」「複数の Deferred を型安全に await したい」
  「nullable な値をまとめて non-null チェックしたい」などのリクエスト時に必ず使う。
  Kotlin/Kotlin Multiplatform プロジェクトで Pair/Triple では足りない多要素のグルーピングが
  必要な場面で使う。
---

# Kotlin Tuple ユーティリティ生成スキル

Kotlin (Multiplatform) プロジェクトに型安全な Tuple ユーティリティを生成する。
Tuple0〜Tuple20 のデータクラスと、関連するファクトリ関数・コルーチンユーティリティ・null 安全ユーティリティを 4 ファイルで構成する。

## 使い方

1. ユーザーにパッケージ名と出力先ディレクトリを確認する（プロジェクト構造から推測してもよい）
2. 4 ファイルを生成する
3. 必要に応じて既存の build.gradle.kts に `kotlinx-coroutines` 依存があるか確認する（AwaitAll.kt で必要）

## 生成するファイル

| ファイル | 内容 |
|---|---|
| `Tuple.kt` | Tuple0〜Tuple20 のデータクラス定義 |
| `TupleFactory.kt` | `tupleOf()` ファクトリ関数 (0〜20 引数) |
| `AwaitAll.kt` | 型安全な `awaitAll()` (Deferred 1〜20 個) |
| `AllNotNullOrNull.kt` | `allNotNullOrNull()` トップレベル関数 + 拡張関数 |

## 設計ルール

### Tuple.kt

- `Tuple0` は `data object`（要素なし）
- `Tuple1<A0>` は `data class`（要素 1 つ）
- `Tuple2<A0, A1>` は `typealias Pair<A0, A1>`（Kotlin 標準の Pair を再利用）
- `Tuple3<A0, A1, A2>` は `typealias Triple<A0, A1, A2>`（Kotlin 標準の Triple を再利用）
- `Tuple4`〜`Tuple20` は `data class`。プロパティは `a0`, `a1`, ..., `aN`
- 全ての Tuple に `toString()` をオーバーライド: `"($a0, $a1, ...)"` 形式
  - Tuple0 は `"()"`
  - Tuple2/Tuple3 は typealias なので toString 不要（Pair/Triple の標準実装を使う）

```kotlin
// 例: Tuple4
data class Tuple4<A0, A1, A2, A3>(
    val a0: A0,
    val a1: A1,
    val a2: A2,
    val a3: A3,
) {
    override fun toString(): String = "($a0, $a1, $a2, $a3)"
}
```

### TupleFactory.kt

各 Tuple に対応する `tupleOf()` ファクトリ関数を定義する。

```kotlin
fun tupleOf(): Tuple0 = Tuple0
fun <A0> tupleOf(a0: A0): Tuple1<A0> = Tuple1(a0)
fun <A0, A1> tupleOf(a0: A0, a1: A1): Tuple2<A0, A1> = Tuple2(a0, a1)
// ... Tuple20 まで
```

- `Tuple2(a0, a1)` は `Pair(a0, a1)` と等価（typealias のため）
- `Tuple3(a0, a1, a2)` は `Triple(a0, a1, a2)` と等価

### AwaitAll.kt

複数の `Deferred` を型安全に await して Tuple で返す。

```kotlin
import kotlinx.coroutines.Deferred

suspend fun <A0> awaitAll(
    deferred0: Deferred<A0>,
) = tupleOf(deferred0.await())

suspend fun <A0, A1> awaitAll(
    deferred0: Deferred<A0>,
    deferred1: Deferred<A1>,
) = tupleOf(deferred0.await(), deferred1.await())

// ... Tuple20 まで
```

### AllNotNullOrNull.kt

全引数が非 null なら Tuple を返し、1 つでも null なら null を返す。
各 Tuple サイズに対して 2 つの関数を定義する:

1. **トップレベル関数**: `allNotNullOrNull(a0, a1, ...) → TupleN?`
2. **拡張関数**: `TupleN<A0?, A1?, ...>.allNotNullOrNull() → TupleN<A0, A1, ...>?`

```kotlin
// Tuple1
fun <A0 : Any> allNotNullOrNull(a0: A0?): Tuple1<A0>? =
    tupleOf(a0).allNotNullOrNull()

fun <A0 : Any> Tuple1<A0?>.allNotNullOrNull(): Tuple1<A0>? =
    if (a0 != null) tupleOf(a0) else null
```

**Tuple2/Tuple3 の注意点**: typealias (Pair/Triple) なのでプロパティアクセスが異なる。

```kotlin
// Tuple2 (= Pair) — first/second でアクセス
fun <A0 : Any, A1 : Any> Tuple2<A0?, A1?>.allNotNullOrNull(): Tuple2<A0, A1>? {
    val a0 = first ?: return null
    val a1 = second ?: return null
    return tupleOf(a0, a1)
}

// Tuple3 (= Triple) — first/second/third でアクセス
fun <A0 : Any, A1 : Any, A2 : Any> Tuple3<A0?, A1?, A2?>.allNotNullOrNull(): Tuple3<A0, A1, A2>? {
    val a0 = first ?: return null
    val a1 = second ?: return null
    val a2 = third ?: return null
    return tupleOf(a0, a1, a2)
}
```

**Tuple4 以降**: `a0`, `a1`, ... で直接アクセス。スマートキャストが効く場合は `if` 式、効かない場合は `val` で受ける。

```kotlin
// Tuple4 以降の例
fun <A0 : Any, A1 : Any, A2 : Any, A3 : Any> Tuple4<A0?, A1?, A2?, A3?>.allNotNullOrNull(): Tuple4<A0, A1, A2, A3>? =
    if (a0 != null && a1 != null && a2 != null && a3 != null) tupleOf(a0, a1, a2, a3) else null
```

## コード生成のコツ

このスキルで生成するコードは非常に反復的（Tuple0〜Tuple20 の 21 パターン）。
生成時は以下に注意する:

- 型パラメータの命名: `A0`, `A1`, ..., `A19`（0-indexed）
- プロパティの命名: `a0`, `a1`, ..., `a19`（0-indexed）
- 各 Tuple のジェネリクス数と要素数は一致する
- Tuple2 = Pair, Tuple3 = Triple の typealias を忘れない
- ファイル冒頭の `package` 宣言を忘れない
- AwaitAll.kt には `import kotlinx.coroutines.Deferred` が必要
