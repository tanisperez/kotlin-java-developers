fun tailfib(n: Int): Int {
    tailrec fun doFib(n: Int, a: Int, b: Int): Int {
        if (n == 0) {
            return a;
        }
        return doFib(n - 1, b, a + b)
    }

    return doFib(n, 0, 1)
}

fun main() {
    for (i in 0..49) {
        println("""tailfib($i) = ${tailfib(i)}""")
    }
}
