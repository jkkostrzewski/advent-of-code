package org.jkkostrzewski.year2015.day11;

import java.util.Set;

public class DayEleven {
    public static String partOne(final String input) {
        boolean includesThreeStraight = false;
        boolean firstOverlap = false;
        int firstOverlapIndex = 0;
        boolean secondOverlap = false;
        String currInput = input;
        final Set<Character> forbiddenCharacters = Set.of('i', 'o', 'l');

        while (!includesThreeStraight && !secondOverlap) {
            for (int i = 0; i < currInput.length(); i++) {
                if (i + 3 <= currInput.length()) {
                    char[] threeSub = currInput.substring(i, i + 3).toCharArray();
                    if (threeSub[0] == threeSub[1] - 1 && threeSub[0] == threeSub[2] - 2) {
                        includesThreeStraight = true;
                    }
                }

                if (forbiddenCharacters.contains(currInput.charAt(i))) {
                    currInput = currInput.substring(0, i) + ((char)(currInput.charAt(i) + 1)) + currInput.substring(i + 1);
                    break;
                }

                if (i + 1 < currInput.length()) {
                    if (currInput.charAt(i) == currInput.charAt(i+1)) {
                        if (!firstOverlap) {
                            firstOverlap = true;
                            firstOverlapIndex = i;
                        } else if (i > firstOverlapIndex + 1) {
                            secondOverlap = true;
                        }
                    }
                }
            }

            if (includesThreeStraight && secondOverlap) {
                return currInput;
            } else {
                includesThreeStraight = false;
                firstOverlap = false;
                secondOverlap = false;

                int last = currInput.length() - 1;
                currInput = addLetterAtIndex(currInput, last);
            }
        }

        return currInput;
    }

    private static String addLetterAtIndex(final String currInput, int index) {
        if (currInput.charAt(index) != 'z') {
            return currInput.substring(0, index) + ((char)(currInput.charAt(index) + 1)) + currInput.substring(index + 1);
        } else {
            String newInput = currInput.substring(0, index) + 'a' + currInput.substring(index + 1);
            return addLetterAtIndex(newInput, index - 1);
        }
    }

    public static void main(String[] args) {
        final String input = "cqjxjnds";

        final String partOneResult = partOne(input);
        final String partTwoInput = addLetterAtIndex(partOneResult, partOneResult.length() - 1);

        System.out.println("Part one: " + partOneResult);
        System.out.println("Part two: " + partOne(partTwoInput));
    }
}
