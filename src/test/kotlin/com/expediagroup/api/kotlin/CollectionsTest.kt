package com.expediagroup.api.kotlin
import assertk.assertThat
import assertk.assertions.containsAll
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CollectionsTest {
    @Test
    internal fun mutableCollection(){
        mutableListOf(1, 2, 3)//add not supported
        mutableMapOf(1 to "a", 2 to "b")

        assertThat(listOf(1, 2, 3).size).isEqualTo(3)
        assertThat(setOf(1, 2, 3).size).isEqualTo(3)
        assertThat(mapOf(1 to "a", 2 to "b", 3 to "c").size).isEqualTo(3)
    }

    @Test
    internal fun listFilter(){
        val list = List(5) {it + 1}
        assertThat(list.filter { it%2 == 0 })
            .containsAll(2, 4)
        assertThat(list.filterNot { it%2 == 0 })
            .containsAll(1, 3, 5)
    }

    @Test
    internal fun listOperators(){
        assertThat(listOf(1, 2, 3) + listOf(4, 5)).containsAll(1, 2, 3, 4, 5)
        assertThat(listOf(1, 2, 3) - listOf(2)).containsAll(1, 3)

    }

    @Test
    public fun mapOperations(){
        assertThat(mapOf("one" to 1, "two" to 2, "three" to 3)["one"]).isEqualTo(1)
        assertThat(mapOf("one" to 1, "two" to 2).filter{(k,v)->k.equals("one") && v.equals(1)}["one"]).isEqualTo(1)
        assertThat(mapOf("one" to 1) + mapOf("two" to 2)).containsAll(Pair("one", 1), Pair("two", 2))
    }
}
