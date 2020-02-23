public class WorldMap {
    public static void main(String[] args) {
        StdDraw.enableDoubleBuffering();

        int w = StdIn.readInt();
        int h = StdIn.readInt();
        StdDraw.setCanvasSize(w, h);
        StdDraw.setXscale(0, w);
        StdDraw.setYscale(0, h);

        while (!StdIn.isEmpty()) {
            StdIn.readString();
            int n = StdIn.readInt();
            double[] x = new double[n];
            double[] y = new double[n];
            for (int i = 0; i < n; i++) {
                x[i] = StdIn.readDouble();
                y[i] = StdIn.readDouble();
            }
            StdDraw.polygon(x, y);
        }

        StdDraw.show();
    }
}
