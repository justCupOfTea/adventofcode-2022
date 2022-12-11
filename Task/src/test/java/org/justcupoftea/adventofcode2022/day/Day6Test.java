package org.justcupoftea.adventofcode2022.day;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Day6Test {
    private final Day6 day6 = new Day6();

    @Test
    void findIndex() {
        String data = "bvwbjplbgvbhsrlpgdmjqwftvncz";
        int size = 4;
        int actual = day6.findIndex(data, size);
        int expected = 5;
        Assertions.assertEquals(expected, actual);
        size = 14;
        expected = 23;
        actual = day6.findIndex(data, size);
        Assertions.assertEquals(expected, actual);

        size = 4;
        data = "nppdvjthqldpwncqszvftbrmjlhg";
        actual = day6.findIndex(data, size);
        expected = 6;
        Assertions.assertEquals(expected, actual);
        size = 14;
        expected = 23;
        actual = day6.findIndex(data, size);
        Assertions.assertEquals(expected, actual);

        size = 4;
        data = "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg";
        actual = day6.findIndex(data, size);
        expected = 10;
        Assertions.assertEquals(expected, actual);
        size = 14;
        expected = 29;
        actual = day6.findIndex(data, size);
        Assertions.assertEquals(expected, actual);

        size = 4;
        data = "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw";
        actual = day6.findIndex(data, size);
        expected = 11;
        Assertions.assertEquals(expected, actual);
        size = 14;
        expected = 26;
        actual = day6.findIndex(data, size);
        Assertions.assertEquals(expected, actual);
    }

}
