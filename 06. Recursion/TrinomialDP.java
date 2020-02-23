public class TrinomialDP {

    // Returns the trinomial coefficient T(n, k).
    public static long trinomial(int n, int k) {
        if (k < -n || k > n)
            return 0;
        long[][] t = new long[n + 1][2 * n + 3];
        t[0][n + 1] = 1;
        for (int ni = 1; ni <= n; ni++) {
            for (int ki = 1; ki <= 2 * n + 1; ki++) {
                t[ni][ki] = t[ni - 1][ki - 1] + t[ni - 1][ki] + t[ni - 1][ki + 1];
            }
        }
        return t[n][k + n + 1];
    }

    // Takes two integer command-line arguments n and k and prints T(n, k).
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        System.out.println(trinomial(n, k));
    }
}

