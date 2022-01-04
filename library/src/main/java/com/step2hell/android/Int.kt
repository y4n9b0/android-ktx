package com.step2hell.android

val Int.isOdd: Boolean
    get() = (this and 1) == 1

val Int.isEven: Boolean
    get() = (this and 1) == 0
