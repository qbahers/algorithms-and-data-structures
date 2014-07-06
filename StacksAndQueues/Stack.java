package StacksAndQueues;

/*
 * Generic stack: linked-list implementation
 */

public class Stack<Item>
{
    private Node first = null;

    /*
     * private inner class
     * (access modifiers for instance variables don't matter)
     */
    private class Node
    {
        Item item;
        Node next;
    }

    public boolean isEmpty()
    { return first == null; }

    public void push(Item item)
    {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }

    public Item pop()
    {
        Item item = first.item;
        first = first.next;
        return item;
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<Integer>();
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
