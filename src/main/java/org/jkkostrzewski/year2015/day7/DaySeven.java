package org.jkkostrzewski.year2015.day7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DaySeven {
    public static boolean isNumber(final String number) {
        for (int i = 0; i < number.length(); i++) {
            if (!Character.isDigit(number.charAt(i))) return false;
        }

        return true;
    }

    public static int partOne(final String wire, Map<String, String> variables) {
        if (isNumber(wire)) return Integer.parseInt(wire);

        if (variables.containsKey(wire) && isNumber(variables.get(wire))) return Integer.parseInt(variables.get(wire));

        final String wireLeft = variables.get(wire)
                .split(" -> ")[0];

        if (isNumber(wireLeft)) {
            variables.put(wire, wireLeft);
            return Integer.parseInt(wireLeft);
        }

        final String[] leftOp = wireLeft.split(" ");

        if (leftOp.length == 1) {
            return partOne(wireLeft, variables);
        }

        if (wireLeft.startsWith("NOT")) {
            return 65535 - partOne(wireLeft.substring(wireLeft.indexOf(" ") + 1), variables);
        } else {
            int result = 0;
            switch (leftOp[1]) {
                case "AND":
                    result = (partOne(leftOp[0], variables) & partOne(leftOp[2], variables));
                    variables.put(wire, String.valueOf(result));
                    return result;
                case "OR":
                    result = (partOne(leftOp[0], variables) | partOne(leftOp[2], variables));
                    variables.put(wire, String.valueOf(result));
                    return result;
                case "LSHIFT":
                    result = (partOne(leftOp[0], variables) << partOne(leftOp[2], variables));
                    variables.put(wire, String.valueOf(result));
                    return result;
                case "RSHIFT":
                    result = (partOne(leftOp[0], variables) >> partOne(leftOp[2], variables));
                    variables.put(wire, String.valueOf(result));
                    return result;
            }
        }

        return 0;
    }

    public static void partTwo() {
        //Same code as partOne with different input
    }

    public static void main(String[] args) throws FileNotFoundException {
        final String lookedVar = "a";
        final Map<String, String> variables = new HashMap<>();

        Scanner fileInput = new Scanner(new File("src/main/java/org/jkkostrzewski/year2015/day7/input.txt"));
        while (fileInput.hasNext()) {
            final String input = fileInput.nextLine();
            final String[] operations = input.split(" -> ");
            variables.put(operations[1], operations[0]);
        }

        final int partOneResult = partOne(lookedVar, variables);
        System.out.println(partOneResult);
        fileInput.close();

        variables.clear();
        fileInput = new Scanner(new File("src/main/java/org/jkkostrzewski/year2015/day7/input.txt"));
        while (fileInput.hasNext()) {
            final String input = fileInput.nextLine();
            final String[] operations = input.split(" -> ");
            variables.put(operations[1], operations[0]);
        }

        variables.put("b", String.valueOf(partOneResult));
        final int partTwoResult = partOne(lookedVar, variables);
        System.out.println(partTwoResult);
        fileInput.close();
    }
}
