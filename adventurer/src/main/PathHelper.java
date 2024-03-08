package main;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.*;

public class PathHelper {

    public static double calculateEuclideanDistance(double[] start, double[] end) {
        return Math.sqrt((end[0] - start[0])*(end[0] - start[0]) + (end[1] - start[1])* (end[1] - start[1]));
    }

    public static double[] getFinalCoord(String path) {

        double[] finalCoord = new double[]{0, 0};

        // Return origin if path is empty
        if (path == null || path.isEmpty()) {
            return finalCoord;
        }

        // Create a RegEx pattern to extract a step (distance and direction)
        Pattern pattern = Pattern.compile("(\\d+(\\.\\d*)?)([A-Za-z])"); // number/decimal followed by a letter
        Matcher matcher = pattern.matcher(path);

        // Current orientation of the adventurer (0 = East, 90 = North, 180 = West, 270 = South)
        int orientation = 90;
        Map<Character, Integer> directionToAngle = new HashMap<>();
        directionToAngle.put('F', 0);
        directionToAngle.put('L', 90);
        directionToAngle.put('R', -90);
        directionToAngle.put('B', 180);

        while (matcher.find()) {
            double distance = Double.parseDouble(matcher.group(1));
            char direction = matcher.group(3).charAt(0);
            int angle = directionToAngle.getOrDefault(direction, 0);
            orientation = (orientation + angle) % 360;
            finalCoord[0] += distance * (int) Math.cos(Math.toRadians(orientation));
            finalCoord[1] += distance * (int) Math.sin(Math.toRadians(orientation));
        }
        return finalCoord;
    }

}
