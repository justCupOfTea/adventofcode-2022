package org.justcupoftea.adventofcode2022.day;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.justcupoftea.adventofcode2022.task.AbstractTask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Slf4j
public class Day8 extends AbstractTask<Integer[][]> {
    @Override
    protected Integer[][] mapData(@NonNull String data) {
        List<String> strings = Arrays.stream(data.split("\n")).toList();
        Integer[][] array = new Integer[strings.get(0).length()][strings.size()];
        for (int i = 0; i < strings.size(); i++) {
            String s = strings.get(i);
            for (int j = 0; j < s.length(); j++) {
                array[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }

        }
        return array;
    }

    @Override
    protected String getPartOneAnswer(@NonNull Integer[][] data) {
        int score = getScore(data);
        return String.valueOf(score);
    }

    @Override
    protected String getPartTwoAnswer(@NonNull Integer[][] data) {
        int score = getScore2(data);
        return String.valueOf(score);
    }

    public boolean isVisible(Integer[][] array, int x, int y) {
        final Integer value = array[x][y];

        List<Integer> xList = new ArrayList<>();
        for (int i = 0; i < x; i++) {
            xList.add(array[i][y]);
        }
        Optional<Integer> xMax = xList.stream().max(Integer::compareTo);
        if (xMax.isEmpty() || value.compareTo(xMax.get()) > 0) {
            return true;
        }
        xList.clear();
        for (int i = x + 1; i < array.length; i++) {
            xList.add(array[i][y]);
        }
        xMax = xList.stream().max(Integer::compareTo);
        if (xMax.isEmpty() || value.compareTo(xMax.get()) > 0) {
            return true;
        }


        List<Integer> yList = new ArrayList<>();
        for (int j = 0; j < y; j++) {
            yList.add(array[x][j]);
        }

        Optional<Integer> yMax = yList.stream().max(Integer::compareTo);
        if (yMax.isEmpty() || value.compareTo(yMax.get()) > 0) {
            return true;
        }

        yList.clear();
        for (int j = y + 1; j < array[x].length; j++) {
            yList.add(array[x][j]);
        }

        yMax = yList.stream().max(Integer::compareTo);
        if (yMax.isEmpty() || value.compareTo(yMax.get()) > 0) {
            return true;
        }

        return false;
    }

    public int getScore(Integer[][] array) {
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        for (int x = 0; x < array.length; x++) {
            for (int y = 0; y < array[x].length; y++) {
                sum += isVisible(array, x, y) ? 1 : 0;

                list.add(sum);
            }
        }
        return list.stream().max(Integer::compareTo).get();
    }

    public int getScore2(Integer[][] array) {
        int res = 0;
        int r;
        for (int x = 0; x < array.length; x++) {
            for (int y = 0; y < array[x].length; y++) {
                int a = getYUpScenicScore(array, x, y);
                int b = getXLeftScenicScore(array, x, y);
                int c = getYDownScenicScore(array, x, y);
                int d = getXRightScenicScore(array, x, y);
                r = a * b * c * d;
                if (r > res) {
                    res = r;
                }
            }

        }
        return res;
    }

    public int getXLeftScenicScore(Integer[][] array, int x, int y) {
        int sum = 0;
        Integer value = array[y][x];
        for (int j = x - 1; j >= 0; j--) {
            Integer integer = array[y][j];
            if (value.compareTo(integer) > 0) {
                sum++;
            } else {
                sum++;
                break;
            }
        }
        return sum;
    }

    public int getXRightScenicScore(Integer[][] array, int x, int y) {
        int sum = 0;
        Integer value = array[y][x];
        for (int j = x + 1; j < array[y].length; j++) {
            Integer integer = array[y][j];
            if (value.compareTo(integer) > 0) {
                sum++;
            } else {
                sum++;
                break;
            }
        }
        return sum;
    }

    public int getYUpScenicScore(Integer[][] array, int x, int y) {
        int sum = 0;
        Integer value = array[y][x];
        for (int i = y - 1; i >= 0; i--) {
            Integer integer = array[i][x];
            if (value.compareTo(integer) > 0) {
                sum++;
            } else {
                sum++;
                break;
            }
        }
        return sum;
    }

    public int getYDownScenicScore(Integer[][] array, int x, int y) {
        int sum = 0;
        Integer value = array[y][x];
        for (int i = y + 1; i < array.length; i++) {
            Integer integer = array[i][x];
            if (value.compareTo(integer) > 0) {
                sum++;
            } else {
                sum++;
                break;
            }
        }
        return sum;
    }
}
