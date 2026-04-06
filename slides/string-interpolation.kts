#!/usr/bin/env kotlin

val name = "Coruña JUG"
val year: Int = 2026

println("Hola $name, estamos en el año $year")

val a: Int = 5
val b: Int = 3
println("La suma es ${a + b}")

println("""
    Hola $name,
    tu nombre tiene ${name.length} caracteres
""".trimIndent())
