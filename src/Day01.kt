fun main() {
    fun part1(input: List<Int>): Int {
        return input.windowed(2).count { (a,b) -> b > a }
    }

    // a + b + c <=> b + c + d
//    fun part2(input: List<Int>): Int {
//        return input.windowed(3).windowed(2)
//            .count { (a,b) ->
//                println("a = ${a.sum()}, b = ${b.sum()}")
//                b.sum() > a.sum()
//            }
//    }

    // a + b + c + d <=> a < d
    fun part2(input: List<Int>): Int {
        return input.windowed(4)
            .count { it[0] < it[3]
            }
    }

    // test if implementation meets criteria from the description, like:
//    val testInput = readInputAsInt("Day01_test")
//    check(part2(testInput) == 5)

    val input = readInputAsInt("Day01")
//    println(part1(input))
    println(part2(input))
}
