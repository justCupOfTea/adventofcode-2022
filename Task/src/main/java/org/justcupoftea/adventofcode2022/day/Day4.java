package org.justcupoftea.adventofcode2022.day;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.justcupoftea.adventofcode2022.model.Pair;
import org.justcupoftea.adventofcode2022.task.AbstractTask;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class Day4 extends AbstractTask<Pair<Integer>> {
    public Day4() {
        super(4);
    }

    @Override
    protected List<Pair<Integer>> mapData(@NonNull String data) {
        return Arrays.stream(data.split("\n"))
                .flatMap(s -> Arrays.stream(s.split(",")))
                .map(Pair::of)
                .toList();
    }

    @Override
    protected String getPartOneAnswer(@NonNull List<Pair<Integer>> data) {
        long count = getCount(data);
        return String.valueOf(count);
    }

    @Override
    protected String getPartTwoAnswer(@NonNull List<Pair<Integer>> data) {
        long count = getCrossCount(data);
        return String.valueOf(count);
    }

    public long getCount(@NonNull List<Pair<Integer>> pairs) {
        int count = 0;
        for (int i = 0; i < pairs.size() - 1; i = i + 2) {
            if (contains(pairs.get(i), pairs.get(i + 1))) {
                count++;
            }
        }
        return count;
    }

    public long getCrossCount(@NonNull List<Pair<Integer>> pairs) {
        int count = 0;
        for (int i = 0; i < pairs.size() - 1; i = i + 2) {
            if (isCross(pairs.get(i), pairs.get(i + 1))) {
                count++;
            }
        }
        return count;
    }

    public boolean contains(Pair<Integer> p1, Pair<Integer> p2) {
        boolean res;

        if (p1.start() <= p2.start() && p1.end() >= p2.end()) {
            res = true;
        } else {
            res = p2.start() <= p1.start() && p2.end() >= p1.end();
        }

        log.debug("{}: {},{}", res, p1, p2);
        return res;
    }

    public boolean isCross(Pair<Integer> p1, Pair<Integer> p2) {
        boolean res;

        if (p1.start() >= p2.start() && p1.start() <= p2.end()) {
            res = true;
        } else  {
            res = p2.start() >= p1.start() && p2.start() <= p1.end() ;
        }
        log.debug("cross {}: {},{}", res, p1, p2);
        return res;
    }

}
