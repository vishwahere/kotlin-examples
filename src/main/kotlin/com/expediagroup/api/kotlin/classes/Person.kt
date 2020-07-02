package com.expediagroup.api.kotlin.classes

class Person(val firstName: String) {
    private lateinit var lastName: String

    constructor(firstName: String, lastName: String): this(firstName) {
        this.lastName = lastName
    }
    fun print() = println(firstName)
}
