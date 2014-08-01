package ShortestPaths;

/**
 * Edge-weighted digraph (not tested)
 */

public class EdgeWeigthedDigraph
{
    private final int V;
    private final Bag<DirectedEdge>[] adj;

    public EdgeWeigthedDigraph(int V)
    {
        this.V = V;
        adj = (Bag<DirectedEdge>[]) new Bag[V];
        for (int v = 0; v < V; v++)
            adj[v] = new Bag<DirectedEdge>();
    }

    public void addEdge(DirectedEdge e)
    {
        int v = e.from();
        adj[v].add(e); // add edge e = v->w to only v's adjacency list
    }

    public Iterable<DirectedEdge> adj(int v)
    { return adj[v]; }
}
