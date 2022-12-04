package org.justcupoftea.adventofcode2022.day;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

class Day3Test {
    private Day3 day = new Day3();

    @Test
    void separate() {
        String[] actual = day.separate("vJrwpWtwJgWrhcsFMMfFFhFp");
        String[] expected = {"vJrwpWtwJgWr", "hcsFMMfFFhFp"};
        Assertions.assertEquals(expected[0], actual[0]);
        Assertions.assertEquals(expected[1], actual[1]);
    }

    @Test
    void priority() {
        List<Integer> actual = IntStream.range(Day3.a, Day3.z + 1)
                .map(i -> day.priority((char) i))
                .boxed()
                .toList();

        List<Integer> expected = IntStream.range(Day3.start, Day3.end + 1)
                .boxed()
                .toList();
        Assertions.assertEquals(expected, actual);

        actual = IntStream.range(Day3.A, Day3.Z + 1)
                .map(i -> day.priority((char) i))
                .boxed()
                .toList();

        expected = IntStream.range(Day3.START, Day3.END + 1)
                .boxed()
                .toList();
        Assertions.assertEquals(expected, actual);

    }

    @Test
    void find() {
        String s = "vJrwpWtwJgWrhcsFMMfFFhFp";
        String[] separate = day.separate(s);
        char actual = day.find(separate[0], separate[1]);
        char expected = 'p';
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void find2() {
        String s1 = "vJrwpWtwJgWrhcsFMMfFFhFp";
        String s2 = "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL";
        String s3 = "PmmdzqPrVvPwwTWBwg";

        char actual = day.find(s1, s2, s3);
        char expected = 'r';
        Assertions.assertEquals(expected, actual);
    }
}
