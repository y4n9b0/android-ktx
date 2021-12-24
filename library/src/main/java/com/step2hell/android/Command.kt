package com.step2hell.android

import java.io.BufferedReader
import java.io.InputStreamReader

fun String.execute(): Process {
    return Runtime.getRuntime().exec(this)
}

fun Process.text(): String {
    // https://discuss.kotlinlang.org/t/stringbuilder-and-kotlin/441
    val output = StringBuilder()
    // https://stackoverflow.com/questions/65949050/kotlin-nested-use-function-for-java-try-with-resource
    BufferedReader(InputStreamReader(inputStream)).use {
        var line: String? = ""
        while (line != null) {
            line = it.readLine()
            output.appendLine(line)
        }
    }
    return output.toString()
}
