package day.day3

import day.Day

class Day3(
    override val day: Int = 3,
) : Day {

    private val regex = Regex("""mul\((\d{1,3}),\s*(\d{1,3})\)""")
    private val regexCoded = Regex("""mul\((\d{1,3}),\s*(\d{1,3})\)|don't\(\)|do\(\)""")

    private val map = readInput().flatMap { line ->
        regex.findAll(line).map { match ->
            Multiplication(
                firstNumber = match.groupValues[1].toInt(),
                secondNumber = match.groupValues[2].toInt(),
            )
        }.toList()
    }

    private val codedMap = buildList {
        var canAdd = true
        readInput().flatMap { line ->
            regexCoded.findAll(line).map { match ->
                when (match.value) {
                    "don\'t()" -> canAdd = false
                    "do()" -> canAdd = true
                    else -> if (canAdd) add(
                        Multiplication(
                            firstNumber = match.groupValues[1].toInt(),
                            secondNumber = match.groupValues[2].toInt(),
                        ),
                    )
                }
            }
        }
    }

    override fun firstPuzzleSolution(): String = map.sumOf {
        it.firstNumber * it.secondNumber
    }.toString()

    override fun secondPuzzleSolution(): String = codedMap.sumOf {
        it.firstNumber * it.secondNumber
    }.toString()
}