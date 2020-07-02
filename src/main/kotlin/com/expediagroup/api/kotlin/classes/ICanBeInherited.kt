package com.expediagroup.api.kotlin.classes

open class Name(val name: String) {
    open fun print() {
        println(name)
    }
}

class FullName(val firstName: String, private val lastName: String) : Name(firstName) {
    override fun print() {
        super.print()
        println("$firstName $lastName")
    }
}
