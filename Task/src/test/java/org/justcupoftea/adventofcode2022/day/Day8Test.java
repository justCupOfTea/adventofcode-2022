package org.justcupoftea.adventofcode2022.day;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day8Test {

    private final Day8 day8 = new Day8();
    private final String data = """
            30373
            25512
            65332
            33549
            35390
            """;

    @Test
    void isVisible() {
        Integer[][] array = day8.mapData(data);
        assertTrue(day8.isVisible(array, 0, 0));
        assertTrue(day8.isVisible(array, 0, 1));
        assertTrue(day8.isVisible(array, 0, 2));
        assertTrue(day8.isVisible(array, 0, 3));
        assertTrue(day8.isVisible(array, 0, 4));


        assertTrue(day8.isVisible(array, 1, 0));

        assertTrue(day8.isVisible(array, 1, 1));
        assertTrue(day8.isVisible(array, 1, 2));
        assertFalse(day8.isVisible(array, 1, 3));

        assertTrue(day8.isVisible(array, 1, 4));


        assertTrue(day8.isVisible(array, 2, 0));

        assertTrue(day8.isVisible(array, 2, 1));
        assertFalse(day8.isVisible(array, 2, 2));
        assertTrue(day8.isVisible(array, 2, 3));

        assertTrue(day8.isVisible(array, 2, 4));


        assertTrue(day8.isVisible(array, 3, 0));

        assertFalse(day8.isVisible(array, 3, 1));
        assertTrue(day8.isVisible(array, 3, 2));
        assertFalse(day8.isVisible(array, 3, 3));

        assertTrue(day8.isVisible(array, 3, 4));


        assertTrue(day8.isVisible(array, 4, 0));
        assertTrue(day8.isVisible(array, 4, 1));
        assertTrue(day8.isVisible(array, 4, 2));
        assertTrue(day8.isVisible(array, 4, 3));
        assertTrue(day8.isVisible(array, 4, 4));
    }


    @Test
    void getScore() {
        Integer[][] integers = day8.mapData(data);
        Integer actual = day8.getScore(integers);
        Integer expected = 21;
        assertEquals(expected, actual);
    }

    @Test
    void getScore2() {
        Integer[][] integers = day8.mapData(data);
        Integer actual = day8.getScore2(integers);
        Integer expected = 8;
        assertEquals(expected, actual);
    }

    @Test
    void getXLeftScenicScore() {
        Integer[][] integers = day8.mapData(data);
        Integer actual = day8.getXLeftScenicScore(integers, 2, 1);
        Integer expected = 1;
        assertEquals(expected, actual);
        actual = day8.getXLeftScenicScore(integers, 2, 3);
        expected = 2;
        assertEquals(expected, actual);

        actual = day8.getXLeftScenicScore(integers, 2, 2);
        expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void getXRightScenicScore() {
        Integer[][] integers = day8.mapData(data);
        Integer actual = day8.getXRightScenicScore(integers, 2, 1);
        Integer expected = 2;
        assertEquals(expected, actual);
        actual = day8.getXRightScenicScore(integers, 2, 3);
        expected = 2;
        assertEquals(expected, actual);

        actual = day8.getXRightScenicScore(integers, 2, 2);
        expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void getYUpScenicScore() {
        Integer[][] integers = day8.mapData(data);
        Integer actual = day8.getYUpScenicScore(integers, 2, 1);
        Integer expected = 1;
        assertEquals(expected, actual);
        actual = day8.getYUpScenicScore(integers, 2, 3);
        expected = 2;
        assertEquals(expected, actual);

        actual = day8.getYUpScenicScore(integers, 2, 2);
        expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void getYDownScenicScore() {
        Integer[][] integers = day8.mapData(data);
        Integer actual = day8.getYDownScenicScore(integers, 2, 1);
        Integer expected = 2;
        assertEquals(expected, actual);
        actual = day8.getYDownScenicScore(integers, 2, 3);
        expected = 1;
        assertEquals(expected, actual);

        actual = day8.getYDownScenicScore(integers, 2, 2);
        expected = 1;
        assertEquals(expected, actual);
    }
}
