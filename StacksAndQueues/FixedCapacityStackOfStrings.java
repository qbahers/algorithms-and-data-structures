package StacksAndQueues;

/*
 * Fixed-capacity stack: array implementation
 */

public class FixedCapacityStackOfStrings
{
    private String[] s;
    private int N = 0;

    public FixedCapacityStackOfStrings(int capacity) // a cheat (stay tuned)
    { s = new String[capacity]; }

    public boolean isEmpty()
    { return N == 0; }

    public void push(String item)
    { s[N++] = item; } // use to index into array; then increment N

    /*
     * this version avoids "loitering": garbage collector can reclaim memory 
     * for an object if no outstanding references
     */
    public String pop()
    { 
        String item = s[--N]; // decrement N; then use to index into array
        s[N] = null;
        return item;
    }

    public static void main(String[] args) {
        FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(2);
        System.out.println(stack.isEmpty());
        stack.push("hello");
        System.out.println(stack.isEmpty());
        stack.push("world");
        System.out.println(stack.pop());
        stack.push("!");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
