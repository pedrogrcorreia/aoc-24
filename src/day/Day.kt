package day

import day.day1.Day1
import day.day2.Day2
import day.day3.Day3
import day.day4.Day4
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.nio.file.Paths

interface Day {
    val day: Int

    fun firstPuzzleSolution(): String
    fun secondPuzzleSolution(): String

    fun readInput(): List<String> =
        Paths.get(".").normalize().toAbsolutePath().let { rootDir ->
            BufferedReader(
                FileReader(
                    File("$rootDir/src/inputs/day$day.txt")
                ),
            )
        }.readLines()
}

fun getDay(day: Int): Day = when(day) {
    1 -> Day1(1)
    2 -> Day2(2)
    3 -> Day3(3)
    4 -> Day4(4)
    else -> throw NotImplementedError("Day $day is not implemented yet.")
}