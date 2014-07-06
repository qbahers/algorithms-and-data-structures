package StacksAndQueues;

/*
 * Stack: resizing-array implementation
 */

public class ResizingArrayStackOfStrings 
{
    private String[] s;
    private int N = 0;

    public ResizingArrayStackOfStrings()
    { s = new String[1]; }

    public boolean isEmpty()
    { return N == 0; }

    public void push(String item)
    {
        if (N == s.length) resize(2 * s.length);
        s[N++] = item;
    }

    public String pop()
    {
        String item = s[--N];
        s[N] = null;
        if (N > 0 && N == s.length/4) resize(s.length/2);
        return item;
    }

    private void resize(int capacity)
    {
        String[] copy = new String[capacity];
        for (int i = 0; i < N; i++)
            copy[i] = s[i];
        s = copy;
    }

    public static void main(String[] args)
    {
        ResizingArrayStackOfStrings stack = new ResizingArrayStackOfStrings();
        System.out.println(stack.isEmpty());
        stack.push("a");
        System.out.println(stack.isEmpty());
        stack.push("b");
        stack.push("c");
        stack.push("d");
        stack.push("e");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push("f");
        stack.push("g");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
