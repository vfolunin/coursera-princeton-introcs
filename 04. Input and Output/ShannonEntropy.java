public class ShannonEntropy {
    public static void main(String[] args) {
        int[] p = new int[Integer.parseInt(args[0])];
        int n = 0;
        while (!StdIn.isEmpty()) {
            p[StdIn.readInt() - 1]++;
            n++;
        }

        double h = 0;
        for (int i = 0; i < p.length; i++) {
            if (p[i] > 0) {
                double d = (double) p[i] / n;
                h -= d * Math.log(d) / Math.log(2);
            }
        }
        StdOut.printf("%.4f\n", h);
    }
}
