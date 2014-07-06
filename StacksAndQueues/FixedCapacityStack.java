package StacksAndQueues;

/*
 * Generic fixed-capacity stack: array implementation
 */

public class FixedCapacityStack<Item>
{
    private Item[] s;
    private int N = 0;

    public FixedCapacityStack(int capacity) // a cheat (stay tuned)
    // the ugly cast, since generic array creation not allowed in Java
    { s = (Item[]) new Object[capacity]; }

    public boolean isEmpty()
    { return N == 0; }

    public void push(Item item)
    { s[N++] = item; } // use to index into array; then increment N

    /*
     * this version avoids "loitering": garbage collector can reclaim memory 
     * for an object if no outstanding references
     */
    public Item pop()
    { 
        Item item = s[--N]; // decrement N; then use to index into array
        s[N] = null;
        return item;
    }

    public static void main(String[] args) {
        FixedCapacityStack<Integer> s = new FixedCapacityStack<Integer>(2);
        System.out.println(s.isEmpty());
        s.push(1);
        System.out.println(s.isEmpty());
        s.push(2);
        System.out.println(s.pop());
        s.push(3);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}
