package Mergesort;

import Support.HelperMethods;

/*
 * Mergesort
 */

public class MergeBU
{
    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi)
    {
        // copy
        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];

        // merge
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++)
        {
            if      (i > mid)              a[k] = aux[j++];
            else if (j > hi)               a[k] = aux[i++]; 
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else                           a[k] = aux[i++];
        }
    }

    public static void sort(Comparable[] a)
    {
        int N = a.length;
        Comparable[] aux = new Comparable[N];
        for (int sz = 1; sz < N; sz = 2*sz)
            for (int lo = 0; lo < N-sz; lo += 2*sz)
                merge(a, aux, lo, lo+sz-1, Math.min(lo+2*sz-1, N-1));
    }

    public static boolean less(Comparable v, Comparable w)
    { return v.compareTo(w) < 0; }

    public static void main(String[] args)
    {
        String[] a = {"d", "b", "a", "c", "e", "i", "g", "h", "f", "j"};
        System.out.print(HelperMethods.stringArrayToString(a) + ": ");
        sort(a);
        System.out.println(HelperMethods.stringArrayToString(a));
    }
}
