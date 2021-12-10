fun main() {
    fun part1(input: List<String>): Int {
        val columns = input[0].indices // every line has equal number of digits
        val gammaRate = buildString {
            for (column in columns) { // 0..4
                val (ones, zeroes) = input.countBitsInColumn(column)
                val commonBit = if (zeroes > ones) "0" else "1"
                append(commonBit)
            }
        }

        val gamma = gammaRate.toInt(2)
        val epsilonRate = gammaRate.invertBinaryString().toInt(2)
        println(gamma * epsilonRate)
        return gamma * epsilonRate
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 198)
}

private fun List<String>.countBitsInColumn(column: Int): BitCount {
    var zeroes = 0
    var ones = 0
    for (line in this) {
        if (line[column] == '0') zeroes++ else ones++
    }
    return BitCount(ones, zeroes)
}

private fun String.invertBinaryString() = this
    .asIterable()
    .joinToString("") { if (it =='0') "1" else "0" }

data class BitCount(val ones: Int, val zeros: Int)
