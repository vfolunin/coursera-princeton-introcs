import java.util.Arrays;

public class BarChartRacer {
    public static void main(String[] args) {
        In in = new In(args[0]);
        int barsCount = Integer.parseInt(args[1]);

        String title = in.readLine();
        String axisLabel = in.readLine();
        String source = in.readLine();
        in.readLine();

        StdDraw.setCanvasSize(1024, 768);
        StdDraw.enableDoubleBuffering();
        BarChart barChart = new BarChart(title, axisLabel, source);

        while (in.hasNextLine()) {
            int n = Integer.parseInt(in.readLine());
            Bar[] bars = new Bar[n];
            String year = null;
            for (int i = 0; i < n; i++) {
                String[] tokens = in.readLine().split(",");
                year = tokens[0];
                bars[i] = new Bar(tokens[1], Integer.parseInt(tokens[3]), tokens[4]);
            }
            in.readLine();
            Arrays.sort(bars);

            barChart.reset();
            barChart.setCaption(year);
            for (int i = 0; i < barsCount; i++) {
                Bar bar = bars[n - 1 - i];
                barChart.add(bar.getName(), bar.getValue(), bar.getCategory());
            }

            StdDraw.clear();
            barChart.draw();
            StdDraw.show();
            StdDraw.pause(50);
        }
    }
}
