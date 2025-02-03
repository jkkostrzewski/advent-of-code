package org.jkkostrzewski.year2015.day9

import spock.lang.Specification

import static org.jkkostrzewski.year2015.day9.DayNine.partOne
import static org.jkkostrzewski.year2015.day9.DayNine.partTwo

class DayNineSpec extends Specification {
    def "partOneSpec"() {
        given:
        final List<DayNine.Route> routes = List.of(new DayNine.Route("London", "Dublin", 464),
                new DayNine.Route("London", "Belfast", 518),
                new DayNine.Route("Dublin", "Belfast", 141))

        expect:
        partOne(routes) == 605
    }

    def "partTwoSpec"() {
        given:
        final List<DayNine.Route> routes = List.of(new DayNine.Route("London", "Dublin", 464),
                new DayNine.Route("London", "Belfast", 518),
                new DayNine.Route("Dublin", "Belfast", 141))

        expect:
        partTwo(routes) == 982
    }
}
