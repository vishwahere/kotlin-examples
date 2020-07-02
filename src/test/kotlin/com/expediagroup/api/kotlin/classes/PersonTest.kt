package com.expediagroup.api.kotlin.classes

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test


internal class PersonTest{
    @Test
    fun print(){
        Person("kotlin")
        Person("kotlin").firstName
        Person("kotlin").print()
        assertThat(com.expediagroup.api.kotlin.functionz.double(2)).isEqualTo(4)
    }
}
