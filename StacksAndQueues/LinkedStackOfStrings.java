package StacksAndQueues;

/*
 * Stack: linked-list implementation
 */

public class LinkedStackOfStrings
{
    private Node first = null;

    /*
     * private inner class
     * (access modifiers for instance variables don't matter)
     */
    private class Node
    {
        String item;
        Node next;
    }

    public boolean isEmpty()
    { return first == null; }

    public void push(String item)
    {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }

    public String pop()
    {
        String item = first.item;
        first = first.next;
        return item;
    }

    public static void main(String[] args) {
        LinkedStackOfStrings stack = new LinkedStackOfStrings();
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
