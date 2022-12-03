package org.justcupoftea.adventofcode2022;

import lombok.extern.slf4j.Slf4j;
import org.justcupoftea.adventofcode2022.day.Day1;
import org.justcupoftea.adventofcode2022.task.AbstractTask;

import java.io.IOException;
import java.util.List;

@Slf4j
public class Main {

    private static final List<AbstractTask<?>> TASK_LIST = List.of(
            new Day1()
    );

    public static void main(String[] args) {
        TASK_LIST.forEach(AbstractTask::printAnswers);
        try {
            for (AbstractTask<?> abstractTask : TASK_LIST) {
                abstractTask.close();
            }
        } catch (IOException e) {
            log.info(e.getMessage());
        }
    }

}
