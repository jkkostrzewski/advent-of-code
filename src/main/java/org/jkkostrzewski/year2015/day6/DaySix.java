package org.jkkostrzewski.year2015.day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DaySix {

    public static final int LIGHT_ARRAY_LENGTH = 1000;

    public static void partOne(final String input, boolean[][] lights) {
        final String[] commands = input.split(" ");

        if (commands[0].equals("turn")) {
            final String[] firstCoords = commands[2].split(",");
            int startX = Integer.parseInt(firstCoords[0]);
            int startY = Integer.parseInt(firstCoords[1]);

            final String[] secondCoords = commands[4].split(",");
            int endX = Integer.parseInt(secondCoords[0]);
            int endY = Integer.parseInt(secondCoords[1]);

            if (commands[1].equals("on")) {
                for (int i = startY; i <= endY; i++) {
                    for (int j = startX; j <= endX; j++) {
                        lights[i][j] = true;
                    }
                }
            }

            if (commands[1].equals("off")) {
                for (int i = startY; i <= endY; i++) {
                    for (int j = startX; j <= endX; j++) {
                        lights[i][j] = false;
                    }
                }
            }
        }

        if (commands[0].equals("toggle")) {
            final String[] firstCoords = commands[1].split(",");
            int startX = Integer.parseInt(firstCoords[0]);
            int startY = Integer.parseInt(firstCoords[1]);

            final String[] secondCoords = commands[3].split(",");
            int endX = Integer.parseInt(secondCoords[0]);
            int endY = Integer.parseInt(secondCoords[1]);

            for (int i = startY; i <= endY; i++) {
                for (int j = startX; j <= endX; j++) {
                    lights[i][j] = !lights[i][j];
                }
            }
        }
    }

    public static void partTwo(final String input, int[][] lights) {
        final String[] commands = input.split(" ");

        if (commands[0].equals("turn")) {
            final String[] firstCoords = commands[2].split(",");
            int startX = Integer.parseInt(firstCoords[0]);
            int startY = Integer.parseInt(firstCoords[1]);

            final String[] secondCoords = commands[4].split(",");
            int endX = Integer.parseInt(secondCoords[0]);
            int endY = Integer.parseInt(secondCoords[1]);

            if (commands[1].equals("on")) {
                for (int i = startY; i <= endY; i++) {
                    for (int j = startX; j <= endX; j++) {
                        lights[i][j]++;
                    }
                }
            }

            if (commands[1].equals("off")) {
                for (int i = startY; i <= endY; i++) {
                    for (int j = startX; j <= endX; j++) {
                        if (lights[i][j] > 0) lights[i][j]--;
                    }
                }
            }
        }

        if (commands[0].equals("toggle")) {
            final String[] firstCoords = commands[1].split(",");
            int startX = Integer.parseInt(firstCoords[0]);
            int startY = Integer.parseInt(firstCoords[1]);

            final String[] secondCoords = commands[3].split(",");
            int endX = Integer.parseInt(secondCoords[0]);
            int endY = Integer.parseInt(secondCoords[1]);

            for (int i = startY; i <= endY; i++) {
                for (int j = startX; j <= endX; j++) {
                    lights[i][j] += 2;
                }
            }
        }
    }


    public static void main(String[] args) throws FileNotFoundException {
        boolean[][] lights = new boolean[LIGHT_ARRAY_LENGTH][LIGHT_ARRAY_LENGTH];

        Scanner fileInput = new Scanner(new File("src/main/java/org/jkkostrzewski/year2015/day6/input.txt"));
        int part1Result = 0;
        while (fileInput.hasNext()) {
            final String input = fileInput.nextLine();
            partOne(input, lights);
        }

        for (int i = 0; i < LIGHT_ARRAY_LENGTH; i++) {
            for (int j = 0; j < LIGHT_ARRAY_LENGTH; j++) {
                if (lights[i][j]) part1Result++;
            }
        }
        System.out.println(part1Result);

        fileInput.close();
        fileInput = new Scanner(new File("src/main/java/org/jkkostrzewski/year2015/day6/input.txt"));

        int[][] lightsBrightness = new int[LIGHT_ARRAY_LENGTH][LIGHT_ARRAY_LENGTH];

        int part2Result = 0;
        while (fileInput.hasNext()) {
            final String input = fileInput.nextLine();
            partTwo(input, lightsBrightness);
        }

        for (int i = 0; i < LIGHT_ARRAY_LENGTH; i++) {
            for (int j = 0; j < LIGHT_ARRAY_LENGTH; j++) {
                part2Result += lightsBrightness[i][j];
            }
        }
        System.out.println(part2Result);
        fileInput.close();
    }
}
