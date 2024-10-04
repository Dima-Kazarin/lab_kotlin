fun Double.gcd(other: Double): Int {
    var a = this.toInt()
    var b = other.toInt()

    while (a != 0 && b != 0) {
        if (a > b)
            a %= b
        else
            b %= a
    }
    return a + b
}

fun main() {
    val num1 = 35.0
    val num2 = 49.0

    println("Найбільший спільний дільник: ${num1.gcd(num2)}")
}
