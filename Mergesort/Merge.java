package Mergesort;

import Support.HelperMethods;

/*
 * Mergesort
 */

public class Merge
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

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi)
    {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid+1, hi);
        if (!less(a[mid+1], a[mid])) return; // stop if already sorted
        merge(a, aux, lo, mid, hi);
    }

    public static void sort(Comparable[] a)
    {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
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
