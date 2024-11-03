val isPrime: (Int) -> Boolean = { num ->
    if (num < 2) false
    else (2..<num).all { divisor -> num % divisor != 0 }
}

val findPrimes: (List<Int>) -> List<Int> = { numbers ->
    numbers.filter(isPrime)
}

fun main() {
    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val primes = findPrimes(numbers)
    println(primes)
}