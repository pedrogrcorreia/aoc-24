package day

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