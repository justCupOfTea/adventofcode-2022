package org.justcupoftea.adventofcode2022.day;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.justcupoftea.adventofcode2022.task.AbstractTask;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Slf4j
public class Day2 extends AbstractTask<Day2.Round> {
    private static final RockPaperScissorsComparator comparator = new RockPaperScissorsComparator();

    public Day2() {
        super(2);
    }

    @Override
    protected List<Day2.Round> mapData(String data) {
        return Arrays.stream(data.split("\n"))
                .map(s -> s.split(" "))
                .map(Round::new)
                .toList();
    }


    @Override
    protected String getPartOneAnswer(@NonNull List<Day2.Round> data) {
        return data.stream().map(Round::sum).reduce(0, Integer::sum).toString();
    }

    @Override
    protected String getPartTwoAnswer(@NonNull List<Day2.Round> data) {
        return data.stream().map(Round::sum2).reduce(0, Integer::sum).toString();
    }


    @Getter
    @RequiredArgsConstructor
    public enum RockPaperScissors {

        ROCK(1, "A", "X", "-"), // - +
        PAPER(2, "B", "Y", "="), // - +
        SCISSORS(3, "C", "Z", "+"); //- +
        private final int value;
        private final String left;
        private final String right;
        private final String predict;

        public static RockPaperScissors of(@NonNull final String s) {
            return switch (s) {
                case "A", "X" -> RockPaperScissors.ROCK;
                case "B", "Y" -> RockPaperScissors.PAPER;
                case "C", "Z" -> RockPaperScissors.SCISSORS;
                default -> throw new RuntimeException("Не определено занчение '%s'".formatted(s));
            };
        }
    }

    public static class RockPaperScissorsComparator implements Comparator<RockPaperScissors> {
        @Override
        public int compare(RockPaperScissors o1, RockPaperScissors o2) {
            int res;
            if (o1.value == o2.value) {
                res = 0;
            } else if (o1.value % 2 == o2.value % 2 && o1.value < o2.value) {
                res = 1;
            } else if (o1.value % 2 == o2.value % 2 && o1.value > o2.value) {
                res = -1;
            } else if (o1.value % 2 != o2.value % 2 && o1.value < o2.value) {
                res = -1;
            } else {
                res = 1;
            }
            return res;
        }

        public int round(RockPaperScissors o1, RockPaperScissors o2) {
            int res;
            String s;
            if (compare(o1, o2) > 0) {
                s = ">";
                res = 6;
            } else if (compare(o1, o2) < 0) {
                s = "<";
                res = 0;
            } else {
                s = "=";
                res = 3;
            }
            log.debug("{} {} {}", o1.name(), s, o2.name());
            return res;
        }
    }


    @Getter
    @EqualsAndHashCode
    @RequiredArgsConstructor
    public static class Round {
        private final RockPaperScissors first;
        private final RockPaperScissors second;
        private final RockPaperScissors third;

        private static final RockPaperScissors[] values = RockPaperScissors.values();
        private static final int SIZE = values.length;

        public Round(@NonNull String[] strings) {
            if (strings.length != 2) {
                throw new RuntimeException(AbstractTask.ERROR_PARAMS.formatted(Arrays.stream(strings).toList()));
            }
            first = RockPaperScissors.of(strings[0]);
            second = RockPaperScissors.of(strings[1]);


            third = switch (second.predict) {
                case "=" -> first;
                case "-" -> first.ordinal() == 0 ? values[values.length - 1] : values[first.ordinal() - 1];
                case "+" -> first.ordinal() == values.length - 1 ? values[0] : values[first.ordinal() + 1];
                default -> throw new RuntimeException("Не определено занчение '%s'".formatted(second.predict));
            };
        }

        public Integer sum() {

            int sum = second.value + comparator.round(second, first);

            log.debug("sum1 : {}", sum);
            return sum;
        }

        @Override
        public String toString() {
            return "%s %s = %s|%s".formatted(first.left, second.right, sum(), sum2());
        }

        private Integer sum2() {
            int sum = third.value + comparator.round(third, first);
            log.debug("sum2 : {}", sum);
            return sum;
        }
    }
}
