package com.step2hell.android.app

import com.step2hell.fp.curry


private fun foo(a: Int, b: Int, c: Int): Int {
    return a + 10 * b + 100 * c
}

fun curry(){
    val curry = ::foo.curry()
    println("curry=${curry(5)(2)(0)}")
}