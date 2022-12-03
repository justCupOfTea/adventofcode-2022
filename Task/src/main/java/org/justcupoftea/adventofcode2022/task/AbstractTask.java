package org.justcupoftea.adventofcode2022.task;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;

public abstract class AbstractTask<T> implements Closeable {

    private final ResourceManager resourceManager = new ResourceManager();

    public void printAnswers() {
        System.out.printf("Day %s:\n", getDayNumber());
        List<T> data = mapData(resourceManager.getData(String.format("https://adventofcode.com/2022/day/%d/input", getDayNumber())));
        System.out.printf("Answer to Day %d \n\t\tPart 1 task: %s\n\t\tPart 2 task: %s\n", getDayNumber(), getPartOneAnswer(data), getPartTwoAnswer(data));
    }

    protected abstract List<T> mapData(String data);

    protected abstract int getDayNumber();

    protected abstract String getPartOneAnswer(List<T> data);

    protected abstract String getPartTwoAnswer(List<T> data);

    public void close() throws IOException {
        resourceManager.close();
    }

}
