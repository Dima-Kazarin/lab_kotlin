fun mergeMaps(map1: Map<String, String?>, map2: Map<String, String?>): Map<String, String> {
    val mergedMap = mutableMapOf<String, String>()

    for ((key, value) in map1) {
        value?.let { mergedMap[key] = it }
    }

    for ((key, value) in map2) {
        value?.let { mergedMap[key] = it }
    }

    return mergedMap
}

fun main() {
    val map1 = mapOf("a" to "apple", "b" to null, "c" to "cherry")
    val map2 = mapOf("b" to "banana", "d" to null, "s" to "strawberry")

    val result = mergeMaps(map1, map2)
    println(result)
}

