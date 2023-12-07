package aockt.y2023

import io.github.jadarma.aockt.core.Solution

/** A solution for Day 1: Trebuchet?! */
object Y2023D01 : Solution {

    private fun findFirstAndLastNumber(input: String): Int {
        val firstNumber = input.first {
            it.isDigit()
        }
        val lastNumber = input.last {
            it.isDigit()
        }
        return "$firstNumber$lastNumber".toInt()
    }

    override fun partOne(input: String): Int {
        val inputs = input.split("\n")
        val sum = inputs.fold(0) { total, numString ->
            total + findFirstAndLastNumber(numString)
        }
        println(sum)
        return sum
    }

    override fun partTwo(input: String): Int {
        val inputs = input.split("\n")
        val sum = inputs.map { numStringWithWord ->
            val numberIndexInfo = mutableMapOf(
                Numbers.ONE to FoundIndex(),
                Numbers.TWO to FoundIndex(),
                Numbers.THREE to FoundIndex(),
                Numbers.FOUR to FoundIndex(),
                Numbers.FIVE to FoundIndex(),
                Numbers.SIX to FoundIndex(),
                Numbers.SEVEN to FoundIndex(),
                Numbers.EIGHT to FoundIndex(),
                Numbers.NINE to FoundIndex(),
            )
            numberIndexInfo.forEach { (targetNumber, foundIndex) ->
                val firstWordIndex = numStringWithWord.indexOf(targetNumber.word)
                val lastWordIndex = numStringWithWord.lastIndexOf(targetNumber.word)
                val firstNumIndex = numStringWithWord.indexOf(targetNumber.value.toString())
                val lastNumIndex = numStringWithWord.lastIndexOf(targetNumber.value.toString())
                val firstIndex = when {
                    firstWordIndex >= 0 && firstNumIndex >= 0 -> if (firstWordIndex < firstNumIndex) {
                        firstWordIndex
                    } else {
                        firstNumIndex
                    }
                    firstWordIndex < 0 && firstNumIndex >= 0 -> firstNumIndex
                    firstWordIndex >= 0 && firstNumIndex < 0 -> firstWordIndex
                    else -> -1
                }
                val lastIndex = when {
                    lastWordIndex >= 0 && lastNumIndex >= 0 -> if (lastWordIndex > lastNumIndex) {
                        lastWordIndex
                    } else {
                        lastNumIndex
                    }
                    lastWordIndex < 0 && lastNumIndex >= 0 -> lastNumIndex
                    lastWordIndex >= 0 && lastNumIndex < 0 -> lastWordIndex
                    else -> -1
                }
                numberIndexInfo[targetNumber] = FoundIndex(firstIndex, lastIndex)
            }

            val firstNumber = numberIndexInfo.filter {
                it.value.firstIndex >= 0
            }.minBy {
                it.value.firstIndex
            }.key.value

            val lastNumber = numberIndexInfo.filter {
                it.value.lastIndex >= 0
            }.maxBy {
                it.value.lastIndex
            }.key.value

            "$firstNumber$lastNumber".toInt()
        }.reduce { total, num ->
            total + num
        }
        println(inputs)
        println(sum)
        return sum
    }

    enum class Numbers(val word: String, val value: Int) {
        ONE("one", 1),
        TWO("two", 2),
        THREE("three", 3),
        FOUR("four", 4),
        FIVE("five", 5),
        SIX("six", 6),
        SEVEN("seven", 7),
        EIGHT("eight", 8),
        NINE("nine", 9),
    }

    data class FoundIndex(val firstIndex: Int = -1, val lastIndex: Int = -1)
}
