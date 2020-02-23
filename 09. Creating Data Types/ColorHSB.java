public class ColorHSB {
    private final int h;
    private final int s;
    private final int b;

    // Creates a color with hue h, saturation s, and brightness b.
    public ColorHSB(int h, int s, int b) {
        if (h < 0 || h > 359 || s < 0 || s > 100 || b < 0 || b > 100)
            throw new IllegalArgumentException();
        this.h = h;
        this.s = s;
        this.b = b;
    }

    // Returns a string representation of this color, using the format (h, s, b).
    public String toString() {
        return String.format("(%d, %d, %d)", h, s, b);
    }

    // Is this color a shade of gray?
    public boolean isGrayscale() {
        return s == 0 || b == 0;
    }

    // Returns the squared distance between the two colors.
    public int distanceSquaredTo(ColorHSB that) {
        if (that == null)
            throw new IllegalArgumentException();
        int dh = Math.abs(h - that.h);
        dh = Math.min(dh, 360 - dh);
        int ds = s - that.s;
        int db = b - that.b;
        return dh * dh + ds * ds + db * db;
    }

    // Sample client (see below).
    public static void main(String[] args) {
        int h = Integer.parseInt(args[0]);
        int s = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);
        ColorHSB color = new ColorHSB(h, s, b);

        String nearestColorName = null;
        ColorHSB nearestColor = null;
        int nearestColorDistance = 1000000000;

        while (!StdIn.isEmpty()) {
            String curColorName = StdIn.readString();
            ColorHSB curColor = new ColorHSB(StdIn.readInt(), StdIn.readInt(), StdIn.readInt());
            int curColorDistance = color.distanceSquaredTo(curColor);
            if (curColorDistance < nearestColorDistance) {
                nearestColorName = curColorName;
                nearestColor = curColor;
                nearestColorDistance = curColorDistance;
            }
        }

        StdOut.println(nearestColorName + " " + nearestColor);
    }
}
