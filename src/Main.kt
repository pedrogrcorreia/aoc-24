import day.Day
import day.day1.Day1

fun main() {
    printDaySolution(Day1(1))
}

private fun printDaySolution(day: Day) {
    println("Day ${day.day}:\n")
    println("First puzzle solution: ${day.firstPuzzleSolution()}\n")
    println("Second puzzle solution: ${day.secondPuzzleSolution()}\n")
}