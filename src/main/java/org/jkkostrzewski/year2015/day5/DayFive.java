package org.jkkostrzewski.year2015.day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

public class DayFive {
    public static boolean partOne(final String input) {
        int vowelCount = 0;
        final Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

        boolean doubleLetter = false;
        char previousLetter = ' ';

        final Set<String> forbiddenStrings = Set.of("ab", "cd", "pq", "xy");
        boolean containsForbiddenString = false;

        for (int i = 0; i < input.length(); i++) {
            char currentLetter = input.charAt(i);

            if (vowels.contains(currentLetter)) {
                vowelCount++;
            }

            if (currentLetter == previousLetter) {
                doubleLetter = true;
            }

            if (forbiddenStrings.contains(String.valueOf(previousLetter) + currentLetter)) {
                containsForbiddenString = true;
            }
            previousLetter = currentLetter;
        }

        return (vowelCount >= 3) && doubleLetter && !containsForbiddenString;
    }

    public static boolean partTwo(final String input) {
        boolean letterPair = false;
        boolean letterPairWithOneBetween = false;
        final Predicate<Integer> isCurrentAndThirdSame = (i) -> i+2 < input.length() && input.charAt(i) == input.charAt(i+2);
        final Function<Integer, Integer> numberOfRepeatedCharacters = (i) -> {
            int count = 1;
            char characterToCheck = input.charAt(i);
            i++;
            while (i < input.length()) {
                if (input.charAt(i) != characterToCheck) return count;
                if (input.charAt(i) == characterToCheck) count++;
                i++;
            }

            return count;
        };
        final Set<String> letterPairs = new HashSet<>();

        for (int i = 0; i < input.length() - 1; i++) {
            char currentLetter = input.charAt(i);
            char nextLetter = input.charAt(i+1);
            String pair = String.valueOf(currentLetter) + nextLetter;

            if (currentLetter != nextLetter || numberOfRepeatedCharacters.apply(i) % 2 == 0) {
                if (!letterPairs.contains(pair)) letterPairs.add(pair);
                else letterPair = true;
            }

            if (isCurrentAndThirdSame.test(i)) letterPairWithOneBetween = true;
        }

        return letterPair && letterPairWithOneBetween;
    }


    public static void main(String[] args) throws FileNotFoundException {
        Scanner fileInput = new Scanner(new File("src/main/java/org/jkkostrzewski/year2015/day5/input.txt"));
        int part1Result = 0;
        while (fileInput.hasNext()) {
            final String input = fileInput.next();
            if (partOne(input)) part1Result++;
        }
        System.out.println(part1Result);

        fileInput.close();
        fileInput = new Scanner(new File("src/main/java/org/jkkostrzewski/year2015/day5/input.txt"));

        int part2Result = 0;
        while (fileInput.hasNext()) {
            final String input = fileInput.next();
            if (partTwo(input)) part2Result++;
        }
        System.out.println(part2Result);
        fileInput.close();
    }
}
