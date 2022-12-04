package org.justcupoftea.adventofcode2022.day;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class Day2Test {
    private Day2 day2 = new Day2();

    private static final String data = """
                A Y
                B X
                C Z
                """;

    private static final List<Day2.Round> list = List.of(
            new Day2.Round(Day2.RockPaperScissors.ROCK, Day2.RockPaperScissors.PAPER, Day2.RockPaperScissors.ROCK)
            , new Day2.Round(Day2.RockPaperScissors.PAPER, Day2.RockPaperScissors.ROCK, Day2.RockPaperScissors.ROCK)
            , new Day2.Round(Day2.RockPaperScissors.SCISSORS, Day2.RockPaperScissors.SCISSORS, Day2.RockPaperScissors.ROCK)
    );
    @Test
    void mapData() {
        List<Day2.Round> actual = day2.mapData(data);
        List<Day2.Round> expected = new ArrayList<>(list);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getDayNumber() {
        Assertions.assertEquals(2, day2.getDayNumber());
    }

    @Test
    void getPartOneAnswer() {
        String actual = day2.getPartOneAnswer(day2.mapData(data));
        String expected = "15";

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getPartTwoAnswer() {

        String actual = day2.getPartTwoAnswer(day2.mapData(data));
        String expected = "12";

        Assertions.assertEquals(expected, actual);
    }
}
