public class Minesweeper {
    public static void main(String[] args) {
        int h = Integer.parseInt(args[0]);
        int w = Integer.parseInt(args[1]);
        int m = Integer.parseInt(args[2]);

        int[][] a = new int[h][];
        for (int i = 0; i < h; i++)
            a[i] = new int[w];
        for (int i = 0; i < m; i++)
            a[i / w][i % w] = -1;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                int ind = StdRandom.uniform(i * w + j + 1);
                int t = a[i][j];
                a[i][j] = a[ind / w][ind % w];
                a[ind / w][ind % w] = t;
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (a[i][j] == -1) {
                    System.out.print("*  ");
                    continue;
                }
                int[] di = { -1, -1, -1, 0, 1, 1, 1, 0 };
                int[] dj = { -1, 0, 1, 1, 1, 0, -1, -1 };
                for (int d = 0; d < di.length; d++) {
                    int ti = i + di[d], tj = j + dj[d];
                    if (0 <= ti && ti < h && 0 <= tj && tj < w && a[ti][tj] == -1)
                        a[i][j]++;
                }
                System.out.print(a[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
