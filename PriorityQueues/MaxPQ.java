package PriorityQueues;

/**
 * Binary heap
 */

public class MaxPQ<Key extends Comparable<Key>>
{
    private Key[] pq; 
    private int N;

    // fixed capacity (for simplicity)
    public MaxPQ(int capacity)
    { pq = (Key[]) new Comparable[capacity+1]; }

    // PQ ops

    public boolean isEmpty()
    { return N == 0; }

    public void insert(Key x)
    {
        pq[++N] = x;
        swim(N);
    }

    public Key delMax()
    {
        Key max = pq[1];
        exch(1, N--);
        sink(1);
        pq[N+1] = null; // prevent loitering
        return max;
    }

    // heap helper functions

    private void swim(int k)
    {
        while (k > 1 && less(k/2, k))
        {
            exch(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k)
    {
        while (2*k <= N)
        {
            int j = 2*k;
            if (j < N && less(j, j+1)) j++;
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    // array helper functions

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
