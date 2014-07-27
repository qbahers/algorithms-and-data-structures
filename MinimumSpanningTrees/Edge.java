package MinimumSpanningTrees;

/**
 * Weighted edge (not tested)
 */

public class Edge implements Comparable<Edge>
{
    private final int v, w;
    private final double weight;

    // constructor
    public Edge(int v, int w, double weight)
    {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    // either endpoint
    public int either()
    { return v; }

    // other endpoint
    public int other(int vertex)
    {
        if (vertex == v) return w;
        else return v;
    }

    // compare edges by weight
    public int compareTo(Edge that)
    {
        if      (this.weight < that.weight) return -1;
        else if (this.weight > that.weight) return +1;
        else                                return  0;
    }
}
