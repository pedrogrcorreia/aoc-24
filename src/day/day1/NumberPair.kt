package day.day1

import kotlin.math.abs

data class NumberPair(
    val leftNumber: Int,
    val rightNumber: Int,
    val difference: Int = abs(leftNumber - rightNumber),
)