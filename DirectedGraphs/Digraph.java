package DirectedGraphs;

/**
 * Digraph (not tested)
 */

public class Digraph
{
    private final int V;
    private final Bag<Integer>[] adj; //adjacency lists

    // create empty digraph with V vertices
    public Digraph(int V)
    {
        this.V = V;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++)
            adj[v] = new Bag<Integer>();
    }

    // add edge v-w
    public void addEdge(int v, int w)
    {
        adj[v].add(w);
    }

    // iterator for vertices pointing from v
    public Iterable<Integer> adj(int v)
    { return adj[v]; }

    public static void main(String[] args)
    {
        // read digraph from input stream
        In in = new In(args[0]);
        Digraph G = new Digraph(in);
        
        // print out each edge (once)
        for (int v = 0; v < G.V(); v++)
            for (int w : G.adj(v))
                System.out.println(v + "->" + w);
    }
}
