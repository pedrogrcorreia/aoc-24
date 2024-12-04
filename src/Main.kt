import day.Day
import day.getDay

fun main() {
    for(i in 1 .. CURRENT_DAY) {
        printDaySolution(getDay(i))
    }
}

private fun printDaySolution(day: Day) {
    println("Day ${day.day}:\n")
    println("First puzzle solution: ${day.firstPuzzleSolution()}\n")
    println("Second puzzle solution: ${day.secondPuzzleSolution()}\n")
}

private const val CURRENT_DAY = 4