package org.justcupoftea.adventofcode2022.day;

import org.justcupoftea.adventofcode2022.task.AbstractTask;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class Day1 extends AbstractTask<Integer> {


    public Day1() {
        super(1);
    }

    @Override
    protected List<Integer> mapData(String data) {
        return Arrays.stream(data.split("\n\n"))
                .map(s -> Arrays.stream(s.split("\n"))
                        .map(Integer::parseInt)
                        .reduce(0, Integer::sum))
                .sorted(Comparator.reverseOrder())
                .toList();
    }

    @Override
    protected String getPartOneAnswer(List<Integer> data) {
        return String.valueOf(data.get(0));
    }

    @Override
    protected String getPartTwoAnswer(List<Integer> data) {
        return data.stream().limit(3).reduce(0, Integer::sum).toString();
    }
}
