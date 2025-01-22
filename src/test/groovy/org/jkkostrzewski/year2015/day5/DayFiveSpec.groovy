package org.jkkostrzewski.year2015.day5

import spock.lang.Specification

import static org.jkkostrzewski.year2015.day5.DayFive.partOne
import static org.jkkostrzewski.year2015.day5.DayFive.partTwo

class DayFiveSpec extends Specification {
    def "partOneSpec"(String input, boolean output) {
        expect:
        partOne(input) == output

        where:
        input              | output
        "ugknbfddgicrmopn" | true
        "aaa"              | true
        "jchzalrnumimnmhp" | false
        "haegwjzuvuyypxyu" | false
        "dvszwmarrgswjxmb" | false
    }

    def "partTwoSpec"(String input, boolean output) {
        expect:
        partTwo(input) == output

        where:
        input              | output
        "qjhvhtzxzqqjkmpb" | true
        "xxyxx"            | true
        "uurcxstgmygtbstg" | false
        "ieodomkazucvgmuy" | false
        "aaaa"             | true
        "aaabcb"           | false
    }
}
