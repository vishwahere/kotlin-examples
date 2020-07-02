package com.expediagroup.api.kotlin.functionz

import com.expediagroup.api.kotlin.classes.Date
import kotlinx.coroutines.delay
import kotlin.math.absoluteValue

fun double(num: Int = 3) = num * 2

fun sum(a: Int, b: Int) = a + b

fun sum(vararg ints: Int) = ints.sum()

fun <T> singletonList(item: T) = listOf(item)

fun <T> returnStringInvokeVersion(t: T, block: (T) -> String) = block.invoke(t)

fun <T> returnStringFunctionVersion(t: T, block: (T) -> String) = block(t)

fun Int.between(lower: Int, upper: Int): Boolean {
    return this.absoluteValue in (lower + 1) until upper
}

fun Date.isValid(): Boolean {
    return this.day.between(0, 31)
            && this.month.between(0, 13)
}

fun nullSafety() {
    var name: String? = "abc" // can be set null
    val l = name?.length?: -1 //Elvis operator
}

suspend fun callRemoteService1(): String {
    delay(500L) // assume this is time taken for remote call
    return "done1"
}

suspend fun callRemoteService2(): String {
    delay(500L) // assume this is time taken for remote call
    return "done2"
}
