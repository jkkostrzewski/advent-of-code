package org.jkkostrzewski.year2015.day11

import spock.lang.Specification

import static org.jkkostrzewski.year2015.day11.DayEleven.partOne

class DayElevenSpec extends Specification {
    def "partOneSpec"(String input, String output) {
        expect:
        partOne(input) == output

        where:
        input      | output
        "abcdefgh" | "abcdffaa"
    }
}
