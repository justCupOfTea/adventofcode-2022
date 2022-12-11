package org.justcupoftea.adventofcode2022.day;

import lombok.NonNull;
import org.justcupoftea.adventofcode2022.task.AbstractTask;

import java.util.LinkedHashSet;
import java.util.Set;

public class Day6 extends AbstractTask<String> {
    public Day6() {
        super(6);
    }


    @Override
    protected String mapData(@NonNull String data) {
        return data.substring(0, data.length() - 1);
    }

    @Override
    protected String getPartOneAnswer(@NonNull String data) {
        int index = findIndex(data, 4);
        return String.valueOf(index);
    }

    @Override
    protected String getPartTwoAnswer(@NonNull String data) {
        int index = findIndex(data, 14);
        return String.valueOf(index);
    }

    public int findIndex(String data, int size) {
        Set<Character> characterSet = new LinkedHashSet<>();
        int res = 0;
        for (int i = 0; i < data.length(); i++) {
            characterSet.clear();
            for (int j = i; j < i + size; j++) {
                characterSet.add(data.charAt(j));
            }
            if (characterSet.size() == size) {
                res = i + size;
                break;
            }
        }
        return res;
    }
}
