package com.example.tuple

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.StructureKind
import kotlinx.serialization.descriptors.buildSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

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

// Tuple2 (= Pair) and Tuple3 (= Triple) have built-in serializers in kotlinx.serialization.

// Tuple4

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

// Tuple5

class Tuple5Serializer<A0, A1, A2, A3, A4>(
    private val serializer0: KSerializer<A0>,
    private val serializer1: KSerializer<A1>,
    private val serializer2: KSerializer<A2>,
    private val serializer3: KSerializer<A3>,
    private val serializer4: KSerializer<A4>,
) : KSerializer<Tuple5<A0, A1, A2, A3, A4>> {
    override val descriptor: SerialDescriptor =
        buildSerialDescriptor("Tuple5", StructureKind.LIST) {
            element("first", serializer0.descriptor)
            element("second", serializer1.descriptor)
            element("third", serializer2.descriptor)
            element("fourth", serializer3.descriptor)
            element("fifth", serializer4.descriptor)
        }

    override fun serialize(encoder: Encoder, value: Tuple5<A0, A1, A2, A3, A4>) {
        encoder.encodeStructure(descriptor) {
            encodeSerializableElement(descriptor, 0, serializer0, value.first)
            encodeSerializableElement(descriptor, 1, serializer1, value.second)
            encodeSerializableElement(descriptor, 2, serializer2, value.third)
            encodeSerializableElement(descriptor, 3, serializer3, value.fourth)
            encodeSerializableElement(descriptor, 4, serializer4, value.fifth)
        }
    }

    override fun deserialize(decoder: Decoder): Tuple5<A0, A1, A2, A3, A4> =
        decoder.decodeStructure(descriptor) {
            var first: A0? = null
            var second: A1? = null
            var third: A2? = null
            var fourth: A3? = null
            var fifth: A4? = null
            while (true) {
                when (val index = decodeElementIndex(descriptor)) {
                    0 -> first = decodeSerializableElement(descriptor, 0, serializer0)
                    1 -> second = decodeSerializableElement(descriptor, 1, serializer1)
                    2 -> third = decodeSerializableElement(descriptor, 2, serializer2)
                    3 -> fourth = decodeSerializableElement(descriptor, 3, serializer3)
                    4 -> fifth = decodeSerializableElement(descriptor, 4, serializer4)
                    CompositeDecoder.DECODE_DONE -> break
                    else -> error("Unexpected index: $index")
                }
            }
            @Suppress("UNCHECKED_CAST")
            tupleOf(first as A0, second as A1, third as A2, fourth as A3, fifth as A4)
        }
}

// Tuple6

class Tuple6Serializer<A0, A1, A2, A3, A4, A5>(
    private val serializer0: KSerializer<A0>,
    private val serializer1: KSerializer<A1>,
    private val serializer2: KSerializer<A2>,
    private val serializer3: KSerializer<A3>,
    private val serializer4: KSerializer<A4>,
    private val serializer5: KSerializer<A5>,
) : KSerializer<Tuple6<A0, A1, A2, A3, A4, A5>> {
    override val descriptor: SerialDescriptor =
        buildSerialDescriptor("Tuple6", StructureKind.LIST) {
            element("first", serializer0.descriptor)
            element("second", serializer1.descriptor)
            element("third", serializer2.descriptor)
            element("fourth", serializer3.descriptor)
            element("fifth", serializer4.descriptor)
            element("sixth", serializer5.descriptor)
        }

    override fun serialize(encoder: Encoder, value: Tuple6<A0, A1, A2, A3, A4, A5>) {
        encoder.encodeStructure(descriptor) {
            encodeSerializableElement(descriptor, 0, serializer0, value.first)
            encodeSerializableElement(descriptor, 1, serializer1, value.second)
            encodeSerializableElement(descriptor, 2, serializer2, value.third)
            encodeSerializableElement(descriptor, 3, serializer3, value.fourth)
            encodeSerializableElement(descriptor, 4, serializer4, value.fifth)
            encodeSerializableElement(descriptor, 5, serializer5, value.sixth)
        }
    }

    override fun deserialize(decoder: Decoder): Tuple6<A0, A1, A2, A3, A4, A5> =
        decoder.decodeStructure(descriptor) {
            var first: A0? = null
            var second: A1? = null
            var third: A2? = null
            var fourth: A3? = null
            var fifth: A4? = null
            var sixth: A5? = null
            while (true) {
                when (val index = decodeElementIndex(descriptor)) {
                    0 -> first = decodeSerializableElement(descriptor, 0, serializer0)
                    1 -> second = decodeSerializableElement(descriptor, 1, serializer1)
                    2 -> third = decodeSerializableElement(descriptor, 2, serializer2)
                    3 -> fourth = decodeSerializableElement(descriptor, 3, serializer3)
                    4 -> fifth = decodeSerializableElement(descriptor, 4, serializer4)
                    5 -> sixth = decodeSerializableElement(descriptor, 5, serializer5)
                    CompositeDecoder.DECODE_DONE -> break
                    else -> error("Unexpected index: $index")
                }
            }
            @Suppress("UNCHECKED_CAST")
            tupleOf(first as A0, second as A1, third as A2, fourth as A3, fifth as A4, sixth as A5)
        }
}

// Tuple7

class Tuple7Serializer<A0, A1, A2, A3, A4, A5, A6>(
    private val serializer0: KSerializer<A0>,
    private val serializer1: KSerializer<A1>,
    private val serializer2: KSerializer<A2>,
    private val serializer3: KSerializer<A3>,
    private val serializer4: KSerializer<A4>,
    private val serializer5: KSerializer<A5>,
    private val serializer6: KSerializer<A6>,
) : KSerializer<Tuple7<A0, A1, A2, A3, A4, A5, A6>> {
    override val descriptor: SerialDescriptor =
        buildSerialDescriptor("Tuple7", StructureKind.LIST) {
            element("first", serializer0.descriptor)
            element("second", serializer1.descriptor)
            element("third", serializer2.descriptor)
            element("fourth", serializer3.descriptor)
            element("fifth", serializer4.descriptor)
            element("sixth", serializer5.descriptor)
            element("seventh", serializer6.descriptor)
        }

    override fun serialize(encoder: Encoder, value: Tuple7<A0, A1, A2, A3, A4, A5, A6>) {
        encoder.encodeStructure(descriptor) {
            encodeSerializableElement(descriptor, 0, serializer0, value.first)
            encodeSerializableElement(descriptor, 1, serializer1, value.second)
            encodeSerializableElement(descriptor, 2, serializer2, value.third)
            encodeSerializableElement(descriptor, 3, serializer3, value.fourth)
            encodeSerializableElement(descriptor, 4, serializer4, value.fifth)
            encodeSerializableElement(descriptor, 5, serializer5, value.sixth)
            encodeSerializableElement(descriptor, 6, serializer6, value.seventh)
        }
    }

    override fun deserialize(decoder: Decoder): Tuple7<A0, A1, A2, A3, A4, A5, A6> =
        decoder.decodeStructure(descriptor) {
            var first: A0? = null
            var second: A1? = null
            var third: A2? = null
            var fourth: A3? = null
            var fifth: A4? = null
            var sixth: A5? = null
            var seventh: A6? = null
            while (true) {
                when (val index = decodeElementIndex(descriptor)) {
                    0 -> first = decodeSerializableElement(descriptor, 0, serializer0)
                    1 -> second = decodeSerializableElement(descriptor, 1, serializer1)
                    2 -> third = decodeSerializableElement(descriptor, 2, serializer2)
                    3 -> fourth = decodeSerializableElement(descriptor, 3, serializer3)
                    4 -> fifth = decodeSerializableElement(descriptor, 4, serializer4)
                    5 -> sixth = decodeSerializableElement(descriptor, 5, serializer5)
                    6 -> seventh = decodeSerializableElement(descriptor, 6, serializer6)
                    CompositeDecoder.DECODE_DONE -> break
                    else -> error("Unexpected index: $index")
                }
            }
            @Suppress("UNCHECKED_CAST")
            tupleOf(first as A0, second as A1, third as A2, fourth as A3, fifth as A4, sixth as A5, seventh as A6)
        }
}

// Tuple8

class Tuple8Serializer<A0, A1, A2, A3, A4, A5, A6, A7>(
    private val serializer0: KSerializer<A0>,
    private val serializer1: KSerializer<A1>,
    private val serializer2: KSerializer<A2>,
    private val serializer3: KSerializer<A3>,
    private val serializer4: KSerializer<A4>,
    private val serializer5: KSerializer<A5>,
    private val serializer6: KSerializer<A6>,
    private val serializer7: KSerializer<A7>,
) : KSerializer<Tuple8<A0, A1, A2, A3, A4, A5, A6, A7>> {
    override val descriptor: SerialDescriptor =
        buildSerialDescriptor("Tuple8", StructureKind.LIST) {
            element("first", serializer0.descriptor)
            element("second", serializer1.descriptor)
            element("third", serializer2.descriptor)
            element("fourth", serializer3.descriptor)
            element("fifth", serializer4.descriptor)
            element("sixth", serializer5.descriptor)
            element("seventh", serializer6.descriptor)
            element("eighth", serializer7.descriptor)
        }

    override fun serialize(encoder: Encoder, value: Tuple8<A0, A1, A2, A3, A4, A5, A6, A7>) {
        encoder.encodeStructure(descriptor) {
            encodeSerializableElement(descriptor, 0, serializer0, value.first)
            encodeSerializableElement(descriptor, 1, serializer1, value.second)
            encodeSerializableElement(descriptor, 2, serializer2, value.third)
            encodeSerializableElement(descriptor, 3, serializer3, value.fourth)
            encodeSerializableElement(descriptor, 4, serializer4, value.fifth)
            encodeSerializableElement(descriptor, 5, serializer5, value.sixth)
            encodeSerializableElement(descriptor, 6, serializer6, value.seventh)
            encodeSerializableElement(descriptor, 7, serializer7, value.eighth)
        }
    }

    override fun deserialize(decoder: Decoder): Tuple8<A0, A1, A2, A3, A4, A5, A6, A7> =
        decoder.decodeStructure(descriptor) {
            var first: A0? = null
            var second: A1? = null
            var third: A2? = null
            var fourth: A3? = null
            var fifth: A4? = null
            var sixth: A5? = null
            var seventh: A6? = null
            var eighth: A7? = null
            while (true) {
                when (val index = decodeElementIndex(descriptor)) {
                    0 -> first = decodeSerializableElement(descriptor, 0, serializer0)
                    1 -> second = decodeSerializableElement(descriptor, 1, serializer1)
                    2 -> third = decodeSerializableElement(descriptor, 2, serializer2)
                    3 -> fourth = decodeSerializableElement(descriptor, 3, serializer3)
                    4 -> fifth = decodeSerializableElement(descriptor, 4, serializer4)
                    5 -> sixth = decodeSerializableElement(descriptor, 5, serializer5)
                    6 -> seventh = decodeSerializableElement(descriptor, 6, serializer6)
                    7 -> eighth = decodeSerializableElement(descriptor, 7, serializer7)
                    CompositeDecoder.DECODE_DONE -> break
                    else -> error("Unexpected index: $index")
                }
            }
            @Suppress("UNCHECKED_CAST")
            tupleOf(first as A0, second as A1, third as A2, fourth as A3, fifth as A4, sixth as A5, seventh as A6, eighth as A7)
        }
}

// Tuple9

class Tuple9Serializer<A0, A1, A2, A3, A4, A5, A6, A7, A8>(
    private val serializer0: KSerializer<A0>,
    private val serializer1: KSerializer<A1>,
    private val serializer2: KSerializer<A2>,
    private val serializer3: KSerializer<A3>,
    private val serializer4: KSerializer<A4>,
    private val serializer5: KSerializer<A5>,
    private val serializer6: KSerializer<A6>,
    private val serializer7: KSerializer<A7>,
    private val serializer8: KSerializer<A8>,
) : KSerializer<Tuple9<A0, A1, A2, A3, A4, A5, A6, A7, A8>> {
    override val descriptor: SerialDescriptor =
        buildSerialDescriptor("Tuple9", StructureKind.LIST) {
            element("first", serializer0.descriptor)
            element("second", serializer1.descriptor)
            element("third", serializer2.descriptor)
            element("fourth", serializer3.descriptor)
            element("fifth", serializer4.descriptor)
            element("sixth", serializer5.descriptor)
            element("seventh", serializer6.descriptor)
            element("eighth", serializer7.descriptor)
            element("ninth", serializer8.descriptor)
        }

    override fun serialize(encoder: Encoder, value: Tuple9<A0, A1, A2, A3, A4, A5, A6, A7, A8>) {
        encoder.encodeStructure(descriptor) {
            encodeSerializableElement(descriptor, 0, serializer0, value.first)
            encodeSerializableElement(descriptor, 1, serializer1, value.second)
            encodeSerializableElement(descriptor, 2, serializer2, value.third)
            encodeSerializableElement(descriptor, 3, serializer3, value.fourth)
            encodeSerializableElement(descriptor, 4, serializer4, value.fifth)
            encodeSerializableElement(descriptor, 5, serializer5, value.sixth)
            encodeSerializableElement(descriptor, 6, serializer6, value.seventh)
            encodeSerializableElement(descriptor, 7, serializer7, value.eighth)
            encodeSerializableElement(descriptor, 8, serializer8, value.ninth)
        }
    }

    override fun deserialize(decoder: Decoder): Tuple9<A0, A1, A2, A3, A4, A5, A6, A7, A8> =
        decoder.decodeStructure(descriptor) {
            var first: A0? = null
            var second: A1? = null
            var third: A2? = null
            var fourth: A3? = null
            var fifth: A4? = null
            var sixth: A5? = null
            var seventh: A6? = null
            var eighth: A7? = null
            var ninth: A8? = null
            while (true) {
                when (val index = decodeElementIndex(descriptor)) {
                    0 -> first = decodeSerializableElement(descriptor, 0, serializer0)
                    1 -> second = decodeSerializableElement(descriptor, 1, serializer1)
                    2 -> third = decodeSerializableElement(descriptor, 2, serializer2)
                    3 -> fourth = decodeSerializableElement(descriptor, 3, serializer3)
                    4 -> fifth = decodeSerializableElement(descriptor, 4, serializer4)
                    5 -> sixth = decodeSerializableElement(descriptor, 5, serializer5)
                    6 -> seventh = decodeSerializableElement(descriptor, 6, serializer6)
                    7 -> eighth = decodeSerializableElement(descriptor, 7, serializer7)
                    8 -> ninth = decodeSerializableElement(descriptor, 8, serializer8)
                    CompositeDecoder.DECODE_DONE -> break
                    else -> error("Unexpected index: $index")
                }
            }
            @Suppress("UNCHECKED_CAST")
            tupleOf(first as A0, second as A1, third as A2, fourth as A3, fifth as A4, sixth as A5, seventh as A6, eighth as A7, ninth as A8)
        }
}

// Tuple10

class Tuple10Serializer<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9>(
    private val serializer0: KSerializer<A0>,
    private val serializer1: KSerializer<A1>,
    private val serializer2: KSerializer<A2>,
    private val serializer3: KSerializer<A3>,
    private val serializer4: KSerializer<A4>,
    private val serializer5: KSerializer<A5>,
    private val serializer6: KSerializer<A6>,
    private val serializer7: KSerializer<A7>,
    private val serializer8: KSerializer<A8>,
    private val serializer9: KSerializer<A9>,
) : KSerializer<Tuple10<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9>> {
    override val descriptor: SerialDescriptor =
        buildSerialDescriptor("Tuple10", StructureKind.LIST) {
            element("first", serializer0.descriptor)
            element("second", serializer1.descriptor)
            element("third", serializer2.descriptor)
            element("fourth", serializer3.descriptor)
            element("fifth", serializer4.descriptor)
            element("sixth", serializer5.descriptor)
            element("seventh", serializer6.descriptor)
            element("eighth", serializer7.descriptor)
            element("ninth", serializer8.descriptor)
            element("tenth", serializer9.descriptor)
        }

    override fun serialize(encoder: Encoder, value: Tuple10<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9>) {
        encoder.encodeStructure(descriptor) {
            encodeSerializableElement(descriptor, 0, serializer0, value.first)
            encodeSerializableElement(descriptor, 1, serializer1, value.second)
            encodeSerializableElement(descriptor, 2, serializer2, value.third)
            encodeSerializableElement(descriptor, 3, serializer3, value.fourth)
            encodeSerializableElement(descriptor, 4, serializer4, value.fifth)
            encodeSerializableElement(descriptor, 5, serializer5, value.sixth)
            encodeSerializableElement(descriptor, 6, serializer6, value.seventh)
            encodeSerializableElement(descriptor, 7, serializer7, value.eighth)
            encodeSerializableElement(descriptor, 8, serializer8, value.ninth)
            encodeSerializableElement(descriptor, 9, serializer9, value.tenth)
        }
    }

    override fun deserialize(decoder: Decoder): Tuple10<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9> =
        decoder.decodeStructure(descriptor) {
            var first: A0? = null
            var second: A1? = null
            var third: A2? = null
            var fourth: A3? = null
            var fifth: A4? = null
            var sixth: A5? = null
            var seventh: A6? = null
            var eighth: A7? = null
            var ninth: A8? = null
            var tenth: A9? = null
            while (true) {
                when (val index = decodeElementIndex(descriptor)) {
                    0 -> first = decodeSerializableElement(descriptor, 0, serializer0)
                    1 -> second = decodeSerializableElement(descriptor, 1, serializer1)
                    2 -> third = decodeSerializableElement(descriptor, 2, serializer2)
                    3 -> fourth = decodeSerializableElement(descriptor, 3, serializer3)
                    4 -> fifth = decodeSerializableElement(descriptor, 4, serializer4)
                    5 -> sixth = decodeSerializableElement(descriptor, 5, serializer5)
                    6 -> seventh = decodeSerializableElement(descriptor, 6, serializer6)
                    7 -> eighth = decodeSerializableElement(descriptor, 7, serializer7)
                    8 -> ninth = decodeSerializableElement(descriptor, 8, serializer8)
                    9 -> tenth = decodeSerializableElement(descriptor, 9, serializer9)
                    CompositeDecoder.DECODE_DONE -> break
                    else -> error("Unexpected index: $index")
                }
            }
            @Suppress("UNCHECKED_CAST")
            tupleOf(first as A0, second as A1, third as A2, fourth as A3, fifth as A4, sixth as A5, seventh as A6, eighth as A7, ninth as A8, tenth as A9)
        }
}

// Tuple11

class Tuple11Serializer<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10>(
    private val serializer0: KSerializer<A0>,
    private val serializer1: KSerializer<A1>,
    private val serializer2: KSerializer<A2>,
    private val serializer3: KSerializer<A3>,
    private val serializer4: KSerializer<A4>,
    private val serializer5: KSerializer<A5>,
    private val serializer6: KSerializer<A6>,
    private val serializer7: KSerializer<A7>,
    private val serializer8: KSerializer<A8>,
    private val serializer9: KSerializer<A9>,
    private val serializer10: KSerializer<A10>,
) : KSerializer<Tuple11<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10>> {
    override val descriptor: SerialDescriptor =
        buildSerialDescriptor("Tuple11", StructureKind.LIST) {
            element("first", serializer0.descriptor)
            element("second", serializer1.descriptor)
            element("third", serializer2.descriptor)
            element("fourth", serializer3.descriptor)
            element("fifth", serializer4.descriptor)
            element("sixth", serializer5.descriptor)
            element("seventh", serializer6.descriptor)
            element("eighth", serializer7.descriptor)
            element("ninth", serializer8.descriptor)
            element("tenth", serializer9.descriptor)
            element("eleventh", serializer10.descriptor)
        }

    override fun serialize(encoder: Encoder, value: Tuple11<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10>) {
        encoder.encodeStructure(descriptor) {
            encodeSerializableElement(descriptor, 0, serializer0, value.first)
            encodeSerializableElement(descriptor, 1, serializer1, value.second)
            encodeSerializableElement(descriptor, 2, serializer2, value.third)
            encodeSerializableElement(descriptor, 3, serializer3, value.fourth)
            encodeSerializableElement(descriptor, 4, serializer4, value.fifth)
            encodeSerializableElement(descriptor, 5, serializer5, value.sixth)
            encodeSerializableElement(descriptor, 6, serializer6, value.seventh)
            encodeSerializableElement(descriptor, 7, serializer7, value.eighth)
            encodeSerializableElement(descriptor, 8, serializer8, value.ninth)
            encodeSerializableElement(descriptor, 9, serializer9, value.tenth)
            encodeSerializableElement(descriptor, 10, serializer10, value.eleventh)
        }
    }

    override fun deserialize(decoder: Decoder): Tuple11<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10> =
        decoder.decodeStructure(descriptor) {
            var first: A0? = null
            var second: A1? = null
            var third: A2? = null
            var fourth: A3? = null
            var fifth: A4? = null
            var sixth: A5? = null
            var seventh: A6? = null
            var eighth: A7? = null
            var ninth: A8? = null
            var tenth: A9? = null
            var eleventh: A10? = null
            while (true) {
                when (val index = decodeElementIndex(descriptor)) {
                    0 -> first = decodeSerializableElement(descriptor, 0, serializer0)
                    1 -> second = decodeSerializableElement(descriptor, 1, serializer1)
                    2 -> third = decodeSerializableElement(descriptor, 2, serializer2)
                    3 -> fourth = decodeSerializableElement(descriptor, 3, serializer3)
                    4 -> fifth = decodeSerializableElement(descriptor, 4, serializer4)
                    5 -> sixth = decodeSerializableElement(descriptor, 5, serializer5)
                    6 -> seventh = decodeSerializableElement(descriptor, 6, serializer6)
                    7 -> eighth = decodeSerializableElement(descriptor, 7, serializer7)
                    8 -> ninth = decodeSerializableElement(descriptor, 8, serializer8)
                    9 -> tenth = decodeSerializableElement(descriptor, 9, serializer9)
                    10 -> eleventh = decodeSerializableElement(descriptor, 10, serializer10)
                    CompositeDecoder.DECODE_DONE -> break
                    else -> error("Unexpected index: $index")
                }
            }
            @Suppress("UNCHECKED_CAST")
            tupleOf(first as A0, second as A1, third as A2, fourth as A3, fifth as A4, sixth as A5, seventh as A6, eighth as A7, ninth as A8, tenth as A9, eleventh as A10)
        }
}

// Tuple12

class Tuple12Serializer<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11>(
    private val serializer0: KSerializer<A0>,
    private val serializer1: KSerializer<A1>,
    private val serializer2: KSerializer<A2>,
    private val serializer3: KSerializer<A3>,
    private val serializer4: KSerializer<A4>,
    private val serializer5: KSerializer<A5>,
    private val serializer6: KSerializer<A6>,
    private val serializer7: KSerializer<A7>,
    private val serializer8: KSerializer<A8>,
    private val serializer9: KSerializer<A9>,
    private val serializer10: KSerializer<A10>,
    private val serializer11: KSerializer<A11>,
) : KSerializer<Tuple12<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11>> {
    override val descriptor: SerialDescriptor =
        buildSerialDescriptor("Tuple12", StructureKind.LIST) {
            element("first", serializer0.descriptor)
            element("second", serializer1.descriptor)
            element("third", serializer2.descriptor)
            element("fourth", serializer3.descriptor)
            element("fifth", serializer4.descriptor)
            element("sixth", serializer5.descriptor)
            element("seventh", serializer6.descriptor)
            element("eighth", serializer7.descriptor)
            element("ninth", serializer8.descriptor)
            element("tenth", serializer9.descriptor)
            element("eleventh", serializer10.descriptor)
            element("twelfth", serializer11.descriptor)
        }

    override fun serialize(encoder: Encoder, value: Tuple12<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11>) {
        encoder.encodeStructure(descriptor) {
            encodeSerializableElement(descriptor, 0, serializer0, value.first)
            encodeSerializableElement(descriptor, 1, serializer1, value.second)
            encodeSerializableElement(descriptor, 2, serializer2, value.third)
            encodeSerializableElement(descriptor, 3, serializer3, value.fourth)
            encodeSerializableElement(descriptor, 4, serializer4, value.fifth)
            encodeSerializableElement(descriptor, 5, serializer5, value.sixth)
            encodeSerializableElement(descriptor, 6, serializer6, value.seventh)
            encodeSerializableElement(descriptor, 7, serializer7, value.eighth)
            encodeSerializableElement(descriptor, 8, serializer8, value.ninth)
            encodeSerializableElement(descriptor, 9, serializer9, value.tenth)
            encodeSerializableElement(descriptor, 10, serializer10, value.eleventh)
            encodeSerializableElement(descriptor, 11, serializer11, value.twelfth)
        }
    }

    override fun deserialize(decoder: Decoder): Tuple12<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11> =
        decoder.decodeStructure(descriptor) {
            var first: A0? = null
            var second: A1? = null
            var third: A2? = null
            var fourth: A3? = null
            var fifth: A4? = null
            var sixth: A5? = null
            var seventh: A6? = null
            var eighth: A7? = null
            var ninth: A8? = null
            var tenth: A9? = null
            var eleventh: A10? = null
            var twelfth: A11? = null
            while (true) {
                when (val index = decodeElementIndex(descriptor)) {
                    0 -> first = decodeSerializableElement(descriptor, 0, serializer0)
                    1 -> second = decodeSerializableElement(descriptor, 1, serializer1)
                    2 -> third = decodeSerializableElement(descriptor, 2, serializer2)
                    3 -> fourth = decodeSerializableElement(descriptor, 3, serializer3)
                    4 -> fifth = decodeSerializableElement(descriptor, 4, serializer4)
                    5 -> sixth = decodeSerializableElement(descriptor, 5, serializer5)
                    6 -> seventh = decodeSerializableElement(descriptor, 6, serializer6)
                    7 -> eighth = decodeSerializableElement(descriptor, 7, serializer7)
                    8 -> ninth = decodeSerializableElement(descriptor, 8, serializer8)
                    9 -> tenth = decodeSerializableElement(descriptor, 9, serializer9)
                    10 -> eleventh = decodeSerializableElement(descriptor, 10, serializer10)
                    11 -> twelfth = decodeSerializableElement(descriptor, 11, serializer11)
                    CompositeDecoder.DECODE_DONE -> break
                    else -> error("Unexpected index: $index")
                }
            }
            @Suppress("UNCHECKED_CAST")
            tupleOf(first as A0, second as A1, third as A2, fourth as A3, fifth as A4, sixth as A5, seventh as A6, eighth as A7, ninth as A8, tenth as A9, eleventh as A10, twelfth as A11)
        }
}

// Tuple13

class Tuple13Serializer<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12>(
    private val serializer0: KSerializer<A0>,
    private val serializer1: KSerializer<A1>,
    private val serializer2: KSerializer<A2>,
    private val serializer3: KSerializer<A3>,
    private val serializer4: KSerializer<A4>,
    private val serializer5: KSerializer<A5>,
    private val serializer6: KSerializer<A6>,
    private val serializer7: KSerializer<A7>,
    private val serializer8: KSerializer<A8>,
    private val serializer9: KSerializer<A9>,
    private val serializer10: KSerializer<A10>,
    private val serializer11: KSerializer<A11>,
    private val serializer12: KSerializer<A12>,
) : KSerializer<Tuple13<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12>> {
    override val descriptor: SerialDescriptor =
        buildSerialDescriptor("Tuple13", StructureKind.LIST) {
            element("first", serializer0.descriptor)
            element("second", serializer1.descriptor)
            element("third", serializer2.descriptor)
            element("fourth", serializer3.descriptor)
            element("fifth", serializer4.descriptor)
            element("sixth", serializer5.descriptor)
            element("seventh", serializer6.descriptor)
            element("eighth", serializer7.descriptor)
            element("ninth", serializer8.descriptor)
            element("tenth", serializer9.descriptor)
            element("eleventh", serializer10.descriptor)
            element("twelfth", serializer11.descriptor)
            element("thirteenth", serializer12.descriptor)
        }

    override fun serialize(encoder: Encoder, value: Tuple13<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12>) {
        encoder.encodeStructure(descriptor) {
            encodeSerializableElement(descriptor, 0, serializer0, value.first)
            encodeSerializableElement(descriptor, 1, serializer1, value.second)
            encodeSerializableElement(descriptor, 2, serializer2, value.third)
            encodeSerializableElement(descriptor, 3, serializer3, value.fourth)
            encodeSerializableElement(descriptor, 4, serializer4, value.fifth)
            encodeSerializableElement(descriptor, 5, serializer5, value.sixth)
            encodeSerializableElement(descriptor, 6, serializer6, value.seventh)
            encodeSerializableElement(descriptor, 7, serializer7, value.eighth)
            encodeSerializableElement(descriptor, 8, serializer8, value.ninth)
            encodeSerializableElement(descriptor, 9, serializer9, value.tenth)
            encodeSerializableElement(descriptor, 10, serializer10, value.eleventh)
            encodeSerializableElement(descriptor, 11, serializer11, value.twelfth)
            encodeSerializableElement(descriptor, 12, serializer12, value.thirteenth)
        }
    }

    override fun deserialize(decoder: Decoder): Tuple13<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12> =
        decoder.decodeStructure(descriptor) {
            var first: A0? = null
            var second: A1? = null
            var third: A2? = null
            var fourth: A3? = null
            var fifth: A4? = null
            var sixth: A5? = null
            var seventh: A6? = null
            var eighth: A7? = null
            var ninth: A8? = null
            var tenth: A9? = null
            var eleventh: A10? = null
            var twelfth: A11? = null
            var thirteenth: A12? = null
            while (true) {
                when (val index = decodeElementIndex(descriptor)) {
                    0 -> first = decodeSerializableElement(descriptor, 0, serializer0)
                    1 -> second = decodeSerializableElement(descriptor, 1, serializer1)
                    2 -> third = decodeSerializableElement(descriptor, 2, serializer2)
                    3 -> fourth = decodeSerializableElement(descriptor, 3, serializer3)
                    4 -> fifth = decodeSerializableElement(descriptor, 4, serializer4)
                    5 -> sixth = decodeSerializableElement(descriptor, 5, serializer5)
                    6 -> seventh = decodeSerializableElement(descriptor, 6, serializer6)
                    7 -> eighth = decodeSerializableElement(descriptor, 7, serializer7)
                    8 -> ninth = decodeSerializableElement(descriptor, 8, serializer8)
                    9 -> tenth = decodeSerializableElement(descriptor, 9, serializer9)
                    10 -> eleventh = decodeSerializableElement(descriptor, 10, serializer10)
                    11 -> twelfth = decodeSerializableElement(descriptor, 11, serializer11)
                    12 -> thirteenth = decodeSerializableElement(descriptor, 12, serializer12)
                    CompositeDecoder.DECODE_DONE -> break
                    else -> error("Unexpected index: $index")
                }
            }
            @Suppress("UNCHECKED_CAST")
            tupleOf(first as A0, second as A1, third as A2, fourth as A3, fifth as A4, sixth as A5, seventh as A6, eighth as A7, ninth as A8, tenth as A9, eleventh as A10, twelfth as A11, thirteenth as A12)
        }
}

// Tuple14

class Tuple14Serializer<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13>(
    private val serializer0: KSerializer<A0>,
    private val serializer1: KSerializer<A1>,
    private val serializer2: KSerializer<A2>,
    private val serializer3: KSerializer<A3>,
    private val serializer4: KSerializer<A4>,
    private val serializer5: KSerializer<A5>,
    private val serializer6: KSerializer<A6>,
    private val serializer7: KSerializer<A7>,
    private val serializer8: KSerializer<A8>,
    private val serializer9: KSerializer<A9>,
    private val serializer10: KSerializer<A10>,
    private val serializer11: KSerializer<A11>,
    private val serializer12: KSerializer<A12>,
    private val serializer13: KSerializer<A13>,
) : KSerializer<Tuple14<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13>> {
    override val descriptor: SerialDescriptor =
        buildSerialDescriptor("Tuple14", StructureKind.LIST) {
            element("first", serializer0.descriptor)
            element("second", serializer1.descriptor)
            element("third", serializer2.descriptor)
            element("fourth", serializer3.descriptor)
            element("fifth", serializer4.descriptor)
            element("sixth", serializer5.descriptor)
            element("seventh", serializer6.descriptor)
            element("eighth", serializer7.descriptor)
            element("ninth", serializer8.descriptor)
            element("tenth", serializer9.descriptor)
            element("eleventh", serializer10.descriptor)
            element("twelfth", serializer11.descriptor)
            element("thirteenth", serializer12.descriptor)
            element("fourteenth", serializer13.descriptor)
        }

    override fun serialize(encoder: Encoder, value: Tuple14<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13>) {
        encoder.encodeStructure(descriptor) {
            encodeSerializableElement(descriptor, 0, serializer0, value.first)
            encodeSerializableElement(descriptor, 1, serializer1, value.second)
            encodeSerializableElement(descriptor, 2, serializer2, value.third)
            encodeSerializableElement(descriptor, 3, serializer3, value.fourth)
            encodeSerializableElement(descriptor, 4, serializer4, value.fifth)
            encodeSerializableElement(descriptor, 5, serializer5, value.sixth)
            encodeSerializableElement(descriptor, 6, serializer6, value.seventh)
            encodeSerializableElement(descriptor, 7, serializer7, value.eighth)
            encodeSerializableElement(descriptor, 8, serializer8, value.ninth)
            encodeSerializableElement(descriptor, 9, serializer9, value.tenth)
            encodeSerializableElement(descriptor, 10, serializer10, value.eleventh)
            encodeSerializableElement(descriptor, 11, serializer11, value.twelfth)
            encodeSerializableElement(descriptor, 12, serializer12, value.thirteenth)
            encodeSerializableElement(descriptor, 13, serializer13, value.fourteenth)
        }
    }

    override fun deserialize(decoder: Decoder): Tuple14<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13> =
        decoder.decodeStructure(descriptor) {
            var first: A0? = null
            var second: A1? = null
            var third: A2? = null
            var fourth: A3? = null
            var fifth: A4? = null
            var sixth: A5? = null
            var seventh: A6? = null
            var eighth: A7? = null
            var ninth: A8? = null
            var tenth: A9? = null
            var eleventh: A10? = null
            var twelfth: A11? = null
            var thirteenth: A12? = null
            var fourteenth: A13? = null
            while (true) {
                when (val index = decodeElementIndex(descriptor)) {
                    0 -> first = decodeSerializableElement(descriptor, 0, serializer0)
                    1 -> second = decodeSerializableElement(descriptor, 1, serializer1)
                    2 -> third = decodeSerializableElement(descriptor, 2, serializer2)
                    3 -> fourth = decodeSerializableElement(descriptor, 3, serializer3)
                    4 -> fifth = decodeSerializableElement(descriptor, 4, serializer4)
                    5 -> sixth = decodeSerializableElement(descriptor, 5, serializer5)
                    6 -> seventh = decodeSerializableElement(descriptor, 6, serializer6)
                    7 -> eighth = decodeSerializableElement(descriptor, 7, serializer7)
                    8 -> ninth = decodeSerializableElement(descriptor, 8, serializer8)
                    9 -> tenth = decodeSerializableElement(descriptor, 9, serializer9)
                    10 -> eleventh = decodeSerializableElement(descriptor, 10, serializer10)
                    11 -> twelfth = decodeSerializableElement(descriptor, 11, serializer11)
                    12 -> thirteenth = decodeSerializableElement(descriptor, 12, serializer12)
                    13 -> fourteenth = decodeSerializableElement(descriptor, 13, serializer13)
                    CompositeDecoder.DECODE_DONE -> break
                    else -> error("Unexpected index: $index")
                }
            }
            @Suppress("UNCHECKED_CAST")
            tupleOf(first as A0, second as A1, third as A2, fourth as A3, fifth as A4, sixth as A5, seventh as A6, eighth as A7, ninth as A8, tenth as A9, eleventh as A10, twelfth as A11, thirteenth as A12, fourteenth as A13)
        }
}

// Tuple15

class Tuple15Serializer<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14>(
    private val serializer0: KSerializer<A0>,
    private val serializer1: KSerializer<A1>,
    private val serializer2: KSerializer<A2>,
    private val serializer3: KSerializer<A3>,
    private val serializer4: KSerializer<A4>,
    private val serializer5: KSerializer<A5>,
    private val serializer6: KSerializer<A6>,
    private val serializer7: KSerializer<A7>,
    private val serializer8: KSerializer<A8>,
    private val serializer9: KSerializer<A9>,
    private val serializer10: KSerializer<A10>,
    private val serializer11: KSerializer<A11>,
    private val serializer12: KSerializer<A12>,
    private val serializer13: KSerializer<A13>,
    private val serializer14: KSerializer<A14>,
) : KSerializer<Tuple15<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14>> {
    override val descriptor: SerialDescriptor =
        buildSerialDescriptor("Tuple15", StructureKind.LIST) {
            element("first", serializer0.descriptor)
            element("second", serializer1.descriptor)
            element("third", serializer2.descriptor)
            element("fourth", serializer3.descriptor)
            element("fifth", serializer4.descriptor)
            element("sixth", serializer5.descriptor)
            element("seventh", serializer6.descriptor)
            element("eighth", serializer7.descriptor)
            element("ninth", serializer8.descriptor)
            element("tenth", serializer9.descriptor)
            element("eleventh", serializer10.descriptor)
            element("twelfth", serializer11.descriptor)
            element("thirteenth", serializer12.descriptor)
            element("fourteenth", serializer13.descriptor)
            element("fifteenth", serializer14.descriptor)
        }

    override fun serialize(encoder: Encoder, value: Tuple15<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14>) {
        encoder.encodeStructure(descriptor) {
            encodeSerializableElement(descriptor, 0, serializer0, value.first)
            encodeSerializableElement(descriptor, 1, serializer1, value.second)
            encodeSerializableElement(descriptor, 2, serializer2, value.third)
            encodeSerializableElement(descriptor, 3, serializer3, value.fourth)
            encodeSerializableElement(descriptor, 4, serializer4, value.fifth)
            encodeSerializableElement(descriptor, 5, serializer5, value.sixth)
            encodeSerializableElement(descriptor, 6, serializer6, value.seventh)
            encodeSerializableElement(descriptor, 7, serializer7, value.eighth)
            encodeSerializableElement(descriptor, 8, serializer8, value.ninth)
            encodeSerializableElement(descriptor, 9, serializer9, value.tenth)
            encodeSerializableElement(descriptor, 10, serializer10, value.eleventh)
            encodeSerializableElement(descriptor, 11, serializer11, value.twelfth)
            encodeSerializableElement(descriptor, 12, serializer12, value.thirteenth)
            encodeSerializableElement(descriptor, 13, serializer13, value.fourteenth)
            encodeSerializableElement(descriptor, 14, serializer14, value.fifteenth)
        }
    }

    override fun deserialize(decoder: Decoder): Tuple15<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14> =
        decoder.decodeStructure(descriptor) {
            var first: A0? = null
            var second: A1? = null
            var third: A2? = null
            var fourth: A3? = null
            var fifth: A4? = null
            var sixth: A5? = null
            var seventh: A6? = null
            var eighth: A7? = null
            var ninth: A8? = null
            var tenth: A9? = null
            var eleventh: A10? = null
            var twelfth: A11? = null
            var thirteenth: A12? = null
            var fourteenth: A13? = null
            var fifteenth: A14? = null
            while (true) {
                when (val index = decodeElementIndex(descriptor)) {
                    0 -> first = decodeSerializableElement(descriptor, 0, serializer0)
                    1 -> second = decodeSerializableElement(descriptor, 1, serializer1)
                    2 -> third = decodeSerializableElement(descriptor, 2, serializer2)
                    3 -> fourth = decodeSerializableElement(descriptor, 3, serializer3)
                    4 -> fifth = decodeSerializableElement(descriptor, 4, serializer4)
                    5 -> sixth = decodeSerializableElement(descriptor, 5, serializer5)
                    6 -> seventh = decodeSerializableElement(descriptor, 6, serializer6)
                    7 -> eighth = decodeSerializableElement(descriptor, 7, serializer7)
                    8 -> ninth = decodeSerializableElement(descriptor, 8, serializer8)
                    9 -> tenth = decodeSerializableElement(descriptor, 9, serializer9)
                    10 -> eleventh = decodeSerializableElement(descriptor, 10, serializer10)
                    11 -> twelfth = decodeSerializableElement(descriptor, 11, serializer11)
                    12 -> thirteenth = decodeSerializableElement(descriptor, 12, serializer12)
                    13 -> fourteenth = decodeSerializableElement(descriptor, 13, serializer13)
                    14 -> fifteenth = decodeSerializableElement(descriptor, 14, serializer14)
                    CompositeDecoder.DECODE_DONE -> break
                    else -> error("Unexpected index: $index")
                }
            }
            @Suppress("UNCHECKED_CAST")
            tupleOf(first as A0, second as A1, third as A2, fourth as A3, fifth as A4, sixth as A5, seventh as A6, eighth as A7, ninth as A8, tenth as A9, eleventh as A10, twelfth as A11, thirteenth as A12, fourteenth as A13, fifteenth as A14)
        }
}

// Tuple16

class Tuple16Serializer<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15>(
    private val serializer0: KSerializer<A0>,
    private val serializer1: KSerializer<A1>,
    private val serializer2: KSerializer<A2>,
    private val serializer3: KSerializer<A3>,
    private val serializer4: KSerializer<A4>,
    private val serializer5: KSerializer<A5>,
    private val serializer6: KSerializer<A6>,
    private val serializer7: KSerializer<A7>,
    private val serializer8: KSerializer<A8>,
    private val serializer9: KSerializer<A9>,
    private val serializer10: KSerializer<A10>,
    private val serializer11: KSerializer<A11>,
    private val serializer12: KSerializer<A12>,
    private val serializer13: KSerializer<A13>,
    private val serializer14: KSerializer<A14>,
    private val serializer15: KSerializer<A15>,
) : KSerializer<Tuple16<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15>> {
    override val descriptor: SerialDescriptor =
        buildSerialDescriptor("Tuple16", StructureKind.LIST) {
            element("first", serializer0.descriptor)
            element("second", serializer1.descriptor)
            element("third", serializer2.descriptor)
            element("fourth", serializer3.descriptor)
            element("fifth", serializer4.descriptor)
            element("sixth", serializer5.descriptor)
            element("seventh", serializer6.descriptor)
            element("eighth", serializer7.descriptor)
            element("ninth", serializer8.descriptor)
            element("tenth", serializer9.descriptor)
            element("eleventh", serializer10.descriptor)
            element("twelfth", serializer11.descriptor)
            element("thirteenth", serializer12.descriptor)
            element("fourteenth", serializer13.descriptor)
            element("fifteenth", serializer14.descriptor)
            element("sixteenth", serializer15.descriptor)
        }

    override fun serialize(encoder: Encoder, value: Tuple16<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15>) {
        encoder.encodeStructure(descriptor) {
            encodeSerializableElement(descriptor, 0, serializer0, value.first)
            encodeSerializableElement(descriptor, 1, serializer1, value.second)
            encodeSerializableElement(descriptor, 2, serializer2, value.third)
            encodeSerializableElement(descriptor, 3, serializer3, value.fourth)
            encodeSerializableElement(descriptor, 4, serializer4, value.fifth)
            encodeSerializableElement(descriptor, 5, serializer5, value.sixth)
            encodeSerializableElement(descriptor, 6, serializer6, value.seventh)
            encodeSerializableElement(descriptor, 7, serializer7, value.eighth)
            encodeSerializableElement(descriptor, 8, serializer8, value.ninth)
            encodeSerializableElement(descriptor, 9, serializer9, value.tenth)
            encodeSerializableElement(descriptor, 10, serializer10, value.eleventh)
            encodeSerializableElement(descriptor, 11, serializer11, value.twelfth)
            encodeSerializableElement(descriptor, 12, serializer12, value.thirteenth)
            encodeSerializableElement(descriptor, 13, serializer13, value.fourteenth)
            encodeSerializableElement(descriptor, 14, serializer14, value.fifteenth)
            encodeSerializableElement(descriptor, 15, serializer15, value.sixteenth)
        }
    }

    override fun deserialize(decoder: Decoder): Tuple16<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15> =
        decoder.decodeStructure(descriptor) {
            var first: A0? = null
            var second: A1? = null
            var third: A2? = null
            var fourth: A3? = null
            var fifth: A4? = null
            var sixth: A5? = null
            var seventh: A6? = null
            var eighth: A7? = null
            var ninth: A8? = null
            var tenth: A9? = null
            var eleventh: A10? = null
            var twelfth: A11? = null
            var thirteenth: A12? = null
            var fourteenth: A13? = null
            var fifteenth: A14? = null
            var sixteenth: A15? = null
            while (true) {
                when (val index = decodeElementIndex(descriptor)) {
                    0 -> first = decodeSerializableElement(descriptor, 0, serializer0)
                    1 -> second = decodeSerializableElement(descriptor, 1, serializer1)
                    2 -> third = decodeSerializableElement(descriptor, 2, serializer2)
                    3 -> fourth = decodeSerializableElement(descriptor, 3, serializer3)
                    4 -> fifth = decodeSerializableElement(descriptor, 4, serializer4)
                    5 -> sixth = decodeSerializableElement(descriptor, 5, serializer5)
                    6 -> seventh = decodeSerializableElement(descriptor, 6, serializer6)
                    7 -> eighth = decodeSerializableElement(descriptor, 7, serializer7)
                    8 -> ninth = decodeSerializableElement(descriptor, 8, serializer8)
                    9 -> tenth = decodeSerializableElement(descriptor, 9, serializer9)
                    10 -> eleventh = decodeSerializableElement(descriptor, 10, serializer10)
                    11 -> twelfth = decodeSerializableElement(descriptor, 11, serializer11)
                    12 -> thirteenth = decodeSerializableElement(descriptor, 12, serializer12)
                    13 -> fourteenth = decodeSerializableElement(descriptor, 13, serializer13)
                    14 -> fifteenth = decodeSerializableElement(descriptor, 14, serializer14)
                    15 -> sixteenth = decodeSerializableElement(descriptor, 15, serializer15)
                    CompositeDecoder.DECODE_DONE -> break
                    else -> error("Unexpected index: $index")
                }
            }
            @Suppress("UNCHECKED_CAST")
            tupleOf(first as A0, second as A1, third as A2, fourth as A3, fifth as A4, sixth as A5, seventh as A6, eighth as A7, ninth as A8, tenth as A9, eleventh as A10, twelfth as A11, thirteenth as A12, fourteenth as A13, fifteenth as A14, sixteenth as A15)
        }
}

// Tuple17

class Tuple17Serializer<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16>(
    private val serializer0: KSerializer<A0>,
    private val serializer1: KSerializer<A1>,
    private val serializer2: KSerializer<A2>,
    private val serializer3: KSerializer<A3>,
    private val serializer4: KSerializer<A4>,
    private val serializer5: KSerializer<A5>,
    private val serializer6: KSerializer<A6>,
    private val serializer7: KSerializer<A7>,
    private val serializer8: KSerializer<A8>,
    private val serializer9: KSerializer<A9>,
    private val serializer10: KSerializer<A10>,
    private val serializer11: KSerializer<A11>,
    private val serializer12: KSerializer<A12>,
    private val serializer13: KSerializer<A13>,
    private val serializer14: KSerializer<A14>,
    private val serializer15: KSerializer<A15>,
    private val serializer16: KSerializer<A16>,
) : KSerializer<Tuple17<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16>> {
    override val descriptor: SerialDescriptor =
        buildSerialDescriptor("Tuple17", StructureKind.LIST) {
            element("first", serializer0.descriptor)
            element("second", serializer1.descriptor)
            element("third", serializer2.descriptor)
            element("fourth", serializer3.descriptor)
            element("fifth", serializer4.descriptor)
            element("sixth", serializer5.descriptor)
            element("seventh", serializer6.descriptor)
            element("eighth", serializer7.descriptor)
            element("ninth", serializer8.descriptor)
            element("tenth", serializer9.descriptor)
            element("eleventh", serializer10.descriptor)
            element("twelfth", serializer11.descriptor)
            element("thirteenth", serializer12.descriptor)
            element("fourteenth", serializer13.descriptor)
            element("fifteenth", serializer14.descriptor)
            element("sixteenth", serializer15.descriptor)
            element("seventeenth", serializer16.descriptor)
        }

    override fun serialize(encoder: Encoder, value: Tuple17<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16>) {
        encoder.encodeStructure(descriptor) {
            encodeSerializableElement(descriptor, 0, serializer0, value.first)
            encodeSerializableElement(descriptor, 1, serializer1, value.second)
            encodeSerializableElement(descriptor, 2, serializer2, value.third)
            encodeSerializableElement(descriptor, 3, serializer3, value.fourth)
            encodeSerializableElement(descriptor, 4, serializer4, value.fifth)
            encodeSerializableElement(descriptor, 5, serializer5, value.sixth)
            encodeSerializableElement(descriptor, 6, serializer6, value.seventh)
            encodeSerializableElement(descriptor, 7, serializer7, value.eighth)
            encodeSerializableElement(descriptor, 8, serializer8, value.ninth)
            encodeSerializableElement(descriptor, 9, serializer9, value.tenth)
            encodeSerializableElement(descriptor, 10, serializer10, value.eleventh)
            encodeSerializableElement(descriptor, 11, serializer11, value.twelfth)
            encodeSerializableElement(descriptor, 12, serializer12, value.thirteenth)
            encodeSerializableElement(descriptor, 13, serializer13, value.fourteenth)
            encodeSerializableElement(descriptor, 14, serializer14, value.fifteenth)
            encodeSerializableElement(descriptor, 15, serializer15, value.sixteenth)
            encodeSerializableElement(descriptor, 16, serializer16, value.seventeenth)
        }
    }

    override fun deserialize(decoder: Decoder): Tuple17<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16> =
        decoder.decodeStructure(descriptor) {
            var first: A0? = null
            var second: A1? = null
            var third: A2? = null
            var fourth: A3? = null
            var fifth: A4? = null
            var sixth: A5? = null
            var seventh: A6? = null
            var eighth: A7? = null
            var ninth: A8? = null
            var tenth: A9? = null
            var eleventh: A10? = null
            var twelfth: A11? = null
            var thirteenth: A12? = null
            var fourteenth: A13? = null
            var fifteenth: A14? = null
            var sixteenth: A15? = null
            var seventeenth: A16? = null
            while (true) {
                when (val index = decodeElementIndex(descriptor)) {
                    0 -> first = decodeSerializableElement(descriptor, 0, serializer0)
                    1 -> second = decodeSerializableElement(descriptor, 1, serializer1)
                    2 -> third = decodeSerializableElement(descriptor, 2, serializer2)
                    3 -> fourth = decodeSerializableElement(descriptor, 3, serializer3)
                    4 -> fifth = decodeSerializableElement(descriptor, 4, serializer4)
                    5 -> sixth = decodeSerializableElement(descriptor, 5, serializer5)
                    6 -> seventh = decodeSerializableElement(descriptor, 6, serializer6)
                    7 -> eighth = decodeSerializableElement(descriptor, 7, serializer7)
                    8 -> ninth = decodeSerializableElement(descriptor, 8, serializer8)
                    9 -> tenth = decodeSerializableElement(descriptor, 9, serializer9)
                    10 -> eleventh = decodeSerializableElement(descriptor, 10, serializer10)
                    11 -> twelfth = decodeSerializableElement(descriptor, 11, serializer11)
                    12 -> thirteenth = decodeSerializableElement(descriptor, 12, serializer12)
                    13 -> fourteenth = decodeSerializableElement(descriptor, 13, serializer13)
                    14 -> fifteenth = decodeSerializableElement(descriptor, 14, serializer14)
                    15 -> sixteenth = decodeSerializableElement(descriptor, 15, serializer15)
                    16 -> seventeenth = decodeSerializableElement(descriptor, 16, serializer16)
                    CompositeDecoder.DECODE_DONE -> break
                    else -> error("Unexpected index: $index")
                }
            }
            @Suppress("UNCHECKED_CAST")
            tupleOf(first as A0, second as A1, third as A2, fourth as A3, fifth as A4, sixth as A5, seventh as A6, eighth as A7, ninth as A8, tenth as A9, eleventh as A10, twelfth as A11, thirteenth as A12, fourteenth as A13, fifteenth as A14, sixteenth as A15, seventeenth as A16)
        }
}

// Tuple18

class Tuple18Serializer<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17>(
    private val serializer0: KSerializer<A0>,
    private val serializer1: KSerializer<A1>,
    private val serializer2: KSerializer<A2>,
    private val serializer3: KSerializer<A3>,
    private val serializer4: KSerializer<A4>,
    private val serializer5: KSerializer<A5>,
    private val serializer6: KSerializer<A6>,
    private val serializer7: KSerializer<A7>,
    private val serializer8: KSerializer<A8>,
    private val serializer9: KSerializer<A9>,
    private val serializer10: KSerializer<A10>,
    private val serializer11: KSerializer<A11>,
    private val serializer12: KSerializer<A12>,
    private val serializer13: KSerializer<A13>,
    private val serializer14: KSerializer<A14>,
    private val serializer15: KSerializer<A15>,
    private val serializer16: KSerializer<A16>,
    private val serializer17: KSerializer<A17>,
) : KSerializer<Tuple18<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17>> {
    override val descriptor: SerialDescriptor =
        buildSerialDescriptor("Tuple18", StructureKind.LIST) {
            element("first", serializer0.descriptor)
            element("second", serializer1.descriptor)
            element("third", serializer2.descriptor)
            element("fourth", serializer3.descriptor)
            element("fifth", serializer4.descriptor)
            element("sixth", serializer5.descriptor)
            element("seventh", serializer6.descriptor)
            element("eighth", serializer7.descriptor)
            element("ninth", serializer8.descriptor)
            element("tenth", serializer9.descriptor)
            element("eleventh", serializer10.descriptor)
            element("twelfth", serializer11.descriptor)
            element("thirteenth", serializer12.descriptor)
            element("fourteenth", serializer13.descriptor)
            element("fifteenth", serializer14.descriptor)
            element("sixteenth", serializer15.descriptor)
            element("seventeenth", serializer16.descriptor)
            element("eighteenth", serializer17.descriptor)
        }

    override fun serialize(encoder: Encoder, value: Tuple18<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17>) {
        encoder.encodeStructure(descriptor) {
            encodeSerializableElement(descriptor, 0, serializer0, value.first)
            encodeSerializableElement(descriptor, 1, serializer1, value.second)
            encodeSerializableElement(descriptor, 2, serializer2, value.third)
            encodeSerializableElement(descriptor, 3, serializer3, value.fourth)
            encodeSerializableElement(descriptor, 4, serializer4, value.fifth)
            encodeSerializableElement(descriptor, 5, serializer5, value.sixth)
            encodeSerializableElement(descriptor, 6, serializer6, value.seventh)
            encodeSerializableElement(descriptor, 7, serializer7, value.eighth)
            encodeSerializableElement(descriptor, 8, serializer8, value.ninth)
            encodeSerializableElement(descriptor, 9, serializer9, value.tenth)
            encodeSerializableElement(descriptor, 10, serializer10, value.eleventh)
            encodeSerializableElement(descriptor, 11, serializer11, value.twelfth)
            encodeSerializableElement(descriptor, 12, serializer12, value.thirteenth)
            encodeSerializableElement(descriptor, 13, serializer13, value.fourteenth)
            encodeSerializableElement(descriptor, 14, serializer14, value.fifteenth)
            encodeSerializableElement(descriptor, 15, serializer15, value.sixteenth)
            encodeSerializableElement(descriptor, 16, serializer16, value.seventeenth)
            encodeSerializableElement(descriptor, 17, serializer17, value.eighteenth)
        }
    }

    override fun deserialize(decoder: Decoder): Tuple18<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17> =
        decoder.decodeStructure(descriptor) {
            var first: A0? = null
            var second: A1? = null
            var third: A2? = null
            var fourth: A3? = null
            var fifth: A4? = null
            var sixth: A5? = null
            var seventh: A6? = null
            var eighth: A7? = null
            var ninth: A8? = null
            var tenth: A9? = null
            var eleventh: A10? = null
            var twelfth: A11? = null
            var thirteenth: A12? = null
            var fourteenth: A13? = null
            var fifteenth: A14? = null
            var sixteenth: A15? = null
            var seventeenth: A16? = null
            var eighteenth: A17? = null
            while (true) {
                when (val index = decodeElementIndex(descriptor)) {
                    0 -> first = decodeSerializableElement(descriptor, 0, serializer0)
                    1 -> second = decodeSerializableElement(descriptor, 1, serializer1)
                    2 -> third = decodeSerializableElement(descriptor, 2, serializer2)
                    3 -> fourth = decodeSerializableElement(descriptor, 3, serializer3)
                    4 -> fifth = decodeSerializableElement(descriptor, 4, serializer4)
                    5 -> sixth = decodeSerializableElement(descriptor, 5, serializer5)
                    6 -> seventh = decodeSerializableElement(descriptor, 6, serializer6)
                    7 -> eighth = decodeSerializableElement(descriptor, 7, serializer7)
                    8 -> ninth = decodeSerializableElement(descriptor, 8, serializer8)
                    9 -> tenth = decodeSerializableElement(descriptor, 9, serializer9)
                    10 -> eleventh = decodeSerializableElement(descriptor, 10, serializer10)
                    11 -> twelfth = decodeSerializableElement(descriptor, 11, serializer11)
                    12 -> thirteenth = decodeSerializableElement(descriptor, 12, serializer12)
                    13 -> fourteenth = decodeSerializableElement(descriptor, 13, serializer13)
                    14 -> fifteenth = decodeSerializableElement(descriptor, 14, serializer14)
                    15 -> sixteenth = decodeSerializableElement(descriptor, 15, serializer15)
                    16 -> seventeenth = decodeSerializableElement(descriptor, 16, serializer16)
                    17 -> eighteenth = decodeSerializableElement(descriptor, 17, serializer17)
                    CompositeDecoder.DECODE_DONE -> break
                    else -> error("Unexpected index: $index")
                }
            }
            @Suppress("UNCHECKED_CAST")
            tupleOf(first as A0, second as A1, third as A2, fourth as A3, fifth as A4, sixth as A5, seventh as A6, eighth as A7, ninth as A8, tenth as A9, eleventh as A10, twelfth as A11, thirteenth as A12, fourteenth as A13, fifteenth as A14, sixteenth as A15, seventeenth as A16, eighteenth as A17)
        }
}

// Tuple19

class Tuple19Serializer<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18>(
    private val serializer0: KSerializer<A0>,
    private val serializer1: KSerializer<A1>,
    private val serializer2: KSerializer<A2>,
    private val serializer3: KSerializer<A3>,
    private val serializer4: KSerializer<A4>,
    private val serializer5: KSerializer<A5>,
    private val serializer6: KSerializer<A6>,
    private val serializer7: KSerializer<A7>,
    private val serializer8: KSerializer<A8>,
    private val serializer9: KSerializer<A9>,
    private val serializer10: KSerializer<A10>,
    private val serializer11: KSerializer<A11>,
    private val serializer12: KSerializer<A12>,
    private val serializer13: KSerializer<A13>,
    private val serializer14: KSerializer<A14>,
    private val serializer15: KSerializer<A15>,
    private val serializer16: KSerializer<A16>,
    private val serializer17: KSerializer<A17>,
    private val serializer18: KSerializer<A18>,
) : KSerializer<Tuple19<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18>> {
    override val descriptor: SerialDescriptor =
        buildSerialDescriptor("Tuple19", StructureKind.LIST) {
            element("first", serializer0.descriptor)
            element("second", serializer1.descriptor)
            element("third", serializer2.descriptor)
            element("fourth", serializer3.descriptor)
            element("fifth", serializer4.descriptor)
            element("sixth", serializer5.descriptor)
            element("seventh", serializer6.descriptor)
            element("eighth", serializer7.descriptor)
            element("ninth", serializer8.descriptor)
            element("tenth", serializer9.descriptor)
            element("eleventh", serializer10.descriptor)
            element("twelfth", serializer11.descriptor)
            element("thirteenth", serializer12.descriptor)
            element("fourteenth", serializer13.descriptor)
            element("fifteenth", serializer14.descriptor)
            element("sixteenth", serializer15.descriptor)
            element("seventeenth", serializer16.descriptor)
            element("eighteenth", serializer17.descriptor)
            element("nineteenth", serializer18.descriptor)
        }

    override fun serialize(encoder: Encoder, value: Tuple19<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18>) {
        encoder.encodeStructure(descriptor) {
            encodeSerializableElement(descriptor, 0, serializer0, value.first)
            encodeSerializableElement(descriptor, 1, serializer1, value.second)
            encodeSerializableElement(descriptor, 2, serializer2, value.third)
            encodeSerializableElement(descriptor, 3, serializer3, value.fourth)
            encodeSerializableElement(descriptor, 4, serializer4, value.fifth)
            encodeSerializableElement(descriptor, 5, serializer5, value.sixth)
            encodeSerializableElement(descriptor, 6, serializer6, value.seventh)
            encodeSerializableElement(descriptor, 7, serializer7, value.eighth)
            encodeSerializableElement(descriptor, 8, serializer8, value.ninth)
            encodeSerializableElement(descriptor, 9, serializer9, value.tenth)
            encodeSerializableElement(descriptor, 10, serializer10, value.eleventh)
            encodeSerializableElement(descriptor, 11, serializer11, value.twelfth)
            encodeSerializableElement(descriptor, 12, serializer12, value.thirteenth)
            encodeSerializableElement(descriptor, 13, serializer13, value.fourteenth)
            encodeSerializableElement(descriptor, 14, serializer14, value.fifteenth)
            encodeSerializableElement(descriptor, 15, serializer15, value.sixteenth)
            encodeSerializableElement(descriptor, 16, serializer16, value.seventeenth)
            encodeSerializableElement(descriptor, 17, serializer17, value.eighteenth)
            encodeSerializableElement(descriptor, 18, serializer18, value.nineteenth)
        }
    }

    override fun deserialize(decoder: Decoder): Tuple19<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18> =
        decoder.decodeStructure(descriptor) {
            var first: A0? = null
            var second: A1? = null
            var third: A2? = null
            var fourth: A3? = null
            var fifth: A4? = null
            var sixth: A5? = null
            var seventh: A6? = null
            var eighth: A7? = null
            var ninth: A8? = null
            var tenth: A9? = null
            var eleventh: A10? = null
            var twelfth: A11? = null
            var thirteenth: A12? = null
            var fourteenth: A13? = null
            var fifteenth: A14? = null
            var sixteenth: A15? = null
            var seventeenth: A16? = null
            var eighteenth: A17? = null
            var nineteenth: A18? = null
            while (true) {
                when (val index = decodeElementIndex(descriptor)) {
                    0 -> first = decodeSerializableElement(descriptor, 0, serializer0)
                    1 -> second = decodeSerializableElement(descriptor, 1, serializer1)
                    2 -> third = decodeSerializableElement(descriptor, 2, serializer2)
                    3 -> fourth = decodeSerializableElement(descriptor, 3, serializer3)
                    4 -> fifth = decodeSerializableElement(descriptor, 4, serializer4)
                    5 -> sixth = decodeSerializableElement(descriptor, 5, serializer5)
                    6 -> seventh = decodeSerializableElement(descriptor, 6, serializer6)
                    7 -> eighth = decodeSerializableElement(descriptor, 7, serializer7)
                    8 -> ninth = decodeSerializableElement(descriptor, 8, serializer8)
                    9 -> tenth = decodeSerializableElement(descriptor, 9, serializer9)
                    10 -> eleventh = decodeSerializableElement(descriptor, 10, serializer10)
                    11 -> twelfth = decodeSerializableElement(descriptor, 11, serializer11)
                    12 -> thirteenth = decodeSerializableElement(descriptor, 12, serializer12)
                    13 -> fourteenth = decodeSerializableElement(descriptor, 13, serializer13)
                    14 -> fifteenth = decodeSerializableElement(descriptor, 14, serializer14)
                    15 -> sixteenth = decodeSerializableElement(descriptor, 15, serializer15)
                    16 -> seventeenth = decodeSerializableElement(descriptor, 16, serializer16)
                    17 -> eighteenth = decodeSerializableElement(descriptor, 17, serializer17)
                    18 -> nineteenth = decodeSerializableElement(descriptor, 18, serializer18)
                    CompositeDecoder.DECODE_DONE -> break
                    else -> error("Unexpected index: $index")
                }
            }
            @Suppress("UNCHECKED_CAST")
            tupleOf(first as A0, second as A1, third as A2, fourth as A3, fifth as A4, sixth as A5, seventh as A6, eighth as A7, ninth as A8, tenth as A9, eleventh as A10, twelfth as A11, thirteenth as A12, fourteenth as A13, fifteenth as A14, sixteenth as A15, seventeenth as A16, eighteenth as A17, nineteenth as A18)
        }
}

// Tuple20

class Tuple20Serializer<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19>(
    private val serializer0: KSerializer<A0>,
    private val serializer1: KSerializer<A1>,
    private val serializer2: KSerializer<A2>,
    private val serializer3: KSerializer<A3>,
    private val serializer4: KSerializer<A4>,
    private val serializer5: KSerializer<A5>,
    private val serializer6: KSerializer<A6>,
    private val serializer7: KSerializer<A7>,
    private val serializer8: KSerializer<A8>,
    private val serializer9: KSerializer<A9>,
    private val serializer10: KSerializer<A10>,
    private val serializer11: KSerializer<A11>,
    private val serializer12: KSerializer<A12>,
    private val serializer13: KSerializer<A13>,
    private val serializer14: KSerializer<A14>,
    private val serializer15: KSerializer<A15>,
    private val serializer16: KSerializer<A16>,
    private val serializer17: KSerializer<A17>,
    private val serializer18: KSerializer<A18>,
    private val serializer19: KSerializer<A19>,
) : KSerializer<Tuple20<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19>> {
    override val descriptor: SerialDescriptor =
        buildSerialDescriptor("Tuple20", StructureKind.LIST) {
            element("first", serializer0.descriptor)
            element("second", serializer1.descriptor)
            element("third", serializer2.descriptor)
            element("fourth", serializer3.descriptor)
            element("fifth", serializer4.descriptor)
            element("sixth", serializer5.descriptor)
            element("seventh", serializer6.descriptor)
            element("eighth", serializer7.descriptor)
            element("ninth", serializer8.descriptor)
            element("tenth", serializer9.descriptor)
            element("eleventh", serializer10.descriptor)
            element("twelfth", serializer11.descriptor)
            element("thirteenth", serializer12.descriptor)
            element("fourteenth", serializer13.descriptor)
            element("fifteenth", serializer14.descriptor)
            element("sixteenth", serializer15.descriptor)
            element("seventeenth", serializer16.descriptor)
            element("eighteenth", serializer17.descriptor)
            element("nineteenth", serializer18.descriptor)
            element("twentieth", serializer19.descriptor)
        }

    override fun serialize(encoder: Encoder, value: Tuple20<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19>) {
        encoder.encodeStructure(descriptor) {
            encodeSerializableElement(descriptor, 0, serializer0, value.first)
            encodeSerializableElement(descriptor, 1, serializer1, value.second)
            encodeSerializableElement(descriptor, 2, serializer2, value.third)
            encodeSerializableElement(descriptor, 3, serializer3, value.fourth)
            encodeSerializableElement(descriptor, 4, serializer4, value.fifth)
            encodeSerializableElement(descriptor, 5, serializer5, value.sixth)
            encodeSerializableElement(descriptor, 6, serializer6, value.seventh)
            encodeSerializableElement(descriptor, 7, serializer7, value.eighth)
            encodeSerializableElement(descriptor, 8, serializer8, value.ninth)
            encodeSerializableElement(descriptor, 9, serializer9, value.tenth)
            encodeSerializableElement(descriptor, 10, serializer10, value.eleventh)
            encodeSerializableElement(descriptor, 11, serializer11, value.twelfth)
            encodeSerializableElement(descriptor, 12, serializer12, value.thirteenth)
            encodeSerializableElement(descriptor, 13, serializer13, value.fourteenth)
            encodeSerializableElement(descriptor, 14, serializer14, value.fifteenth)
            encodeSerializableElement(descriptor, 15, serializer15, value.sixteenth)
            encodeSerializableElement(descriptor, 16, serializer16, value.seventeenth)
            encodeSerializableElement(descriptor, 17, serializer17, value.eighteenth)
            encodeSerializableElement(descriptor, 18, serializer18, value.nineteenth)
            encodeSerializableElement(descriptor, 19, serializer19, value.twentieth)
        }
    }

    override fun deserialize(decoder: Decoder): Tuple20<A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19> =
        decoder.decodeStructure(descriptor) {
            var first: A0? = null
            var second: A1? = null
            var third: A2? = null
            var fourth: A3? = null
            var fifth: A4? = null
            var sixth: A5? = null
            var seventh: A6? = null
            var eighth: A7? = null
            var ninth: A8? = null
            var tenth: A9? = null
            var eleventh: A10? = null
            var twelfth: A11? = null
            var thirteenth: A12? = null
            var fourteenth: A13? = null
            var fifteenth: A14? = null
            var sixteenth: A15? = null
            var seventeenth: A16? = null
            var eighteenth: A17? = null
            var nineteenth: A18? = null
            var twentieth: A19? = null
            while (true) {
                when (val index = decodeElementIndex(descriptor)) {
                    0 -> first = decodeSerializableElement(descriptor, 0, serializer0)
                    1 -> second = decodeSerializableElement(descriptor, 1, serializer1)
                    2 -> third = decodeSerializableElement(descriptor, 2, serializer2)
                    3 -> fourth = decodeSerializableElement(descriptor, 3, serializer3)
                    4 -> fifth = decodeSerializableElement(descriptor, 4, serializer4)
                    5 -> sixth = decodeSerializableElement(descriptor, 5, serializer5)
                    6 -> seventh = decodeSerializableElement(descriptor, 6, serializer6)
                    7 -> eighth = decodeSerializableElement(descriptor, 7, serializer7)
                    8 -> ninth = decodeSerializableElement(descriptor, 8, serializer8)
                    9 -> tenth = decodeSerializableElement(descriptor, 9, serializer9)
                    10 -> eleventh = decodeSerializableElement(descriptor, 10, serializer10)
                    11 -> twelfth = decodeSerializableElement(descriptor, 11, serializer11)
                    12 -> thirteenth = decodeSerializableElement(descriptor, 12, serializer12)
                    13 -> fourteenth = decodeSerializableElement(descriptor, 13, serializer13)
                    14 -> fifteenth = decodeSerializableElement(descriptor, 14, serializer14)
                    15 -> sixteenth = decodeSerializableElement(descriptor, 15, serializer15)
                    16 -> seventeenth = decodeSerializableElement(descriptor, 16, serializer16)
                    17 -> eighteenth = decodeSerializableElement(descriptor, 17, serializer17)
                    18 -> nineteenth = decodeSerializableElement(descriptor, 18, serializer18)
                    19 -> twentieth = decodeSerializableElement(descriptor, 19, serializer19)
                    CompositeDecoder.DECODE_DONE -> break
                    else -> error("Unexpected index: $index")
                }
            }
            @Suppress("UNCHECKED_CAST")
            tupleOf(first as A0, second as A1, third as A2, fourth as A3, fifth as A4, sixth as A5, seventh as A6, eighth as A7, ninth as A8, tenth as A9, eleventh as A10, twelfth as A11, thirteenth as A12, fourteenth as A13, fifteenth as A14, sixteenth as A15, seventeenth as A16, eighteenth as A17, nineteenth as A18, twentieth as A19)
        }
}
