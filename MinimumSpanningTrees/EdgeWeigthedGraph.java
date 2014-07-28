package MinimumSpanningTrees;

/**
 * Edge-weighted graph (not tested)
 */

public class EdgeWeightedGraph
{
    private final int V;
    // same as Graph, but adjacency lists of Edges instead of integers
    private final Bag<Edge>[] adj;

    // constructor
    public EdgeWeightedGraph(int V)
    {
        this.V = V;
        adj = (Bag<Edge>[]) new Bag[V];
        for (int v = 0; v < V; v++)
            adj[v] = new Bag<Edge>();
    }

    // add edge to both adjacency lists
    public void addEdge(Edge e)
    {
        int v = e.either(), w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
    }

    public Iterable<Edge> adj(int v)
    { return adj[v]; }
}
