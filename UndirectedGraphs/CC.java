package UndirectedGraphs;

/**
 * Finding connected components with DFS (not tested)
 */

public class CC
{
    private boolean[] marked;
    private int[] id;  // id[v] = id of component containing v
    private int count; // number of components

    public CC(Graph G)
    {
        marked = new boolean[G.V()];
        id = new int[G.V()];
        for (int v = 0; v < G.V(); v++)
        {
            if (!marked[v])
            {
                // run DFS from one vertex in each component
                dfs(G, v);
                count++;
            }
        }
    }

    // number of components
    public int count()
    { return count; }

    // id of component containing v
    public int id(int v)
    { return id[v]; }

    // v and w connected iff same id
    public boolean connected(int v, int w)
    { return id[v] == id[w]; }

    private void dfs(Graph G, int v)
    {
        marked[v] = true;
        // all vertices discovered in same call of dfs have same id
        id[v] = count;
        for (int w : G.adj(v))
            if (!marked[w])
                dfs(G, w);
    }
}   
