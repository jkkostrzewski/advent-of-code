package org.jkkostrzewski.year2015.day2

import spock.lang.Specification

import static org.jkkostrzewski.year2015.day2.DayTwo.partOne
import static org.jkkostrzewski.year2015.day2.DayTwo.partTwo

class DayTwoSpec extends Specification {
    def "partOneSpec"(String input, int output) {
        expect:
        partOne(input) == output

        where:
        input    | output
        "2x3x4"  | 58
        "1x1x10" | 43
    }

    def "partTwoSpec"(String input, int output) {
        expect:
        partTwo(input) == output

        where:
        input    | output
        "2x3x4"  | 34
        "1x1x10" | 14
    }

}
