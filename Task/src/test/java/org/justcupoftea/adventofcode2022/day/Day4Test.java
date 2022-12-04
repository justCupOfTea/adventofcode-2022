package org.justcupoftea.adventofcode2022.day;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.justcupoftea.adventofcode2022.model.Pair;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Day4Test {
    private Day4 day = new Day4();
    private static final String data = """
            2-4,6-8
            2-3,4-5
            5-7,7-9
            2-8,3-7
            6-6,4-6
            2-6,4-8
            92-92,19-93
             """;

    private static List<Pair<Integer>> list = List.of(
            new Pair<>(2, 4), new Pair<>(6, 8)//--
            , new Pair<>(2, 3), new Pair<>(4, 5)//--
            , new Pair<>(5, 7), new Pair<>(7, 9)//-+
            , new Pair<>(2, 8), new Pair<>(3, 7)//++
            , new Pair<>(6, 6), new Pair<>(4, 6)//++
            , new Pair<>(2, 6), new Pair<>(4, 8)//-+
            , new Pair<>(92, 92), new Pair<>(19, 93)//++
    );
    private static int count = 3;
    private static int countCross = 5;

    @Test
    void mapData() {
        List<Pair<Integer>> actual = day.mapData(data);
        List<Pair<Integer>> expected = new ArrayList<>(list);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getPartOneAnswer() {
        List<Pair<Integer>> pairs = day.mapData(data);
        String actual = String.valueOf(day.getCount(pairs));
        String expected = String.valueOf(count);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getPartTwoAnswer() {
        List<Pair<Integer>> pairs = day.mapData(data);
        String actual = String.valueOf(day.getCrossCount(pairs));
        String expected = String.valueOf(countCross);

        Assertions.assertEquals(expected, actual);

    }


    @Test
    void isContain(){
        boolean isContains;
        isContains = day.contains(new Pair<>(1, 1), new Pair<>(4, 4));
        Assertions.assertFalse(isContains);
        isContains = day.contains(new Pair<>(4, 4), new Pair<>(1, 3));
        Assertions.assertFalse(isContains);
        isContains = day.contains(new Pair<>(3, 4), new Pair<>(1, 3));
        Assertions.assertFalse(isContains);


        isContains = day.contains(new Pair<>(4, 6), new Pair<>(4, 4));
        Assertions.assertTrue(isContains);
        isContains = day.contains(new Pair<>(4, 6), new Pair<>(6, 6));
        Assertions.assertTrue(isContains);
        isContains = day.contains(new Pair<>(1, 6), new Pair<>(1, 4));
        Assertions.assertTrue(isContains);
        isContains = day.contains(new Pair<>(1, 4), new Pair<>(1, 6));
        Assertions.assertTrue(isContains);
        isContains = day.contains(new Pair<>(1, 6), new Pair<>(4, 6));
        Assertions.assertTrue(isContains);
        isContains = day.contains(new Pair<>(4, 6), new Pair<>(1, 6));
        Assertions.assertTrue(isContains);
        isContains = day.contains(new Pair<>(4, 5), new Pair<>(1, 6));
        Assertions.assertTrue(isContains);
        isContains = day.contains(new Pair<>(1, 6), new Pair<>(4, 5));
        Assertions.assertTrue(isContains);
    }

    @Test
    void isCross() {
        boolean isCross;
        isCross = day.isCross(new Pair<>(1, 1), new Pair<>(4, 4));
        Assertions.assertFalse(isCross);
        isCross = day.isCross(new Pair<>(4, 4), new Pair<>(1, 3));
        Assertions.assertFalse(isCross);


        isCross = day.isCross(new Pair<>(4, 6), new Pair<>(1, 4));
        Assertions.assertTrue(isCross);
        isCross = day.isCross(new Pair<>(4, 4), new Pair<>(1, 4));
        Assertions.assertTrue(isCross);
        isCross = day.isCross(new Pair<>(2, 3), new Pair<>(1, 4));
        Assertions.assertTrue(isCross);

    }
}
