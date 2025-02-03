package org.jkkostrzewski.year2015.day10;

public class DayTen {
    public static String generateLookAndSay(String currInput) {
        int i = 0;
        char currNumber = currInput.charAt(0);
        int occurrences = 0;
        final StringBuilder result = new StringBuilder();

        while (i < currInput.length()) {
            if (currNumber == currInput.charAt(i)) {
                occurrences++;
            } else {
                result.append(occurrences).append(currNumber);
                currNumber = currInput.charAt(i);
                occurrences = 1;
            }
            i++;
        }
        result.append(occurrences).append(currNumber);
        return result.toString();
    }

    public static int partOne(final String input) {
        String currInput = input;
        for (int i = 0; i < 40; i++) {
            currInput = generateLookAndSay(currInput);
        }
        return currInput.length();
    }

    public static int partTwo(final String input) {
        String currInput = input;
        for (int i = 0; i < 50; i++) {
            currInput = generateLookAndSay(currInput);
        }
        return currInput.length();
    }

    public static void main(String[] args) {
        final String input = "1321131112";

        System.out.println("Part one: " + partOne(input));
        System.out.println("Part two: " + partTwo(input));
    }
}
