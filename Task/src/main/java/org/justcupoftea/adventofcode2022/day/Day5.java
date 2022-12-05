package org.justcupoftea.adventofcode2022.day;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.justcupoftea.adventofcode2022.task.AbstractTask;

import java.util.*;
import java.util.stream.IntStream;

@Slf4j
public class Day5 extends AbstractTask<String> {

    public Day5() {
        super(5);
    }

    @Override
    protected List<String> mapData(@NonNull String data) {
        return Arrays.stream(data.split("\n")).toList();
    }

    @Override
    protected String getPartOneAnswer(@NonNull List<String> data) {
        WorkPlan workPlan = getWorkPlan(data);
        return startWork(workPlan);
    }


    @Override
    protected String getPartTwoAnswer(@NonNull List<String> data) {
        WorkPlan workPlan = getWorkPlan(data);
        return startWork2(workPlan);
    }

    public String startWork(WorkPlan workPlan) {
        List<Stack<Character>> stock = new ArrayList<>(workPlan.stock());
        for (Operation o : workPlan.operations()) {
            for (int i = 0; i < o.move(); i++) {
                Character pop = stock.get(o.from()).pop();
                stock.get(o.to()).push(pop);
            }
        }
        return getResult(stock);
    }

    public String startWork2(WorkPlan workPlan) {
        List<Stack<Character>> stock = new ArrayList<>(workPlan.stock());
        for (Operation o : workPlan.operations()) {
            List<Character> tmp = new ArrayList<>();
            for (int i = 0; i < o.move(); i++) {
                Character pop = stock.get(o.from()).pop();
                tmp.add(pop);
            }
            Collections.reverse(tmp);
            for (Character pop : tmp) {
                stock.get(o.to()).push(pop);
            }
        }
        return getResult(stock);
    }

    public WorkPlan getWorkPlan(List<String> data) {
        List<Operation> operations = data.stream()
                .filter(s -> s.startsWith("move"))
                .map(Operation::of)
                .toList();
        ArrayList<String> strings = new ArrayList<>(data.stream()
                .filter(s -> s.contains("[") || s.startsWith(" 1 "))
                .toList());
        Collections.reverse(strings);
        return WorkPlan.of(strings, operations);
    }

    public String getResult(List<Stack<Character>> stock) {
        char[] chars = new char[stock.size()];
        for (int i = 0; i < stock.size(); i++) {
            Stack<Character> stack = stock.get(i);
            chars[i] = stack.get(stack.size() - 1);
        }
        return String.valueOf(chars);
    }


    public record WorkPlan(List<Stack<Character>> stock, List<Operation> operations) {
        public static WorkPlan of(List<String> strings, List<Operation> operations) {
            int max = Arrays.stream(strings.get(0).split(" "))
                    .map(String::trim).filter(s -> !s.isEmpty())
                    .map(Integer::parseInt)
                    .max(Integer::compareTo)
                    .orElseThrow(() -> new RuntimeException(AbstractTask.ERROR_PARAMS));
            strings.remove(0);
            List<Stack<Character>> stacks = IntStream.range(0, max)
                    .mapToObj(i -> new Stack<Character>())
                    .toList();
            int an;
            char[] chars;
            char c;
            for (String s : strings) {
                chars = s.toCharArray();
                for (int j = 1; j <= stacks.size(); j++) {
                    an = 1 + 4 * (j - 1);
                    c = chars[an];
                    log.debug("s: {}, chars[{}]: '{}', ", s, an, c);
                    if (c != ' ') {
                        stacks.get(j - 1).push(chars[an]);
                    }
                }
            }
            return new WorkPlan(stacks, operations);
        }
    }

    public record Operation(int move, int from, int to) {
        public static Operation of(String operation) {
            List<String> strings = Arrays.stream(operation.split(" "))
                    .filter(s -> Character.isDigit(s.charAt(0)))
                    .toList();
            return new Operation(Integer.parseInt(strings.get(0))
                    , Integer.parseInt(strings.get(1)) - 1
                    , Integer.parseInt(strings.get(2)) - 1);
        }
    }
}
