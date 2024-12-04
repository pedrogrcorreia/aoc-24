package day.day4

import day.Day

class Day4(
    override val day: Int,
) : Day {

    private val wordMap: List<String> = readInput()

    private fun countInputs(
        firstLetter: Char,
        solution: String,
        coordMap: List<List<Point>>,
    ): String =
        wordMap.indices.sumOf { rowIdx ->
            wordMap[rowIdx].indices.sumOf { colIdx ->
                wordMap[rowIdx][colIdx].takeIf { it  == firstLetter }.let {
                    coordMap.count { coord ->
                        val result = coord.map { offset ->
                            wordMap.getChar(
                                start = Point(
                                    x = rowIdx,
                                    y = colIdx,
                                ),
                                search = offset,
                            )
                        }.joinToString("")
                        result == solution
                    }
                }
            }
        }.toString()

    private fun List<String>.getChar(start: Point, search: Point): Char =
        try {
            this[start.x + search.x][start.y + search.y]
        } catch (e: Exception) {
            ' '
        }

    override fun firstPuzzleSolution(): String = countInputs(
        firstLetter = FIRST_LETTER,
        solution = SOLUTION_WORD,
        coordMap = coords,
    )

    override fun secondPuzzleSolution(): String = countInputs(
        firstLetter = FIRST_LETTER_SECOND,
        solution = SOLUTION_WORD_SECOND,
        coordMap = coordsSecondPuzzle,
    )

    private val coords = listOf(
        // right
        (0..3).map {
            Point(x = 0, y = it)
        },
        // left
        (0..3).map {
            Point(x = 0, y = -it)
        },
        // bottom
        (0..3).map {
            Point(x = it, y = 0)
        },
        // top
        (0..3).map {
            Point(x = -it, y = 0)
        },
        // diag top right
        (0..3).map {
            Point(x = -it, y = it)
        },
        // diag bottom left
        (0..3).map {
            Point(x = it, y = -it)
        },
        // diag top left
        (0..3).map {
            Point(x = -it, y = -it)
        },
        // diag bottom right
        (0 .. 3).map {
            Point(x = it, y = it)
        }
    )

    private val coordsSecondPuzzle = listOf(
        listOf(
            Point(x = -1, y = -1),
            Point(x = 0, y = 0),
            Point(x = 1, y = 1),
            Point(x = 1, y = -1),
            Point(x = 0, y = 0),
            Point(x = -1, y = 1),
        ),
        listOf(
            Point(x = -1, y = -1),
            Point(x = 0, y = 0),
            Point(x = 1, y = 1),
            Point(x = -1, y = 1),
            Point(x = 0, y = 0),
            Point(x = 1, y = -1),
        ),
        listOf(
            Point(x = -1, y = 1),
            Point(x = 0, y = 0),
            Point(x = 1, y = -1),
            Point(x = 1, y = 1),
            Point(x = 0, y = 0),
            Point(x = -1, y = -1),
        ),
        listOf(
            Point(x = 1, y = 1),
            Point(x = 0, y = 0),
            Point(x = -1, y = -1),
            Point(x = 1, y = -1),
            Point(x = 0, y = 0),
            Point(x = -1, y = 1),
        )
    )


    companion object {
        private const val SOLUTION_WORD = "XMAS"
        private const val FIRST_LETTER = 'X'
        private const val SOLUTION_WORD_SECOND = "MASMAS"
        private const val FIRST_LETTER_SECOND = 'A'
    }

}