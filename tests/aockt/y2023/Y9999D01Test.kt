package aockt.y2023

import io.github.jadarma.aockt.test.AdventDay
import io.github.jadarma.aockt.test.AdventSpec
import io.kotest.matchers.shouldBe

/**
 * A test for Day 1 : Trebuchet?!
 *
 * ```text
 *
 * Part 1: Return the sum of digits composed with first found digit and last found digit.
 * Part 2: Return the sum of digits composed with first found digit and last found digit. Word can be parsed as digit.
 * ```
 */
@AdventDay(2023, 1, "Magic Numbers")
class Y2023D01Test : AdventSpec<Y2023D01>({

    partOne {
        "1abc2" shouldOutput 12
        "pqr3stu8vwx" shouldOutput 38
        "a1b2c3d4e5f" shouldOutput 15
        "treb7uchet" shouldOutput 77
        listOf(
            "1abc2",
            "pqr3stu8vwx",
            "a1b2c3d4e5f",
            "treb7uchet"
        ).joinToString("\n") shouldOutput 142
    }

    partTwo {
        "two1nine" shouldOutput 29
        "eightwothree" shouldOutput 83
        "abcone2threexyz" shouldOutput 13
        "xtwone3four" shouldOutput 24
        "4nineeightseven2" shouldOutput 42
        "zoneight234" shouldOutput 14
        "7pqrstsixteen" shouldOutput 76
        listOf(
            "two1nine",
            "eightwothree",
            "abcone2threexyz",
            "xtwone3four",
            "4nineeightseven2",
            "zoneight234",
            "7pqrstsixteen"
        ).joinToString("\n") shouldOutput 281
    }

})
