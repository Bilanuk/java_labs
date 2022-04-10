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
            throw new Exception("MyCoolHashClass is overloaded!");
        }
    }

    private int FindFirstEmptySlot(Item item) {
        int hashedIndex = HashingFunc(item.getKey());

        for(int i = hashedIndex; i < values.length; i++) {
            if(values[i] == null) { return i; }
        }
        for(int i = 0; i < hashedIndex; i++) {
            if(values[i] == null) { return i; }
        }

        return -1;
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
            if(values[i] != null && values[i].getKey() == key) { return values[i]; }
        }

        for(int i = 0; i < hashedIndex; i++) {
            if(values[i] != null && values[i].getKey() == key) { return values[i]; }
        }

        throw new Exception(String.format("Can't find Item with id %s", hashedIndex));
    }

    public Item DeleteElement(int key) throws Exception {
        int hashedIndex = HashingFunc(key);
        Item result = values[hashedIndex];
        values[hashedIndex] = null;
        return result;
    }

    public Item[] returnAllValues() {
        return values;
    }

    public void printMe() {
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
        for(int i = 0; i < values.length; i++) {
            System.out.println(String.format("%s: %s", i, (values[i] == null ? 0 : values[i].getKey())));
        }
        System.out.println();
    }
}
