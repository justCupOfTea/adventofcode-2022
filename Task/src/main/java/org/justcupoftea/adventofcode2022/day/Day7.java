package org.justcupoftea.adventofcode2022.day;

import lombok.NonNull;
import org.justcupoftea.adventofcode2022.task.AbstractTask;

import java.util.*;
import java.util.stream.Collectors;

public class Day7 extends AbstractTask<List<String>> {

    @Override
    protected List<String> mapData(@NonNull String data) {
        return Arrays.stream(data.split("\n")).toList();
    }

    @Override
    protected String getPartOneAnswer(@NonNull List<String> data) {
        Map<String, Integer> directoriesSizeMap = directoriesSize(data);
        Integer sum = directoriesSizeMap.values().stream()
                .filter(i -> i <= 100_000)
                .reduce(0, Integer::sum);
        return String.valueOf(sum);
    }

    public Map<String, Integer> directoriesSize(List<String> data) {
        Map<String, Integer> map = new HashMap<>();
        Stack<String> dirs = new Stack<>();
        String[] words;
        for (String line : data) {
            words = line.split(" ");
            if (isCommand(words)) {
                if (isCdDir(words)) {
                    dirs.push(getDirName(words));
                } else if (isCdUp(words)) {
                    dirs.pop();
                }
            } else if (isFile(words)) {
                int fileSize = getFileSize(words);
                for (int i = 0; i < dirs.size(); i++) {
                    String path = dirs.stream().limit(i + 1).collect(Collectors.joining("/"));
                    Integer size = map.getOrDefault(path, 0);
                    map.put(path, size + fileSize);
                }
            }
        }
        return map;
    }


    @Override
    protected String getPartTwoAnswer(@NonNull List<String> data) {

        Map<String, Integer> directoriesSizeMap = directoriesSize(data);
        int needSize = 30_000_000 - (70_000_000 - directoriesSizeMap.get("/"));
        Integer min = directoriesSizeMap.values().stream()
                .filter(i -> i >= needSize)
                .min(Integer::compare).get();
        return String.valueOf(min);
    }

    private boolean isCommand(String[] words) {
        return words.length >= 1 && words[0].equals("$");
    }

    private boolean isCdDir(String[] words) {
        return words.length == 3 && words[1].equals("cd") && !getDirName(words).equals("..");
    }

    private boolean isCdUp(String[] words) {
        return words.length == 3 && words[1].equals("cd") && getDirName(words).equals("..");
    }

    private boolean isDir(String[] words) {
        return words.length >= 1 && words[0].equals("dir");
    }

    private boolean isFile(String[] words) {
        return !isCommand(words) && !isDir(words);
    }

    private String getDirName(String[] words) {
        if (words.length == 3) {
            return words[2];
        }
        throw new RuntimeException("Dir name not found");
    }

    private int getFileSize(String[] words) {
        if (words.length >= 2) {
            String digs = words[0].replaceAll("\\D", "");
            if (!digs.isEmpty()) {
                return Integer.parseInt(digs);
            } else {
                throw new RuntimeException("it's not a number");
            }
        }
        throw new RuntimeException("File size not found");
    }


}
