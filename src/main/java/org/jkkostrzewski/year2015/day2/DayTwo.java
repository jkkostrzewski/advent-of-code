package org.jkkostrzewski.year2015.day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class DayTwo {
    public static int partOne(final String input) {
        final String[] dimensions = input.split("x");
        int length = Integer.parseInt(dimensions[0]);
        int width = Integer.parseInt(dimensions[1]);
        int height = Integer.parseInt(dimensions[2]);

        int lengthWidth = length * width;
        int widthHeight = width * height;
        int heightLength = height * length;

        int slack = Stream.of(lengthWidth, widthHeight, heightLength).min(Integer::compareTo).get();

        return 2 * lengthWidth + 2 * widthHeight + 2 * heightLength + slack;
    }

    public static int partTwo(final String input) {
        final String[] dimensions = input.split("x");
        int[] dimensionsInt = Arrays.stream(dimensions).mapToInt(Integer::parseInt).sorted().toArray();

        int ribbonWrap = dimensionsInt[0] + dimensionsInt[0] + dimensionsInt[1] + dimensionsInt[1];
        int ribbonBow = Arrays.stream(dimensionsInt).reduce(1, (subtotal, element) -> subtotal * element);
        return ribbonWrap + ribbonBow;
    }


    public static void main(String[] args) throws FileNotFoundException {
        Scanner fileInput = new Scanner(new File("src/main/java/org/jkkostrzewski/year2015/day2/input.txt"));
        int part1Result = 0;
        while (fileInput.hasNext()) {
            final String input = fileInput.next();
            part1Result += partOne(input);
        }
        System.out.println(part1Result);

        fileInput.close();
        fileInput = new Scanner(new File("src/main/java/org/jkkostrzewski/year2015/day2/input.txt"));

        int part2Result = 0;
        while (fileInput.hasNext()) {
            final String input = fileInput.next();
            part2Result += partTwo(input);
        }
        System.out.println(part2Result);
        fileInput.close();
    }
}