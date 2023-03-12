package org.justcupoftea.adventofcode2022.day;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day15Test {
    private static final String data = """
            Sensor at x=2, y=18: closest beacon is at x=-2, y=15
            Sensor at x=9, y=16: closest beacon is at x=10, y=16
            Sensor at x=13, y=2: closest beacon is at x=15, y=3
            Sensor at x=12, y=14: closest beacon is at x=10, y=16
            Sensor at x=10, y=20: closest beacon is at x=10, y=16
            Sensor at x=14, y=17: closest beacon is at x=10, y=16
            Sensor at x=8, y=7: closest beacon is at x=2, y=10
            Sensor at x=2, y=0: closest beacon is at x=2, y=10
            Sensor at x=0, y=11: closest beacon is at x=2, y=10
            Sensor at x=20, y=14: closest beacon is at x=25, y=17
            Sensor at x=17, y=20: closest beacon is at x=21, y=22
            Sensor at x=16, y=7: closest beacon is at x=15, y=3
            Sensor at x=14, y=3: closest beacon is at x=15, y=3
            Sensor at x=20, y=1: closest beacon is at x=15, y=3
            """;
    private final Day15 day = new Day15();

    @Test
    void mapData() {
        List<Day15.SensorPoint> actual = day.mapData(data);
        List<Day15.SensorPoint> expected = new ArrayList<>() {{
            add(Day15.SensorPoint.of(List.of(2, 18, -2, 15)));
            add(Day15.SensorPoint.of(List.of(9, 16, 10, 16)));
            add(Day15.SensorPoint.of(List.of(13, 2, 15, 3)));
            add(Day15.SensorPoint.of(List.of(12, 14, 10, 16)));
            add(Day15.SensorPoint.of(List.of(10, 20, 10, 16)));
            add(Day15.SensorPoint.of(List.of(14, 17, 10, 16)));
            add(Day15.SensorPoint.of(List.of(8, 7, 2, 10)));
            add(Day15.SensorPoint.of(List.of(2, 0, 2, 10)));
            add(Day15.SensorPoint.of(List.of(0, 11, 2, 10)));
            add(Day15.SensorPoint.of(List.of(20, 14, 25, 17)));
            add(Day15.SensorPoint.of(List.of(17, 20, 21, 22)));
            add(Day15.SensorPoint.of(List.of(16, 7, 15, 3)));
            add(Day15.SensorPoint.of(List.of(14, 3, 15, 3)));
            add(Day15.SensorPoint.of(List.of(20, 1, 15, 3)));
        }};

        assertEquals(expected, actual);
    }

    @Test
    void getPartOneAnswer() {
    }

    @Test
    void getPartTwoAnswer() {
    }


}
