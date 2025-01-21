package org.jkkostrzewski.year2015.day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DayOne {
    public static int calculateFloor(final String input) {
        return input.chars().reduce(0, (subtotal, element) -> {
            if (element == '(') subtotal++;
            if (element == ')') subtotal--;
            return subtotal;
        });
    }

    public static int calculateBasementEntrance(final String input) {
        int floor = 0;
        for (int i = 0; i < input.length(); i++) {
            char move = input.charAt(i);
            if (move == '(') floor++;
            if (move == ')') floor--;

            if (floor == -1) return i + 1;
        }
        return 1;
    }

    public static void main(String[] args) throws FileNotFoundException {
        final Scanner fileInput = new Scanner(new File("src/main/java/org/jkkostrzewski/year2015/day1/input.txt"));
        final String input = fileInput.next(); //One liner on this day
        final int part1Result = calculateFloor(input);
        System.out.println(part1Result);

        final int part2Result = calculateBasementEntrance(input);
        System.out.println(part2Result);
    }
}