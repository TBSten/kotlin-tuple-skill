# TupleSerializer.kt Generation Rules

Requires `kotlinx-serialization` plugin and dependency.

Provides `KSerializer` implementations for Tuple types to support kotlinx.serialization.
Serializes each Tuple as a JSON array (e.g., `[1, "hello", true]`).

**Important**: Tuple2 (= Pair) and Tuple3 (= Triple) already have built-in serializers in kotlinx.serialization, so no custom serializer is needed for them.

For each Tuple that needs a serializer (Tuple0, Tuple1, Tuple4–TupleN):
1. Define a `TupleNSerializer` class implementing `KSerializer<TupleN<...>>`
2. Define a companion `serializer()` function on each Tuple to enable `@Serializable(with = ...)` or auto-detection

```kotlin
import kotlinx.serialization.*
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

// Tuple0
object Tuple0Serializer : KSerializer<Tuple0> {
    override val descriptor: SerialDescriptor =
        buildSerialDescriptor("Tuple0", StructureKind.LIST)

    override fun serialize(encoder: Encoder, value: Tuple0) {
        encoder.encodeStructure(descriptor) {}
    }

    override fun deserialize(decoder: Decoder): Tuple0 =
        decoder.decodeStructure(descriptor) { Tuple0 }
}

// Tuple1
class Tuple1Serializer<A0>(
    private val serializer0: KSerializer<A0>,
) : KSerializer<Tuple1<A0>> {
    override val descriptor: SerialDescriptor =
        buildSerialDescriptor("Tuple1", StructureKind.LIST) {
            element("first", serializer0.descriptor)
        }

    override fun serialize(encoder: Encoder, value: Tuple1<A0>) {
        encoder.encodeStructure(descriptor) {
            encodeSerializableElement(descriptor, 0, serializer0, value.first)
        }
    }

    override fun deserialize(decoder: Decoder): Tuple1<A0> =
        decoder.decodeStructure(descriptor) {
            var first: A0? = null
            while (true) {
                when (val index = decodeElementIndex(descriptor)) {
                    0 -> first = decodeSerializableElement(descriptor, 0, serializer0)
                    CompositeDecoder.DECODE_DONE -> break
                    else -> error("Unexpected index: $index")
                }
            }
            @Suppress("UNCHECKED_CAST")
            tupleOf(first as A0)
        }
}

// Tuple4 example
class Tuple4Serializer<A0, A1, A2, A3>(
    private val serializer0: KSerializer<A0>,
    private val serializer1: KSerializer<A1>,
    private val serializer2: KSerializer<A2>,
    private val serializer3: KSerializer<A3>,
) : KSerializer<Tuple4<A0, A1, A2, A3>> {
    override val descriptor: SerialDescriptor =
        buildSerialDescriptor("Tuple4", StructureKind.LIST) {
            element("first", serializer0.descriptor)
            element("second", serializer1.descriptor)
            element("third", serializer2.descriptor)
            element("fourth", serializer3.descriptor)
        }

    override fun serialize(encoder: Encoder, value: Tuple4<A0, A1, A2, A3>) {
        encoder.encodeStructure(descriptor) {
            encodeSerializableElement(descriptor, 0, serializer0, value.first)
            encodeSerializableElement(descriptor, 1, serializer1, value.second)
            encodeSerializableElement(descriptor, 2, serializer2, value.third)
            encodeSerializableElement(descriptor, 3, serializer3, value.fourth)
        }
    }

    override fun deserialize(decoder: Decoder): Tuple4<A0, A1, A2, A3> =
        decoder.decodeStructure(descriptor) {
            var first: A0? = null
            var second: A1? = null
            var third: A2? = null
            var fourth: A3? = null
            while (true) {
                when (val index = decodeElementIndex(descriptor)) {
                    0 -> first = decodeSerializableElement(descriptor, 0, serializer0)
                    1 -> second = decodeSerializableElement(descriptor, 1, serializer1)
                    2 -> third = decodeSerializableElement(descriptor, 2, serializer2)
                    3 -> fourth = decodeSerializableElement(descriptor, 3, serializer3)
                    CompositeDecoder.DECODE_DONE -> break
                    else -> error("Unexpected index: $index")
                }
            }
            @Suppress("UNCHECKED_CAST")
            tupleOf(first as A0, second as A1, third as A2, fourth as A3)
        }
}

// ... up to TupleN (skip Tuple2 and Tuple3)
```

**Pattern**: Each `TupleNSerializer` takes N `KSerializer` parameters (one per type parameter), uses `StructureKind.LIST` descriptor, and encodes/decodes elements by index using the ordinal property names.
