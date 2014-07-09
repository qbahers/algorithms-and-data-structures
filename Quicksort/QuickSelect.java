package Quicksort;

import Support.HelperMethods;
import Support.StdRandom;

/*
 * Quick-select
 */

public class QuickSelect
{
    private static int partition(Comparable[] a, int lo, int hi)
    {
        int i = lo, j = hi+1;
        while (true)
        {
            // find item on left to swap
            while (less(a[++i], a[lo])) 
                if (i == hi) break;

            // find item on right to swap
            while (less(a[lo], a[--j]))
                if (j == lo) break;

            if (i >= j) break; // check if pointers cross
            exch(a, i, j);     // swap
        }

        exch(a, lo, j); // swap with partitioning item
        return j;       // return index of item now known to be in place
    }

    public static Comparable select(Comparable[] a, int k)
    {
        StdRandom.shuffle(a);
        int lo = 0, hi = a.length - 1;
        while (hi > lo)
        {
            int j = partition(a, lo, hi);
            if      (j < k) lo = j + 1;
            else if (j > k) hi = j - 1;
            else            return a[k];
        }
        return a[k];
    }

    private static boolean less(Comparable v, Comparable w)
    { return v.compareTo(w) < 0; }

    private static void exch(Comparable[] a, int i, int j)
    {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static void main(String[] args)
    {
        String[] a = {"d", "b", "a", "c", "e", "i", "g", "h", "f", "j"};
        System.out.print(HelperMethods.stringArrayToString(a) + ": ");
        System.out.print(select(a, 0) + ", ");
        System.out.print(select(a, 9) + ", ");
        System.out.println(select(a, 2));
    }
}
