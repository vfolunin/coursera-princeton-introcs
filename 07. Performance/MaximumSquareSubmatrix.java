public class MaximumSquareSubmatrix {

    // Returns the size of the largest contiguous square submatrix
    // of a[][] containing only 1s.
    public static int size(int[][] a) {
        int res = 0;
        int[][] d = new int[a.length][a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[i][j] == 1) {
                    d[i][j] = 1;
                    if (i > 0 && j > 0)
                        d[i][j] = Math.max(d[i][j], Math.min(Math.min(d[i - 1][j], d[i][j - 1]),
                                                             d[i - 1][j - 1]) + 1);
                    res = Math.max(res, d[i][j]);
                }
            }
        }
        return res;
    }

    // Reads an n-by-n matrix of 0s and 1s from standard input
    // and prints the size of the largest contiguous square submatrix
    // containing only 1s.
    public static void main(String[] args) {
        int n = StdIn.readInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = StdIn.readInt();
            }
        }
        StdOut.println(size(a));
    }
}
