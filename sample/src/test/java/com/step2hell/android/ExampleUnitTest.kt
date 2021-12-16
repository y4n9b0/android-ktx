package com.step2hell.android

import com.step2hell.fp.curry
import com.step2hell.fp.uncurry
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    private fun foo(a: Int, b: Int, c: Int, d: Int): Int {
        return a + 10 * b + 100 * c + 1000 * d
    }

    @Test
    fun testCurrying() {
        val curry = ::foo.curry()
        val uncurry = curry.uncurry()
        assertEquals(foo(9, 5, 2, 7), curry(9)(5)(2)(7))
        assertEquals(foo(9, 5, 2, 7), uncurry(9, 5, 2, 7))
        assertNotEquals(foo(9, 5, 2, 7), curry(1)(3)(1)(4))
        assertNotEquals(foo(9, 5, 2, 7), uncurry(1, 3, 1, 4))
    }
}