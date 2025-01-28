package org.jkkostrzewski.year2015.day7

import spock.lang.Specification

import static org.jkkostrzewski.year2015.day7.DaySeven.isNumber
import static org.jkkostrzewski.year2015.day7.DaySeven.partOne

class DaySevenSpec extends Specification {
    def "stringIsNumber"(String input, boolean output) {
        expect:
        isNumber(input) == output

        where:
        input        | output
        "123123"     | true
        "3546369087" | true
        "asd23adh"   | false
        "--23asf"    | false
        "++34234++"  | false
        "__asda342"  | false
        "09231"      | true
    }

    def "partOneSpec"(String input, int result) {
        given:
        final Map<String, String> variables = new HashMap<>(Map.of("x", "123",
                "y", "456",
                "d", "x AND y",
                "e", "x OR y",
                "f", "x LSHIFT 2",
                "g", "y RSHIFT 2",
                "h", "NOT x",
                "i", "NOT y"))

        expect:
        partOne(input, variables) == result

        where:
        input | result
        "d"   | 72
        "e"   | 507
        "f"   | 492
        "g"   | 114
        "h"   | 65412
        "i"   | 65079
        "x"   | 123
        "y"   | 456
    }

    def "partTwoSpec"(String input, boolean output) {
        //same
    }
}
