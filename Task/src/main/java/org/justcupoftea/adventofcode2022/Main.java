package org.justcupoftea.adventofcode2022;

import lombok.extern.slf4j.Slf4j;
import org.justcupoftea.adventofcode2022.day.*;
import org.justcupoftea.adventofcode2022.task.AbstractTask;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

@Slf4j
public class Main {

    private static final List<AbstractTask<?>> TASK_LIST = List.of(
            new Day8(),
            new Day7(),
            new Day6(),
            new Day5(),
            new Day4(),
            new Day3(),
            new Day2(),
            new Day1()
    );

    public static void main(String[] args) {
        TASK_LIST.stream()
                .sorted(Comparator.comparingInt(AbstractTask::getDayNumber))
                .filter(t -> t.getDayNumber() == 8)
                .forEach(AbstractTask::printAnswers);
        try {
            for (AbstractTask<?> abstractTask : TASK_LIST) {
                abstractTask.close();
            }
        } catch (IOException e) {
            log.info(e.getMessage());
        }
    }

}
