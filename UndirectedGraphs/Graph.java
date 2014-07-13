package UndirectedGraphs;

/**
 * Graph (not tested)
 */

public class Graph 
{
    private final int V;
    private Bag<Integer>[] adj; // adjacency lists (using Bag data type)

    // create empty graph with V vertices
    public Graph(int V)
    {
        this.V = V;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++)
            adj[v] = new Bag<Integer>();
    }

    // add edge v-w (parallel edges and self-loops allowed)
    public void addEdge(int v, int w)
    {   
        adj[v].add(w);
        adj[w].add(v);
    }

    // iterator for vertices adjacent to v
    public Iterable<Integer> adj(int v)
    { return adj[v]; }

    // degree of vertex v in graph G
    public static int degree(Graph G, int v)
    {
        int degree = 0;
        for (int w : G.adj(v))
            degree++;
        return degree;
    }

    public static void main(String[] args)
    {
        // read graph from input stream
        In in = new In(args[0]);
        Graph G = new Graph(in);

        // print out each edge (twice)
        for (int v = 0; v < G.V(); v++)
            for (int w : G.adj(v))
                System.out.println(v + "-" + w);
    }
}
