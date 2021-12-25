package com.step2hell.android

infix fun <T , R> T.to(block: (T) -> R): R = block(this)
