public class Ramanujan {

    // Is n a Ramanujan number?
    public static boolean isRamanujan(long n) {
        int k = 0;
        for (long i = 1; i * i * i * 2 <= n; i++) {
            long j = Math.round(Math.pow(n - i * i * i, 1.0 / 3));
            if (i * i * i + j * j * j == n)
                k++;
        }
        return k >= 2;
    }

    // Takes a long integer command-line arguments n and prints true if
    // n is a Ramanujan number, and false otherwise.
    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);
        System.out.println(isRamanujan(n));
    }
}
