package org.justcupoftea.adventofcode2022.model;

import lombok.NonNull;
import org.justcupoftea.adventofcode2022.task.AbstractTask;

public record Pair<T extends Comparable<T>>(T start, T end) {

    public static Pair<Integer> of(@NonNull String s) {
        String[] split = s.split("-");
        if (split.length == 2) {
            return new Pair<>(Integer.valueOf(split[0]), Integer.valueOf(split[1]));
        } else {
            throw new RuntimeException(AbstractTask.ERROR_PARAMS.formatted(s));
        }
    }

    @Override
    public String toString() {
        return "%s-%s".formatted(start, end);
    }
}
