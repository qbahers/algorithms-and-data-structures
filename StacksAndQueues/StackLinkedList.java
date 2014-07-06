package StacksAndQueues;

import java.util.Iterator;

/*
 * Stack iterator: linked-list implementation
 */

public class StackLinkedList<Item> implements Iterable<Item>
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

    public Iterator<Item> iterator() { return new ListIterator(); }

    private class ListIterator implements Iterator<Item>
    {
        private Node current = first;

        public boolean hasNext() { return current != null; }
        public void remove()     { /* not supported */     }
        public Item next()
        {
            Item item = current.item;
            current   = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        StackLinkedList<Integer> stack = new StackLinkedList<Integer>();
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
