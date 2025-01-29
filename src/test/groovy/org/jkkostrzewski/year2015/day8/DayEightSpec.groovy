package org.jkkostrzewski.year2015.day8

import spock.lang.Specification

import static org.jkkostrzewski.year2015.day8.DayEight.partOne
import static org.jkkostrzewski.year2015.day8.DayEight.partTwo

class DayEightSpec extends Specification {
    def "partOneSpec"(String input, int codeChars, int stringChars) {
        given:
        var result = partOne(input)

        expect:
        result[0] == codeChars
        result[1] == stringChars

        where:
        input            | codeChars | stringChars
        "\"\""           | 2         | 0
        "\"abc\""        | 5         | 3
        "\"aaa\\\"aaa\"" | 10        | 7
        "\"\\x27\""      | 6         | 1
    }

    def "partTwoSpec"(String input, int newCodeChars, int codeChars) {
        given:
        var result = partTwo(input)

        expect:
        result[0] == newCodeChars
        result[1] == codeChars

        where:
        input            | newCodeChars | codeChars
        "\"\""           | 6            | 2
        "\"abc\""        | 9            | 5
        "\"aaa\\\"aaa\"" | 16           | 10
        "\"\\x27\""      | 11           | 6
    }
}
