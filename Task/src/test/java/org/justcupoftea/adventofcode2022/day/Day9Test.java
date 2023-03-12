package org.justcupoftea.adventofcode2022.day;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day9Test {

    private static final String data = """
            R 4
            U 4
            L 3
            D 1
            R 4
            D 1
            L 5
            R 2
            """;
    private final Day9 day = new Day9();

    @Test
    void mapData() {
        AtomicInteger count = new AtomicInteger();
        List<Day9.Motion> actual = day.mapData(data);
        ArrayList<Object> expected = new ArrayList<>() {{
            add(Day9.Motion.of(List.of("R", "4")));
            add(Day9.Motion.of(List.of("U", "4")));
            add(Day9.Motion.of(List.of("L", "3")));
            add(Day9.Motion.of(List.of("D", "1")));
            add(Day9.Motion.of(List.of("R", "4")));
            add(Day9.Motion.of(List.of("D", "1")));
            add(Day9.Motion.of(List.of("L", "5")));
            add(Day9.Motion.of(List.of("R", "2")));
        }};
        assertEquals(expected, actual);
    }

    @Test
    void getPartOneAnswer() {
        LinkedList<Day9.Motion> linkedList = new LinkedList<>(day.mapData(data));
        linkedList.stream().forEach(System.out::println);
        ListIterator<Day9.Motion> it = linkedList.listIterator();
        int i = 1;
        for (Day9.Motion next = (it.hasNext() ? it.next() : null), current = null; next != null; i++) {
            Day9.Motion previous = current;
            current = next;
            next = it.hasNext() ? it.next() : null;
            System.out.printf("%s\t %s\t%s\t%s%n", i, previous, current, next);
        }


    }

    @Test
    void getPartTwoAnswer() {
    }
}
