package university.lab1;

public class Main {
    public static void main(String[] args) throws Exception {
        MyCoolHashClass myCoolHashClass = new MyCoolHashClass(8);

        Item test1 = new Item(53123, "first element");
        Item test2 = new Item(62962, "second element");
        Item test3 = new Item(58342, "third element");
        Item test4 = new Item(14957, "fourth element");

        myCoolHashClass.AddItemToHash(test1);
        myCoolHashClass.AddItemToHash(test2);
        myCoolHashClass.AddItemToHash(test3);
        myCoolHashClass.AddItemToHash(test4);

//        myCoolHashClass.printMe();
        myCoolHashClass.printMeAsTable();

        System.out.print(myCoolHashClass.FindElement(test4.getKey()).getValue());
        System.out.print(myCoolHashClass.DeleteElement(test4.getKey()).getKey());

        myCoolHashClass.printMeAsTable();
    }
}

