package UnionFind;

import java.util.Scanner;

/**
 * Quick-find
 */

public class QuickFindUF
{
    private int[] id;

    public QuickFindUF(int N)
    {
        id = new int[N];
        for (int i = 0; i < N; i++) // set id of each object to itself 
            id[i] = i;
    }

    public int find(int p) // return the id of p
    { return id[p]; }

    public void union(int p, int q)
    {
        int pid = id[p];
        int qid = id[q];
        // change all entries with id[p] to id[q]
        for (int i = 0; i < id.length; i++)
            if (id[i] == pid) id[i] = qid;
    }

    public boolean connected(int p, int q)
    { return find(p) == find(q); }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        QuickFindUF uf = new QuickFindUF(N);
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
