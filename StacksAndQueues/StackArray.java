package StacksAndQueues;

import java.util.Iterator;

/*
 * Stack iterator: array implementation
 */

public class StackArray<Item> implements Iterable<Item>
{
    private Item[] s;
    private int N = 0;

    public StackArray(int capacity) // a cheat (stay tuned)
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

    public Iterator<Item> iterator()
    { return new ReverseArrayIterator(); }

    private class ReverseArrayIterator implements Iterator<Item>
    {
        private int i = N;

        public boolean hasNext() { return i > 0;       }
        public void remove()     { /* not supported */ }
        public Item next()       { return s[--i];      }
    }

    public static void main(String[] args) {
        StackArray<Integer> stack = new StackArray<Integer>(3);
        System.out.println(stack.isEmpty());
        stack.push(1);
        System.out.println(stack.isEmpty());
        stack.push(2);
        stack.push(3);
        for (int i : stack)
            System.out.println(i);
        System.out.println(stack.pop());
    }
}
