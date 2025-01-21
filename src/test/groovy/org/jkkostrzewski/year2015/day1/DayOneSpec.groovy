package org.jkkostrzewski.year2015.day1

import spock.lang.Specification

import static org.jkkostrzewski.year2015.day1.DayOne.calculateBasementEntrance
import static org.jkkostrzewski.year2015.day1.DayOne.calculateFloor

class DayOneSpec extends Specification {
    def "calculateFloorForInput"(String input, int output) {
        expect:
        calculateFloor(input) == output

        where:
        input     | output
        "(())"    | 0
        "()()"    | 0
        "((("     | 3
        "(()(()(" | 3
        "))(((((" | 3
        "())"     | -1
        "))("     | -1
        ")))"     | -3
        ")())())" | -3
    }

    def "calculateBasementEntranceForInput"(String input, int output) {
        expect:
        calculateBasementEntrance(input) == output

        where:
        input   | output
        ")"     | 1
        "()())" | 5
    }
}
