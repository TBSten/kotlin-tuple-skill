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

コード生成前に、以下の項目をユーザーに確認する。確認は **1 回のメッセージにまとめて** 行う。

### 確認項目

1. **生成先モジュール**（マルチモジュールの場合、どのモジュールに生成するか）
   - プロジェクト構造を解析して候補モジュールを推測し提示する
   - 推測したモジュールでよいか、別のモジュールに生成するか確認する
2. **パッケージ名と出力先ディレクトリ**
   - モジュール内のパッケージ構造から推測した候補を提示する
   - 推測したパッケージ名・ディレクトリでよいか、変更するか確認する
3. **Tuple の最大サイズ**（デフォルト: 20）
   - 「Tuple0〜Tuple20 (デフォルト) でよいですか？ 変更する場合は最大サイズの数値を入力してください」
4. **生成するファイルの種類**（デフォルト: すべて）
   - 以下から選択してもらう（複数選択可）:
     - [x] `Tuple.kt` + `TupleFactory.kt` — Tuple データクラスと tupleOf ファクトリ（必須・常に生成）
     - [x] `AwaitAll.kt` — 型安全な awaitAll（kotlinx-coroutines 依存）
     - [x] `AllNotNullOrNull.kt` — allNotNullOrNull ユーティリティ

### 確認メッセージの例

```
Tuple ユーティリティを生成します。以下を確認させてください:

1. 生成先モジュール: **shared** (推測)
   → 別のモジュールに生成する場合はモジュール名を入力してください

2. パッケージ名: `com.example.tuple` (推測)
   出力先: `shared/src/commonMain/kotlin/com/example/tuple/`
   → 変更する場合はパッケージ名を入力してください

3. Tuple の最大サイズ: **20** (デフォルト)
   → 変更する場合は数値を入力してください

4. 生成するファイル:
   - [x] Tuple.kt + TupleFactory.kt (必須)
   - [x] AwaitAll.kt (型安全な awaitAll)
   - [x] AllNotNullOrNull.kt (null 安全ユーティリティ)
   → 不要なものがあればチェックを外してください

このまま進めてよいですか？
```

### 確認後の手順

1. ユーザーの回答に応じて生成範囲を確定する
2. 選択されたファイルを生成する（Tuple の最大サイズはユーザー指定の値を使う）
3. AwaitAll.kt を生成する場合、build.gradle.kts に `kotlinx-coroutines` 依存があるか確認する

## 生成するファイル

最大サイズを N とする（デフォルト N=20）。

| ファイル | 内容 | 必須 |
|---|---|---|
| `Tuple.kt` | Tuple0〜TupleN のデータクラス定義 | 必須 |
| `TupleFactory.kt` | `tupleOf()` ファクトリ関数 (0〜N 引数) | 必須 |
| `AwaitAll.kt` | 型安全な `awaitAll()` (Deferred 1〜N 個) | 選択 |
| `AllNotNullOrNull.kt` | `allNotNullOrNull()` トップレベル関数 + 拡張関数 | 選択 |

## 設計ルール

### Tuple.kt

- `Tuple0` は `data object`（要素なし）
- `Tuple1<A0>` は `data class`（要素 1 つ）
- `Tuple2<A0, A1>` は `typealias Pair<A0, A1>`（Kotlin 標準の Pair を再利用）
- `Tuple3<A0, A1, A2>` は `typealias Triple<A0, A1, A2>`（Kotlin 標準の Triple を再利用）
- `Tuple4`〜`TupleN` は `data class`。プロパティは序数名で命名する
- 全ての Tuple に `toString()` をオーバーライド: `"($first, $second, ...)"` 形式
  - Tuple0 は `"()"`
  - Tuple2/Tuple3 は typealias なので toString 不要（Pair/Triple の標準実装を使う）

### プロパティ命名規則

序数名を使用する。Tuple2/Tuple3 は Pair/Triple の typealias なので、`first/second/third` と自然に一致する。

| 位置 | プロパティ名 | 位置 | プロパティ名 |
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

```kotlin
// 例: Tuple4
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

各 Tuple に対応する `tupleOf()` ファクトリ関数を定義する。

```kotlin
fun tupleOf(): Tuple0 = Tuple0
fun <A0> tupleOf(first: A0): Tuple1<A0> = Tuple1(first)
fun <A0, A1> tupleOf(first: A0, second: A1): Tuple2<A0, A1> = Tuple2(first, second)
fun <A0, A1, A2> tupleOf(first: A0, second: A1, third: A2): Tuple3<A0, A1, A2> = Tuple3(first, second, third)
fun <A0, A1, A2, A3> tupleOf(first: A0, second: A1, third: A2, fourth: A3): Tuple4<A0, A1, A2, A3> = Tuple4(first, second, third, fourth)
// ... TupleN まで
```

- `Tuple2(first, second)` は `Pair(first, second)` と等価（typealias のため）
- `Tuple3(first, second, third)` は `Triple(first, second, third)` と等価

### AwaitAll.kt

複数の `Deferred` を型安全に await して Tuple で返す。

```kotlin
import kotlinx.coroutines.Deferred

suspend fun <A0> awaitAll(
    first: Deferred<A0>,
) = tupleOf(first.await())

suspend fun <A0, A1> awaitAll(
    first: Deferred<A0>,
    second: Deferred<A1>,
) = tupleOf(first.await(), second.await())

// ... TupleN まで
```

### AllNotNullOrNull.kt

全引数が非 null なら Tuple を返し、1 つでも null なら null を返す。
各 Tuple サイズに対して 2 つの関数を定義する:

1. **トップレベル関数**: `allNotNullOrNull(first, second, ...) → TupleN?`
2. **拡張関数**: `TupleN<A0?, A1?, ...>.allNotNullOrNull() → TupleN<A0, A1, ...>?`

```kotlin
// Tuple1
fun <A0 : Any> allNotNullOrNull(first: A0?): Tuple1<A0>? =
    tupleOf(first).allNotNullOrNull()

fun <A0 : Any> Tuple1<A0?>.allNotNullOrNull(): Tuple1<A0>? =
    if (first != null) tupleOf(first) else null
```

**Tuple2/Tuple3 の注意点**: typealias (Pair/Triple) なのでプロパティは `first/second/third`。Tuple4 以降も同じ序数名を使うため、全 Tuple で統一的にアクセスできる。

```kotlin
// Tuple2 (= Pair)
fun <A0 : Any, A1 : Any> Tuple2<A0?, A1?>.allNotNullOrNull(): Tuple2<A0, A1>? {
    val first = first ?: return null
    val second = second ?: return null
    return tupleOf(first, second)
}

// Tuple3 (= Triple)
fun <A0 : Any, A1 : Any, A2 : Any> Tuple3<A0?, A1?, A2?>.allNotNullOrNull(): Tuple3<A0, A1, A2>? {
    val first = first ?: return null
    val second = second ?: return null
    val third = third ?: return null
    return tupleOf(first, second, third)
}
```

**Tuple4 以降**: data class のプロパティも序数名なのでスマートキャストが効く。

```kotlin
// Tuple4 の例
fun <A0 : Any, A1 : Any, A2 : Any, A3 : Any> Tuple4<A0?, A1?, A2?, A3?>.allNotNullOrNull(): Tuple4<A0, A1, A2, A3>? =
    if (first != null && second != null && third != null && fourth != null) tupleOf(first, second, third, fourth) else null
```

## コード生成のコツ

このスキルで生成するコードは非常に反復的（Tuple0〜TupleN の N+1 パターン）。
生成時は以下に注意する:

- 型パラメータの命名: `A0`, `A1`, ..., `A19`（0-indexed）
- プロパティの命名: `first`, `second`, `third`, `fourth`, ... `twentieth`（序数名、上記の命名規則テーブルを参照）
- 各 Tuple のジェネリクス数と要素数は一致する
- Tuple2 = Pair, Tuple3 = Triple の typealias を忘れない
- ファイル冒頭の `package` 宣言を忘れない
- AwaitAll.kt には `import kotlinx.coroutines.Deferred` が必要
