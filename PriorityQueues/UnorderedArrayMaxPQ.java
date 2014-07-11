package PriorityQueues;

/**
 * Priority queue: unordered array implementation
 */

public class UnorderedArrayMaxPQ<Key extends Comparable<Key>>
{
    private Key[] pq; // pq[i] = ith element on pq
    private int N;    // number of elements on pq

    public UnorderedArrayMaxPQ(int capacity)
    { pq = (Key[]) new Comparable[capacity]; } // no generic array creation

    public boolean isEmpty()
    { return N == 0; }

    public void insert(Key x)
    { pq[N++] = x; }

    public Key delMax()
    {
        int max = 0;
        for (int i = 1; i < N; i++)
            if (less(max, i)) max = i;
        exch(max, N-1);
        return  pq[--N]; // should null out entry to prevent loitering
    }

    private boolean less(int i, int j)
    { return pq[i].compareTo(pq[j]) < 0; }

    private void exch(int i, int j)
    { Key t = pq[i]; pq[i] = pq[j]; pq[j] = t; }

    public static void main(String[] args)
    {   
        UnorderedArrayMaxPQ pq = new UnorderedArrayMaxPQ(10);
        System.out.println(pq.isEmpty());
        pq.insert("P");
        System.out.println(pq.isEmpty());
        pq.insert("Q");
        pq.insert("E");
        System.out.println(pq.delMax());
        pq.insert("X");
        pq.insert("A");
        pq.insert("M");
        System.out.println(pq.delMax());
        pq.insert("P");
        pq.insert("L");
        pq.insert("E");
        System.out.println(pq.delMax());
    }
}
