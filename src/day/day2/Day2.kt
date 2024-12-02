package day.day2

import day.Day
import kotlin.math.abs

class Day2(
    override val day: Int,
) : Day {

    private val input = readInput()
    private val regex = "\\d+".toRegex()


    private fun createReports(): List<Reports> = input.map { line ->
        regex.findAll(line).map { match ->
            match.value.toInt()
        }.let {
            Reports(it.toList())
        }
    }

    private fun List<Int>.isAscending(): Boolean = this
        .zipWithNext { a, b -> a < b }
        .all { it }

    private fun List<Int>.isDescending(): Boolean = this
        .zipWithNext { a, b -> a > b }.all { it }

    private fun List<Int>.isOrdered(): Boolean =
        isAscending() || isDescending()

    private fun List<Int>.isWithinRange(): Boolean = this
        .zipWithNext { a, b ->
            abs(a - b) in MINIMUM_VALUE..MAXIMUM_VALUE
        }.all { it }

    override fun firstPuzzleSolution(): String = createReports().count { report ->
        report.levels.isOrdered() && report.levels.isWithinRange()
    }.toString()


    override fun secondPuzzleSolution(): String = createReports().count { report ->
        for(i in report.levels.indices) {
            report.levels.filterIndexed { index, _ -> i != index }.let { newList ->
                if(newList.isOrdered() && newList.isWithinRange()) return@count true
            }
        }
        return@count false
    }.toString()

    companion object {
        private const val MINIMUM_VALUE = 1
        private const val MAXIMUM_VALUE = 3
    }
}