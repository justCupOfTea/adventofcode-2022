package org.justcupoftea.adventofcode2022.day;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.justcupoftea.adventofcode2022.task.AbstractTask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class Day3 extends AbstractTask<List<String>> {

    public static final char a = 'a';
    public static final char z = 'z';
    public static final char A = 'A';
    public static final char Z = 'Z';
    public static final int start = 1;
    public static final int end = 26;
    public static final int START = 27;
    public static final int END = 52;

    @Override
    protected List<String> mapData(@NonNull String data) {
        return Arrays.stream(data.split("\n")).toList();
    }

    @Override
    protected String getPartOneAnswer(@NonNull List<String> data) {
        Integer reduce = data.stream()
                .map(this::separate)
                .map(array -> find(array[0], array[1]))
                .map(this::priority)
                .reduce(0, Integer::sum);
        return reduce.toString();
    }

    @Override
    protected String getPartTwoAnswer(@NonNull List<String> data) {
        List<String[]> a = new ArrayList<>();
        for (int i = 0, x = 1; i < data.size() - 2; i++, x++) {
            if (x % 3 == 1) {
                String[] s = {data.get(i), data.get(i + 1), data.get(i + 2)};
                a.add(s);
            }
        }
        Integer reduce = a.stream()
                .map(array -> find(array[0], array[1], array[2]))
                .map(this::priority)
                .reduce(0, Integer::sum);
        return reduce.toString();
    }

    public char find(@NonNull String s, @NonNull String s1, @NonNull String s2) {
        return s.chars()
                .mapToObj(i -> String.valueOf((char) i))
                .filter(i -> s1.contains(i) && s2.contains(i))
                .findFirst()
                .map(cc -> cc.charAt(0))
                .orElseThrow(() -> new RuntimeException(AbstractTask.ERROR_PARAMS));
    }

    public char find(@NonNull String s1, @NonNull String s2) {
        return s1.chars()
                .mapToObj(i -> String.valueOf((char) i))
                .filter(s2::contains)
                .findFirst()
                .map(cc -> cc.charAt(0))
                .orElseThrow(() -> new RuntimeException(AbstractTask.ERROR_PARAMS));
    }


    public String[] separate(String s) {
        int i = s.length() / 2;
        String first = s.substring(0, i);
        String second = s.substring(i);
        return new String[]{first, second};
    }

    public int priority(char symbol) {
        int res;
        if (symbol >= a && symbol <= z) {
            res = symbol - (a - start);
        } else if (symbol >= A && symbol <= Z) {
            res = symbol - (A - START);
        } else {
            throw new RuntimeException(AbstractTask.ERROR_PARAMS.formatted(symbol));
        }
        return res;
    }
}
