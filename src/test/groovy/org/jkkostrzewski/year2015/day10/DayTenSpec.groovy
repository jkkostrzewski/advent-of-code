package org.jkkostrzewski.year2015.day10

import spock.lang.Specification

import static org.jkkostrzewski.year2015.day10.DayTen.generateLookAndSay

class DayTenSpec extends Specification {
    def "generateLookAndSayReturnsCorrectOutputs"(String input, String output) {
        expect:
        generateLookAndSay(input) == output

        where:
        input    | output
        "1"      | "11"
        "11"     | "21"
        "21"     | "1211"
        "1211"   | "111221"
        "111221" | "312211"
    }
}
