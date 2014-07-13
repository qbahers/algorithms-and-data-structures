package UndirectedGraphs;

/**
 * Paths (not tested)
 */

public class Paths
{
    // find paths in G from source s
    public Paths(Graph G, int s)
    {
        ...
    }

    // is there a path from s to v?
    public boolean hasPathTo(int v)
    { return marked[v]; }

    // path from s to v; null if no such path
    public Iterable<Integer> pathTo(int v)
    {
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<Integer>();
        for (int x = v; x != s; x = edgeTo[x])
            path.push(x);
        path.push(s);
        return path;
    }

    public static void main(String[] args)
    {
        Paths paths = new Paths(G, s);
        for (int v = 0; v < G.V(); v++)
            if (paths.hasPathTo(v))
                System.out.println(v); // print all vertices connected to s
    }
}
