package org.jkkostrzewski.year2015.day3

import spock.lang.Specification

import static org.jkkostrzewski.year2015.day3.DayThree.partOne
import static org.jkkostrzewski.year2015.day3.DayThree.partTwo

class DayThreeSpec extends Specification {
    def "partOneSpec"(String input, int output) {
        expect:
        partOne(input) == output

        where:
        input        | output
        ">"          | 2
        "^>v<"       | 4
        "^v^v^v^v^v" | 2
    }

    def "partTwoSpec"(String input, int output) {
        expect:
        partTwo(input) == output

        where:
        input        | output
        "^v"         | 3
        "^>v<"       | 3
        "^v^v^v^v^v" | 11
    }
}
