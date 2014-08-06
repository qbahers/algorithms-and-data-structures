package MaximumFlow;

/**
 * Ford-Fulkerson (not tested)
 */

public class FordFulkerson
{
    private boolean[] marked;  // true if s->v path in residual network
    private FlowEdge[] edgeTo; // last edge on s->v path
    private double value;      // value of flow

    public FordFulkerson(FlowNetwork G, int s, int t)
    {
        value = 0.0;
        while (hasAugmentingPath(G, s, t)) //compute edgeTo[]
        {
            double bottle = Double.POSITIVE_INFINITY;
            // compute bottleneck capacity
            for (int v = t; v != s; v = edgeTo[v].other(v)) 
                bottle = Math.min(bottle, edgeTo[v].residualCapacityTo(v));

            // augment flow
            for (int v = t; v != s; v = edgeTo[v].other(v))
                edgeTo[v].addResidualFlowTo(v, bottle);

            value += bottle;
        }
    }

    private boolean hasAugmentingPath(FlowNetwork G, int s, int t)
    {
        edgeTo = new FlowEdge[G.V()];
        marked = new boolean[G.V()];

        Queue<Integer> queue = new Queue<Integer>();
        queue.enqueue(s);
        marked[s] = true;
        while (!queue.isEmpty())
        {
            int v = queue.dequeue();

            for (FlowEdge e : G.adj(v))
            {
                int w = e.other(v);
                // found path from s to w in the residual network?
                if (!marked[w] && (e.residualCapacityTo(w) > 0))
                {
                    edgeTo[w] = e;    // save last edge on path to w;
                    marked[w] = true; // mark w;
                    queue.enqueue(w); // add w to queue
                }
            }
        }

        return marked[t]; // is t reachable from s in residual network?
    }

    public double value()
    { return value; }

    // is v reachable from s in residual network?
    public boolean inCut(int v)
    { return marked[v]; }
}
