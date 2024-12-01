package day.day1

import day.Day

class Day1(
    override val day: Int,
) : Day {

    private val input = readInput()
    private val regex = "\\d+".toRegex()

    private fun createPairs(): List<NumberPair> = input.map { line ->
        val pair = regex.findAll(line).map { match ->
            match.value.toInt()
        }
        NumberPair(
            leftNumber = pair.first().toInt(),
            rightNumber = pair.last().toInt(),
        )
    }

    override fun firstPuzzleSolution(): String =
        createPairs().let { pairs ->
            pairs.map { it.leftNumber }
                .sorted()
                .zip(
                    pairs.map { it.rightNumber }
                        .sorted(),
                ) { leftNumber, rightNumber ->
                    NumberPair(leftNumber, rightNumber)
                }
        }.sumOf { it.difference }.toString()

    override fun secondPuzzleSolution(): String =
        createPairs().let { pairs ->
            pairs.map { pair ->
                var multiplier = 0
                pairs.forEach { secondList ->
                    if (pair.leftNumber == secondList.rightNumber) {
                        multiplier++
                    }
                }
                pair.leftNumber * multiplier
            }
        }.sumOf { it }.toString()
}