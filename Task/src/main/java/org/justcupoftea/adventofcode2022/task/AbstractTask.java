package org.justcupoftea.adventofcode2022.task;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.Closeable;
import java.io.IOException;
import java.util.Objects;

@Getter
@RequiredArgsConstructor
public abstract class AbstractTask<T> implements Closeable {

    private final ResourceManager resourceManager = new ResourceManager();
    private final int dayNumber;


    public static final String ERROR_PARAMS = "Не верное кол-во параметров. %s";

    public void printAnswers() {
        System.out.printf("Day %s:\n", getDayNumber());
        T data = mapData(resourceManager.getData(String.format("https://adventofcode.com/2022/day/%d/input", getDayNumber())));
        Objects.requireNonNull(data, "Пустые вхожные параметры");
        System.out.printf("Answer to Day %d \n\t\tPart 1 task: %s\n\t\tPart 2 task: %s\n", getDayNumber(), getPartOneAnswer(data), getPartTwoAnswer(data));
    }

    public AbstractTask() {
        String digs = this.getClass().getSimpleName().replaceAll("\\D", "");
        this.dayNumber = Integer.parseInt(digs);
    }

    protected abstract T mapData(@NonNull String data);


    protected abstract String getPartOneAnswer(@NonNull T data);

    protected abstract String getPartTwoAnswer(@NonNull T data);

    public void close() throws IOException {
        resourceManager.close();
    }

}
