package university.lab1;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class MyCoolHashClass {
    Item[] values;
    int amountOfItemsInHash;

    public MyCoolHashClass(int length) {
        this.values = new Item[length];
    }

    private int HashingFunc(int key) {
        return key % values.length;
    }

    private void CheckHashSize() throws Exception {
        if(amountOfItemsInHash + 1 > values.length / 2) {
//            this.values = Arrays.copyOf(values, values.length * 2);
//            System.out.println(String.format("New size of array is: %s ", values.length));
            throw new Exception("MyCoolHashClass is overloaded!");
        }
    }

    private int FindFirstEmptySlot(Item item) throws Exception {
        int hashedIndex = HashingFunc(item.getKey());

        for(int i = hashedIndex; i < values.length; i++) {
            if(values[i] == null) { return i; }
        }
        for(int i = 0; i < hashedIndex; i++) {
            if(values[i] == null) { return i; }
        }

        throw new Exception(String.format("Can't find free slot in MyCoolHashClass for %s!", item.getKey()));
    }

    public void AddItemToHash(@NotNull Item item) throws Exception {
        CheckHashSize();
        int hashedIndex = HashingFunc(item.getKey());
        if(values[hashedIndex] == null) {
            values[hashedIndex] = item;
            amountOfItemsInHash += 1;
        } else {
            values[FindFirstEmptySlot(item)] = item;
            amountOfItemsInHash += 1;
            System.out.print(String.format("Collision! Using first empty element hash for: %s \n", item.getKey()) );
        }
    }

    public Item FindElement(int key) throws Exception {
        int hashedIndex = HashingFunc(key);
        for(int i = hashedIndex; i < values.length; i++) {
            if(values[i] != null && values[i].getKey() == key) {
                System.out.println(String.format("Using %s key found item with '%s' key and '%s' value",
                        key, values[i].getKey(), values[i].getValue()));
                return values[i];
            }
        }
        for(int i = 0; i < hashedIndex; i++) {
            if(values[i] != null && values[i].getKey() == key) {
                System.out.println(String.format("Using %s key found item with '%s' key and '%s' value",
                        key, values[i].getKey(), values[i].getValue()));
                return values[i];
            }
        }
        throw new Exception(String.format("Can't find Item with id %s", hashedIndex));
    }

    public Item DeleteElement(int key) throws Exception {
        int hashedIndex = HashingFunc(key);
        for(int i = hashedIndex; i < values.length; i++) {
            if(values[i] != null && values[i].getKey() == key) {
                System.out.println(String.format("Deleting %s element", key));
                values[hashedIndex] = null;
                return values[hashedIndex];
            }
        }
        for(int i = 0; i < hashedIndex; i++) {
            if(values[i] != null && values[i].getKey() == key) {
                System.out.println(String.format("Deleting %s element", key));
                values[hashedIndex] = null;
                return values[hashedIndex];
            }
        }
        throw new Exception(String.format("Can't find and delete Item with id %s", hashedIndex));
    }

    public Item[] returnAllValues() {
        return values;
    }

    public void printMe() {
        System.out.println("Printing MyCoolHashClass:");
        for(Item x : values) {
            if(x == null) {
                System.out.print(".\t");
                continue;
            }
            System.out.print(x.getKey()); System.out.print('\t');
        }
        System.out.println();
    }

    public void printMeAsTable() {
        System.out.println("Printing MyCoolHashClass as a table:");
        for(int i = 0; i < values.length; i++) {
            System.out.println(String.format("%s: %s", i, values[i] == null ? 0 : values[i].getKey()));
        }
        System.out.println();
    }
}
