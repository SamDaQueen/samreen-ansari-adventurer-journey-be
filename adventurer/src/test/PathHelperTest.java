package test;

import main.PathHelper;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PathHelperTest {

    static double[] origin;

    @BeforeAll
    static void setUp() {
        origin = new double[]{0, 0};
    }

    @Test
    @DisplayName("Parse empty path")
    void parseEmptyPath() {
        String path = "";
        double[] expected = {0, 0};
        Assertions.assertArrayEquals(expected, PathHelper.getFinalCoord(path));
    }

    @Test
    @DisplayName("Parse path with single step")
    void parseSingleStepPath() {
        String path = "15F";

        double[] expectedFinalCoord = {0, 15};
        double[] actualFinalCoord = PathHelper.getFinalCoord(path);
        assertArrayEquals(expectedFinalCoord, actualFinalCoord);

        double expectedDistance = 15;
        assertEquals(expectedDistance, PathHelper.calculateEuclideanDistance(origin, actualFinalCoord));
    }

    @Test
    @DisplayName("Parse path with single step and no distance")
    void parseSingleStepPathNoDistance() {
        String path = "F";
        double[] expectedFinalCoord = {0, 0};
        double[] actualFinalCoord = PathHelper.getFinalCoord(path);
        assertArrayEquals(expectedFinalCoord, actualFinalCoord);

        double expectedDistance = 0;
        assertEquals(expectedDistance, PathHelper.calculateEuclideanDistance(origin, actualFinalCoord));
    }

    @Test
    @DisplayName("Parse path with single step and no direction")
    void parseSingleStepPathNoDirection() {
        String path = "15";
        double[] expectedFinalCoord = {0, 0};
        double[] actualFinalCoord = PathHelper.getFinalCoord(path);
        assertArrayEquals(expectedFinalCoord, actualFinalCoord);

        double expectedDistance = 0;
        assertEquals(expectedDistance, PathHelper.calculateEuclideanDistance(origin, actualFinalCoord));
    }

    @Test
    @DisplayName("Parse path 2F3R4L")
    void parsePathTest1() {
        String path = "2F3R4L";
        double[] expectedFinalCoord = {3, 6};
        double[] actualFinalCoord = PathHelper.getFinalCoord(path);
        assertArrayEquals(expectedFinalCoord, actualFinalCoord);

        double expectedDistance = 6.708;
        assertEquals(expectedDistance, PathHelper.calculateEuclideanDistance(origin, actualFinalCoord), 0.001);
    }

    @Test
    @DisplayName("Parse path 5F2B1R3L")
    void parsePathTest2() {
        String path = "5F2B1R3L";
        double[] expectedFinalCoord = {-1, 0};
        double[] actualFinalCoord = PathHelper.getFinalCoord(path);
        assertArrayEquals(expectedFinalCoord, actualFinalCoord);


        double expectedDistance = 1;
        assertEquals(expectedDistance, PathHelper.calculateEuclideanDistance(origin, actualFinalCoord));
    }

    @Test
    @DisplayName("Parse path 3F3R3B3L")
    void parsePathTest3() {
        String path = "3F3R3B3L";
        double[] expectedFinalCoord = {0, 0};
        double[] actualFinalCoord = PathHelper.getFinalCoord(path);
        assertArrayEquals(expectedFinalCoord, actualFinalCoord);

        double expectedDistance = 0;
        assertEquals(expectedDistance, PathHelper.calculateEuclideanDistance(origin, actualFinalCoord));
    }

    @Test
    @DisplayName("Parse path 2R3B4L")
    void parsePathTest4() {
        String path = "2R3B4L";
        double[] expectedFinalCoord = {-1, -4};
        double[] actualFinalCoord = PathHelper.getFinalCoord(path);
        assertArrayEquals(expectedFinalCoord, actualFinalCoord);

        double expectedDistance = 4.123;
        assertEquals(expectedDistance, PathHelper.calculateEuclideanDistance(origin, actualFinalCoord), 0.001);
    }

    @Test
    @DisplayName("Parse path with decimals 1.5F2.5R1.5L5.5B3.5R")
    void parsePathTest5() {
        String path = "1.5F2.5R1.5L5.5B3.5R";
        double[] expectedFinalCoord = {-1, -2.5};
        double[] actualFinalCoord = PathHelper.getFinalCoord(path);
        assertArrayEquals(expectedFinalCoord, actualFinalCoord);

        double expectedDistance = 2.692;
        assertEquals(expectedDistance, PathHelper.calculateEuclideanDistance(origin, actualFinalCoord), 0.001);
    }

    @Test
    @DisplayName("Parse path with multiple steps")
    void parseMultipleSteps() {
        String path = "15F6B6B5L16R8B16F20L6F13F11R";
        double[] expectedFinalCoord = {34, -4};
        double[] actualFinalCoord = PathHelper.getFinalCoord(path);
        assertArrayEquals(expectedFinalCoord, actualFinalCoord);

        double expectedDistance = 34.234;
        assertEquals(expectedDistance, PathHelper.calculateEuclideanDistance(origin, actualFinalCoord), 0.001);

    }
}