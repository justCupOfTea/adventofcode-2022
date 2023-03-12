package org.justcupoftea.adventofcode2022.day;

import lombok.NonNull;
import org.justcupoftea.adventofcode2022.task.AbstractTask;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Day9 extends AbstractTask<List<Day9.Motion>> {

    @Override
    protected List<Day9.Motion> mapData(@NonNull String data) {
        AtomicInteger count = new AtomicInteger();
        return Arrays.stream(data.split("\n"))
                .map(s -> s.split(" "))
                .flatMap(Arrays::stream)
                .collect(Collectors.groupingBy(i -> count.getAndIncrement() / 2))
                .values()
                .stream()
                .map(Day9.Motion::of)
                .toList();
    }

    @Override
    protected String getPartOneAnswer(@NonNull List<Day9.Motion> data) {
        LinkedList<Motion> linkedList = new LinkedList<>(data);
        ListIterator<Motion> it = linkedList.listIterator();
        int i = 1;
        for (Day9.Motion next = (it.hasNext() ? it.next() : null), current = null; next != null; i++) {
            Day9.Motion previous = current;
            current = next;
            next = it.hasNext() ? it.next() : null;
            System.out.printf("%s |%s|%s|%s%n", i, previous, current, next);
        }
        return "";
    }

    @Override
    protected String getPartTwoAnswer(@NonNull List<Day9.Motion> data) {
        return null;
    }

    public record Motion(int x, int y, int step) {
        public static Motion of(@NonNull List<String> list) {
            if (list.size() == 2) {
                int step = Integer.parseInt(list.get(1));
                return switch (list.get(0)) {
                    case "R" -> new Motion(1, 0, step);
                    case "L" -> new Motion(-1, 0, step);
                    case "U" -> new Motion(0, 1, step);
                    case "D" -> new Motion(0, -1, step);
                    default -> null;
                };
            } else {
                throw new RuntimeException("Не верный набор аргументов");
            }
        }
    }

    public class Node {
        private Motion motion;
        private Node next;
        private Node prev;
    }
}
