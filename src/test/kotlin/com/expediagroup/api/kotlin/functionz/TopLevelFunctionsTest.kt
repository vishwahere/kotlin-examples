package com.expediagroup.api.kotlin.functionz

import assertk.assertThat
import assertk.assertions.*
import kotlinx.coroutines.*
import org.junit.jupiter.api.Test


internal object TopLevelFunctionsTest {
    @Test
    fun doubleTest() {
        assertThat(double(2)).isEqualTo(4)
        assertThat(double()).isEqualTo(6)
    }

    @Test
    fun sumTest() {
        assertThat(sum(2, 3)).isEqualTo(5)
        assertThat(sum(b = 3, a = 4)).isEqualTo(7)
    }

    @Test
    fun sumVarargsTest() {
        assertThat(sum(1, 2, 3, 4)).isEqualTo(10)
    }

    @Test
    fun singletonListTest() {
        assertThat(singletonList(1).size).isEqualTo(1)
    }

    @Test
    fun stringInvokeVersionTest() {
        assertThat(returnStringInvokeVersion(4, fun(s: Int): String { return s.toString() }))
            .isEqualTo("4")
        assertThat(returnStringInvokeVersion(4, { it.toString() }))
            .isEqualTo("4")
        assertThat(returnStringInvokeVersion(4, Int::toString))
            .isEqualTo("4")
    }

    @Test
    fun stringFunctionVersionTest() {
        assertThat(returnStringFunctionVersion(4, fun(s: Int): String { return s.toString() }))
            .isEqualTo("4")
        assertThat(returnStringFunctionVersion(4, { it.toString() }))
            .isEqualTo("4")
        assertThat(returnStringFunctionVersion(4, Int::toString))
            .isEqualTo("4")
    }

    @Test
    fun suspendFunctionTest() {
        var data: String
        runBlocking {
            data = callRemoteService1()
        }
        assertThat(data).isNotEmpty()
    }

    @Test
    fun coroutineGlobalTest() {
        var data: String = ""
        GlobalScope.launch {
            data = callRemoteService1()
        }
        Thread.sleep(600)
        assertThat(data).isNotEmpty()
    }

    @Test
    fun coroutineCustomTest() = runBlocking {
        var data: String = ""
        launch {
            data = callRemoteService1()
        }
    }

    @Test
    fun coroutineCustomJobTest() = runBlocking {
        var data: String = ""
        val job = launch {
            data = callRemoteService1()
        }
        job.join()
        assertThat(data).isNotEmpty()
    }

    @Test
    fun coroutineMultipleAsync() = runBlocking {
        val one = async { callRemoteService1() }
        val two = async { callRemoteService2() }
        assertThat(one.await() + two.await()).isEqualTo("done1done2")
    }
}

