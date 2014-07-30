package MinimumSpanningTrees;

/**
 * Prim's algorithm: lazy implementation (not tested)
 */

public class LazyPrimMST
{
    private boolean[] marked; // MST vertices
    private Queue<Edge> mst;  // MST edges
    private MinPQ<Edge> pq;   // PQ of edges

    private void visit(WeigthedGraph G, int v)
    {   
        // add v to T
        marked[v] = true;
        for (Edge e : G.adj(v))
            // for each edge e = v-w, add to PQ is w not already in T
            if (!marked[e.other(v)])
                pq.insert(e);
    }

    public LazyPrimMST(WeigthedGraph G)
    {
        pq = new MinPQ<Edge>();
        mst = new Queue<Edge>();
        marked = new boolean[G.V()];
        // assume G is connected
        visit(G, 0);

        while (!pq.isEmpty() && mst.size() < G.V() - 1)
        {
            // repeatedly delete the min weight edge e = v-w from PQ
            Edge e = pq.delMin();
            int v = e.either(), w = e.other(v);
            // ignore if both endpoints in T
            if (marked[v] && marked[w]) continue;
            // add edge e to tree
            mst.enqueue(e);
            // add v or w to tree
            if (!marked[v]) visit(G, v);
            if (!marked[w]) visit(G, w);
        }
    }

    public Iterable<Edge> mst()
    { return mst; }
}
