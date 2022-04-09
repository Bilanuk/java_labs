package com.company;

public class Main {
    public static void main(String[] args) {
        MyCoolHashClass myCoolHashClass = new MyCoolHashClass(3);

        Item test1 = new Item(1);
        Item test2 = new Item(2);
        Item test3 = new Item(3);

        myCoolHashClass.AddValue(test1);
        myCoolHashClass.AddValue(test2);
        myCoolHashClass.AddValue(test3);

        for(Item x : myCoolHashClass.returnValues()) {
            System.out.print(x.getX()); System.out.print(' ');
        }
    }
}

