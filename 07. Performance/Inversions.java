public class Inversions {

    // Return the number of inversions in the permutation a[].
    public static long count(int[] a) {
        long res = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j])
                    res++;
            }
        }
        return res;
    }

    // Return a permutation of length n with exactly k inversions.
    public static int[] generate(int n, long k) {
        int p = 0, q = n - 1, inv = n - 1;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if (k < inv) {
                res[i] = p++;
            }
            else {
                k -= inv;
                res[i] = q--;
            }
            inv--;
        }
        return res;
    }

    // Takes an integer n and a long k as command-line arguments,
    // and prints a permutation of length n with exactly k inversions.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        long k = Long.parseLong(args[1]);
        int[] p = generate(n, k);
        for (int i = 0; i < n; i++) {
            System.out.print(p[i]);
            if (i < n - 1)
                System.out.print(" ");
        }
    }
}
