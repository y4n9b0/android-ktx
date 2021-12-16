package com.step2hell.fp

fun <In, Out> y(f: ((In) -> Out) -> (In) -> Out): (In) -> Out = { f(y(f))(it) }
