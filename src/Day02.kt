import kotlin.math.absoluteValue

fun main() {
    fun part1a(input: List<String>): Int {
        return input.filter { it.startsWith("forward") }.sumOf { it.split(" ")[1].toInt() }
    }

    fun part1b(input: List<String>): Int {
        var res = 0
        input.forEach {
            when {
                it.startsWith("down") -> res = res.minus(it.split(" ")[1].toInt())
                it.startsWith("up") -> res = res.plus(it.split(" ")[1].toInt())
                else -> {
                }
            }
        }
        return res.absoluteValue
    }

    // test if implementation meets criteria from the description, like:
//    val testInput = readInput("Day02_test")
//    println("forward = ${part1a(testInput)}")
//    println("Up/Down = ${part1b(testInput)}")
//    check(part1a(testInput) * part1b(testInput) == 150)

    fun part2(input: List<String>): Int {
        var aim = 0
        var hPos = 0
        var depth = 0

        input.map { it.split(' ') }
            .forEach { (direction, valueStr) ->
                when (direction) {
                    "down" -> aim += valueStr.toInt()
                    "up" -> aim -= valueStr.toInt()
                    "forward" -> {
                        hPos += valueStr.toInt()    // It increases your horizontal position by X units.
                        depth += aim * valueStr.toInt() // It increases your depth by your aim multiplied by X.
                    }
                }
            }
        return hPos * depth
    }

    val testInput = readInput("Day02_test")
    check(part2(testInput) == 900)

    val input = readInput("Day02")
    println(part2(input))
}