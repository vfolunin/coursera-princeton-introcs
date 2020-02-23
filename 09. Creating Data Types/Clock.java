public class Clock {
    private int h;
    private int m;

    // Creates a clock whose initial time is h hours and m minutes.
    public Clock(int h, int m) {
        if (h < 0 || h > 23 || m < 0 || m > 59)
            throw new IllegalArgumentException();
        this.h = h;
        this.m = m;
    }

    // Creates a clock whose initial time is specified as a string, using the format HH:MM.
    public Clock(String s) {
        if (s.length() != 5 || s.charAt(2) != ':' ||
                !Character.isDigit(s.charAt(0)) || !Character.isDigit(s.charAt(1)) ||
                !Character.isDigit(s.charAt(3)) || !Character.isDigit(s.charAt(4)))
            throw new IllegalArgumentException();
        int h = Integer.parseInt(s.substring(0, 2));
        int m = Integer.parseInt(s.substring(3, 5));
        if (h < 0 || h > 23 || m < 0 || m > 59)
            throw new IllegalArgumentException();
        this.h = h;
        this.m = m;
    }

    // Returns a string representation of this clock, using the format HH:MM.
    public String toString() {
        return String.format("%02d:%02d", h, m);
    }

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that) {
        return h < that.h || h == that.h && m < that.m;
    }

    // Adds 1 minute to the time on this clock.
    public void tic() {
        int t = (h * 60 + m + 1) % (24 * 60);
        h = t / 60;
        m = t % 60;
    }

    // Adds Δ minutes to the time on this clock.
    public void toc(int delta) {
        if (delta < 0)
            throw new IllegalArgumentException();
        int t = (h * 60 + m + delta) % (24 * 60);
        h = t / 60;
        m = t % 60;
    }

    // Test client (see below).
    public static void main(String[] args) {
        Clock c1 = new Clock(0, 0);
        StdOut.println(c1);
        c1.tic();
        StdOut.println(c1);

        Clock c2 = new Clock("20:59");
        StdOut.println(c2);
        c2.toc(181);
        StdOut.println(c2);

        StdOut.println(c2.isEarlierThan(c1));
    }
}
