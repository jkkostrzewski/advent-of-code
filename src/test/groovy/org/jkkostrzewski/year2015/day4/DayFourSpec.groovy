package org.jkkostrzewski.year2015.day4

import spock.lang.Specification

import static org.jkkostrzewski.year2015.day4.DayFour.partOne

class DayFourSpec extends Specification {
    def "partOneSpec"(String input, String output) {
        expect:
        partOne(input) == output

        where:
        input     | output
        "abcdef"  | "000001dbbfa3a5c83a2d506429c7b00e"
        "pqrstuv" | "000006136ef2ff3b291c85725f17325c"
    }

    def "partTwoSpec"(String input, int output) {
        //no examples for this part
    }
}
