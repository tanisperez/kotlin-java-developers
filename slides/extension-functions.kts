#!/usr/bin/env kotlin

fun String.isNumeric(): Boolean =
    all { it.isDigit() }

fun Double.toPercent(): String =
    "${this * 100}%"

val variable1 = "hola"
val variable2 = "14"

println("""variable1 '$variable1' -> isNumeric = ${variable1.isNumeric()}""")
println("""variable2 '$variable2' -> isNumeric = ${variable2.isNumeric()}""")

val tax = 0.21
println("""Tax percentage: ${tax.toPercent()}""")
