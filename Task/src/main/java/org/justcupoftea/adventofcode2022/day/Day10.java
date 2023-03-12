package org.justcupoftea.adventofcode2022.day;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.justcupoftea.adventofcode2022.task.AbstractTask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Slf4j
public class Day10 extends AbstractTask<List<String[]>> {

    @Override
    protected List<String[]> mapData(@NonNull String data) {

        return Arrays.stream(data.split("\n"))
                .map(s -> s.trim().split(" "))
                .toList();
    }

    @Override
    protected String getPartOneAnswer(@NonNull List<String[]> data) {
        int sumPower = 0;
        List<Integer> values = getValues(data);
        for (int i = 20; i <= 220; i = i + 40) {
            sumPower += values.get(i - 1) * i;
        }

        return String.valueOf(sumPower);
    }

    private List<Integer> getValues(List<String[]> data) {
        int x = 1;
        List<Integer> values = new ArrayList<>();
        for (String[] array : data) {
            switch (array[0]) {
                case "noop" -> values.add(x);
                case "addx" -> {
                    values.add(x);
                    values.add(x);
                    x += Integer.parseInt(array[1]);
                }
                default -> throw new RuntimeException("Не известная команда");
            }
        }
        return values;
    }

    @Override
    protected String getPartTwoAnswer(@NonNull List<String[]> data) {
        List<Integer> values = getValues(data);
        Iterator<Integer> iterator = values.iterator();
        StringBuilder sb = new StringBuilder("\n");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 40; j++) {
                var next = iterator.next();
                if (next - 1 <= j && j <= next + 1) {
                    sb.append("#");
                } else {
                    sb.append(".");
                }
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
