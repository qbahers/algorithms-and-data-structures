package UndirectedGraphs;

/**
 * Depth-first search (not tested)
 */

public class DepthFirstPaths
{
    // marked[v] = true if v connected to s
    private boolean[] marked;
    // edgeTo[v] = previous vertex on path from s to v
    private int[] edgeTo;
    private int s;

    public DepthFirstPaths(Graph G, int s)
    {
        ... // initialize data structures
        dfs(G, s); // find vertices connected to s
    }

    // recursive DFS
    private void dfs(Graph G, int v)
    {
        marked[v] = true;
        for (int w : G.adj(v))
            if (!marked[w])
            {
                dfs(G, w);
                edgeTo[w] = v;
            }
    }
}
