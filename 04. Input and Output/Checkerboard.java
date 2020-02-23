import java.awt.Color;

public class Checkerboard {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdDraw.setScale(0, n);
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                StdDraw.setPenColor((x + y) % 2 == 0 ? Color.BLUE : Color.LIGHT_GRAY);
                StdDraw.filledSquare(x + 0.5, y + 0.5, 0.5);
            }
        }
        StdDraw.show();
    }
}
