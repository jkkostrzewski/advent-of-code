package org.jkkostrzewski.year2015.day8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DayEight {
    public static int[] partOne(final String literal) {
        int stringChars = 0;
        final String noOutBrackets = literal.substring(1, literal.length() - 1);

        int i = 0;
        while (i < noOutBrackets.length()) {
            if (noOutBrackets.charAt(i) != '\\') {
                stringChars++;
                i++;
                continue;
            }

            String currSub = noOutBrackets.substring(i, i + 2);
            if (currSub.equals("\\\\") || currSub.equals("\\\"")) {
                stringChars++;
                i += 2;
            } else if (currSub.equals("\\x")) {
                stringChars++;
                i += 4;
            } else {
                i++;
            }


        }

        return new int[]{ literal.length(), stringChars };
    }

    public static int[] partTwo(final String literal) {
        int newCodeChars = 6;
        final String noOutBrackets = literal.substring(1, literal.length() - 1);

        int i = 0;
        while (i < noOutBrackets.length()) {
            if (noOutBrackets.charAt(i) != '\\') {
                newCodeChars++;
                i++;
                continue;
            }

            String currSub = noOutBrackets.substring(i, i + 2);
            if (currSub.equals("\\\\") || currSub.equals("\\\"")) {
                newCodeChars+=4;
                i += 2;
            } else if (currSub.equals("\\x")) {
                newCodeChars+=5;
                i += 4;
            } else {
                i++;
            }


        }

        return new int[]{ newCodeChars, literal.length() };
    }

    public static void main(String[] args) throws FileNotFoundException {
        int codeChars = 0;
        int stringChars = 0;

        Scanner fileInput = new Scanner(new File("src/main/java/org/jkkostrzewski/year2015/day8/input.txt"));
        while (fileInput.hasNext()) {
            final String input = fileInput.nextLine();
            final int[] partOneResult = partOne(input);
            codeChars += partOneResult[0];
            stringChars += partOneResult[1];
        }

        System.out.println("codeChars: " + codeChars);
        System.out.println("stringChars: " + stringChars);
        System.out.println("partOneResult: " + (codeChars - stringChars));
        fileInput.close();

        int newCodeChars = 0;
        int oldCodeChars = 0;

        fileInput = new Scanner(new File("src/main/java/org/jkkostrzewski/year2015/day8/input.txt"));
        while (fileInput.hasNext()) {
            final String input = fileInput.nextLine();
            final int[] partTwoResult = partTwo(input);
            newCodeChars += partTwoResult[0];
            oldCodeChars += partTwoResult[1];
        }

        System.out.println();
        System.out.println("newCodeChars: " + newCodeChars);
        System.out.println("oldCodeChars: " + oldCodeChars);
        System.out.println("partTwoResult: " + (newCodeChars - oldCodeChars));
        fileInput.close();

    }
}
