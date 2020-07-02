package com.expediagroup.api.kotlin.classes

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isNotEqualTo
import assertk.assertions.isNotNull
import com.expediagroup.api.kotlin.classes.Date
import com.expediagroup.api.kotlin.functionz.isValid
import org.junit.jupiter.api.Test

internal class DateTest {
    private val date: Date =
        Date(1, 1, 2020)

    @Test
    fun copy() {
        assertThat(date).isEqualTo(date.copy())
        assertThat(date).isNotEqualTo(date.copy(day = 2))
    }

    @Test
    fun testToString() {
        assertThat(date).isNotEqualTo(Date(2, 1, 2020))
    }

    @Test
    fun testHashCode() {
        assertThat { date.hashCode() }.isNotNull()
    }

    @Test
    fun testEquals() {
        assertThat(date).isNotEqualTo(Date(2, 1, 2020))
        assertThat(date).isEqualTo(date.copy())
    }

    @Test
    fun isValid(){
        assertThat(date.isValid()).isEqualTo(true)
        assertThat(Date(0, 0, 2020).isValid()).isEqualTo(false)
    }
}
