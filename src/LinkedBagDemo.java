public class LinkedBagDemo
{
    public static void main(String[] args)
    {
        System.out.println("Creating an empty bag:");
        BagInterface<String> aBag = new LinkedBag<>();
        testIsEmpty(aBag,true);
        displayBag(aBag);

        System.out.println();

        String[] contentsOfBag = {"A", "D", "B", "A","C","A","D"};
        testAdd(aBag,contentsOfBag);
        testIsEmpty(aBag,false);

        System.out.println("\nTesting Frequency of A");
        testFrequency(aBag,"A");

        System.out.println("\nTesting if bag contains letter 'D'");
        testContain(aBag,"D");
        testContain(aBag,"X");
    }

    private static void testIsEmpty(BagInterface<String> bag, boolean empty)
    {
        System.out.print("\nTesting isEmpty with ");
        if(empty)
            System.out.println("an empty bag");
        else
            System.out.println("a bag that is not empty");

        System.out.print("isEmpty finds the bag ");
        if(empty && bag.isEmpty())
        {
            System.out.println("empty: OK.");
        }else if(empty)
        {
            System.out.println("not empty, but it is: ERROR");
        }else if(!empty && bag.isEmpty())
        {
            System.out.println("empty, but it is not empty: ERROR");
        }else{
            System.out.println("not empty: OK");
        }
    }

    public static void displayBag(BagInterface<String> bag)
    {
        if(bag.isEmpty())
        {
            System.out.println("Bag is empty!");
        }else{
            System.out.println(bag.toArray());
        }
    }

    public static void testAdd(BagInterface<String> bag, String[] strArr)
    {
        for(int i = 0; i < strArr.length; i++)
        {
            bag.add(strArr[i]);
            System.out.println("Added " + strArr[i] + " to the bag");
        }
    }

    public static void testFrequency(BagInterface<String> bag, String s)
    {
        int frequency = bag.getFrequencyOf(s);
        System.out.println(s + " appears " + frequency + " times in the bag");
    }

    public static void testContain(BagInterface<String> bag, String s)
    {
        boolean found = bag.contains(s);
        if(found)
        {
            System.out.println(s + " is in the bag");
        }else{
            System.out.println(s + " is NOT in the bag");
        }
    }
}
