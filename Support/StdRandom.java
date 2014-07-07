package Support;

import java.util.Random;

public class StdRandom
{
    public static int uniform(int N)
    {
        Random random = new Random();
        return random.nextInt(N);
    }

    /*
     * Knuth shuffle
     */
    public static void shuffle(Comparable[] a)
    {
        int N = a.length;
        for (int i = 0; i < N; i++)
        {
            int r = StdRandom.uniform(i + 1); // between 0 and i
            exch(a, i, r);
        }
    }

    private static void exch(Comparable[] a, int i, int j)
    {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
}
