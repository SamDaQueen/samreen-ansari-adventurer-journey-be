package main;

public class Main {
    public static void main(String[] args) {
        String path = args.length > 0 ? args[0] : "15F6B6B5L16R8B16F20L6F13F11R";
        double[] finalCoord = PathHelper.getFinalCoord(path);
        double distance = PathHelper.calculateEuclideanDistance(new double[]{0, 0}, finalCoord);
        System.out.println("Final coordinates: " + finalCoord[0] + ", " + finalCoord[1] + "\nDistance: " + distance);
    }
}