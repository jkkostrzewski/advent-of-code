package org.jkkostrzewski.year2015.day9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DayNine {
    record Route(String location, String destination, int distance) {}

    private static final List<List<String>> permutations = new ArrayList<>();

    public static int getRouteDistance(final String location, final String destination, final List<Route> routes) {
        return routes.stream()
                .filter(route -> (route.location().equals(location) || route.location().equals(destination))
                                        && (route.destination().equals(location) || route.destination().equals(destination)))
                .findFirst()
                .get()
                .distance();
    }

    private static void permutePossibleRoutes(int n, final List<String> locations) {
        if (n == 1) {
            permutations.add(List.copyOf(locations));
        }
        else {
            for(int i = 0; i < n; i++) {
                permutePossibleRoutes(n - 1, locations);
                if ( n % 2 == 0) {
                    String swap = locations.get(i);
                    locations.set(i, locations.get(n - 1));
                    locations.set(n - 1, swap);
                }
                else {
                    String swap = locations.get(0);
                    locations.set(0, locations.get(n - 1));
                    locations.set(n - 1, swap);
                }
            }
        }
    }

    public static int partOne(final List<Route> routes) {
        final List<String> distLocations = routes.stream()
                .flatMap(route -> Stream.of(route.location(), route.destination()))
                .distinct()
                .collect(Collectors.toList());

        permutePossibleRoutes(distLocations.size(), distLocations);
        int minimalDistanceRoute = Integer.MAX_VALUE;

        for (List<String> fullRoute : permutations) {
            int currentDistance = 0;
            for (int i = 0; i < fullRoute.size() - 1; i++) {
                currentDistance += getRouteDistance(fullRoute.get(i), fullRoute.get(i + 1), routes);
            }

            if (currentDistance < minimalDistanceRoute) minimalDistanceRoute = currentDistance;
        }

        return minimalDistanceRoute;
    }

    public static int partTwo(final List<Route> routes) {
        final List<String> distLocations = routes.stream()
                .flatMap(route -> Stream.of(route.location(), route.destination()))
                .distinct()
                .collect(Collectors.toList());

        permutePossibleRoutes(distLocations.size(), distLocations);
        int maximalDistanceRoute = Integer.MIN_VALUE;

        for (List<String> fullRoute : permutations) {
            int currentDistance = 0;
            for (int i = 0; i < fullRoute.size() - 1; i++) {
                currentDistance += getRouteDistance(fullRoute.get(i), fullRoute.get(i + 1), routes);
            }

            if (currentDistance > maximalDistanceRoute) maximalDistanceRoute = currentDistance;
        }

        return maximalDistanceRoute;
    }

    public static void main(String[] args) throws FileNotFoundException {
        List<Route> routes = new ArrayList<>();
        Scanner fileInput = new Scanner(new File("src/main/java/org/jkkostrzewski/year2015/day9/input.txt"));
        while (fileInput.hasNext()) {
            final String input = fileInput.nextLine();
            final String[] split = input.split(" ");

            routes.add(new Route(split[0], split[2], Integer.parseInt(split[4])));
        }

        System.out.println("Part one: " + partOne(routes));

        fileInput.close();

        System.out.println("Part two: " + partTwo(routes));
    }
}
