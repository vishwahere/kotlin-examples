package com.expediagroup.api.kotlin.classes

object Singleton {
    fun getObject(): String {
        return "service-name"
    }
}

class MyClass {
    companion object Factory {
        fun create(): MyClass = MyClass()
    }
}

val instance = MyClass.create()
val serviceName = Singleton.getObject()
