package org.jkkostrzewski.year2015.day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DayThree {
    public static int partOne(final String input) {
        final Set<String> coordinates = new HashSet<>();

        //start at 0,0
        int x = 0;
        int y = 0;
        coordinates.add("0,0");

        for (int i = 0; i < input.length(); i++) {
            //save every new coordinate
            char nextMove = input.charAt(i);

            switch (nextMove) {
                case '>':
                    x++;
                    break;
                case '<':
                    x--;
                    break;
                case '^':
                    y++;
                    break;
                case 'v':
                    y--;
                    break;
            }

            coordinates.add(x + "," + y);
        }

        return coordinates.size();
    }

    public static int partTwo(final String input) {
        final Set<String> coordinates = new HashSet<>();

        //start at 0,0
        int santaX = 0;
        int santaY = 0;

        int robotSantaX = 0;
        int robotSantaY = 0;

        coordinates.add("0,0");

        for (int i = 0; i < input.length(); i++) {
            //save every new coordinate
            char nextMove = input.charAt(i);

            switch (nextMove) {
                case '>':
                    if (i % 2 == 0) santaX++;
                    else robotSantaX++;
                    break;
                case '<':
                    if (i % 2 == 0) santaX--;
                    else robotSantaX--;
                    break;
                case '^':
                    if (i % 2 == 0) santaY++;
                    else robotSantaY++;
                    break;
                case 'v':
                    if (i % 2 == 0) santaY--;
                    else robotSantaY--;
                    break;
            }

            coordinates.add(santaX + "," + santaY);
            coordinates.add(robotSantaX + "," + robotSantaY);
        }

        return coordinates.size();
    }


    public static void main(String[] args) throws FileNotFoundException {
        final Scanner fileInput = new Scanner(new File("src/main/java/org/jkkostrzewski/year2015/day3/input.txt"));
        final String input = fileInput.next(); //One liner on this day

        System.out.println(partOne(input));
        System.out.println(partTwo(input));
    }
}
