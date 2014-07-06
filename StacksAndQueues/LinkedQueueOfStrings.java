package StacksAndQueues;

/*
 * Queue: linked-list implementation
 */

public class LinkedQueueOfStrings
{
    private Node first, last;

    private class Node
    {
        String item;
        Node next;
    }

    public boolean isEmpty()
    { return first == null; }

    public void enqueue(String item)
    {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last; // special case for empty queue
        else           oldLast.next = last;
    }

    public String dequeue()
    {
        String item = first.item;
        first       = first.next;
        if (isEmpty()) last = null; // special case for empty queue
        return item;
    }

    public static void main(String[] args)
    {
        LinkedQueueOfStrings queue = new LinkedQueueOfStrings();
        System.out.println(queue.isEmpty());
        queue.enqueue("hello");
        System.out.println(queue.isEmpty());
        queue.enqueue("world");
        System.out.println(queue.dequeue());
        queue.enqueue("!");
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
