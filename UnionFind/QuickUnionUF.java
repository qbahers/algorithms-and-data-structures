package UnionFind;

import java.util.Scanner;

/**
 * Quick-union
 */

public class QuickUnionUF
{
    private int[] id;

    public QuickUnionUF(int N)
    {
        id = new int[N];
        for (int i = 0; i < N; i++) // set id of each object to itself 
            id[i] = i;
    }

    public int find(int i) // chase parent pointers until reach root
    {
        while (i != id[i]) i = id[i];
        return i;
    }

    public void union(int p, int q)
    {
        int i = find(p);
        int j = find(q);
        id[i] = j; // change root of p to point to root of q
    }

    public boolean connected(int p, int q)
    { return find(p) == find(q); }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        QuickUnionUF uf = new QuickUnionUF(N);
        while (sc.hasNext())
        {
            int p = sc.nextInt();
            int q = sc.nextInt();
            if (!uf.connected(p, q))
            {
                uf.union(p, q);
                System.out.println(p + " " + q);
            }
        }
    }   
}
