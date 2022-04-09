package com.company;

import java.util.Arrays;
import java.util.Objects;

public class MyCoolHashClass {
    Item[] values;

    public MyCoolHashClass(int length) {
        this.values = new Item[length];
    }

    public void AddValue(Item item) {
        values[GetLastElementIndex()] = item;
    }

    public int GetLastElementIndex() {
        for(int i = 0; i < values.length; i++) {
            if (values[i] == null) {
                return i;
            }
        }
        return 0;
    }

    public Item[] returnValues() {
        return Arrays.stream(values).filter(Objects::nonNull).toArray(Item[]::new);
    }
}
