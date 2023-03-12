package org.justcupoftea.adventofcode2022.day;

import lombok.NonNull;
import org.justcupoftea.adventofcode2022.task.AbstractTask;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Day15 extends AbstractTask<List<Day15.SensorPoint>> {
    @Override
    protected List<SensorPoint> mapData(@NonNull String data) {
        final AtomicInteger counter = new AtomicInteger();
        return Arrays.stream(data.split("\n"))
                .map(s -> s.replaceAll("[^\\d-,:]", ""))
                .map(s -> s.split("[,:]"))
                .flatMap(Arrays::stream)
                .map(Integer::parseInt)
                .collect(Collectors.groupingBy(it -> counter.getAndIncrement() / 4))
                .values()
                .stream()
                .map(SensorPoint::of)
                .toList();
    }

    @Override
    protected String getPartOneAnswer(@NonNull List<SensorPoint> data) {
        return null;
    }

    @Override
    protected String getPartTwoAnswer(@NonNull List<SensorPoint> data) {
        return null;
    }

    public record Sensor(int x, int y) {
    }

    public record Point(int x, int y) {
    }

    public record SensorPoint(Sensor sensor, Point point) {
        public static SensorPoint of(@NonNull List<Integer> list) {
            if (list.size() == 4) {
                return new SensorPoint(new Sensor(list.get(0), list.get(1)), new Point(list.get(2), list.get(3)));
            } else {
                throw new RuntimeException("Не верный набор аргументов");
            }
        }
    }
}
