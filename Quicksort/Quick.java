package Quicksort;

import Support.HelperMethods;
import Support.StdRandom;

/*
 * Quicksort
 */

public class Quick
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

    public static void sort(Comparable[] a)
    {
        StdRandom.shuffle(a); // shuffle needed for performance guarantee
        sort(a, 0, a.length - 1);

    }

    private static void sort(Comparable[] a, int lo, int hi)
    {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
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
        sort(a);
        System.out.println(HelperMethods.stringArrayToString(a));
    }
}
