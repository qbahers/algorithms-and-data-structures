package MinimumSpanningTrees;

/**
 * Kruskal's algorithm (not tested)
 */

public class KruskalMST
{
    private Queue<Edge> mst = new Queue<Edge>();

    public KruskalMST (EdgeWeightedGraph G)
    {
        MinPQ<Edge> pq = new MinPQ<Edge>(G.edges());

        UF uf = new UF(G.V());
        while (!pq.isEmpty() && mst.size() < G.V()-1)
        {
            Edge e = pq.delMin();
            int v = e.either(), w = e.other(v);
            if (!uf.connected(v, w)) // edge v-w does not create cycle
            {
                uf.union(v, w);      // merge sets
                mst.enqueue(e);      // add edge to MST
            }
        }
    }

    public Iterable<Edge> edges()
    { return mst; }
}
