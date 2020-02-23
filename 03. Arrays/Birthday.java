public class Birthday {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        int[] k = new int[n + 2];
        for (int t = 0; t < trials; t++) {
            boolean[] u = new boolean[n];
            int steps = 0;
            while (true) {
                steps++;
                int i = (int) (n * Math.random());
                if (u[i])
                    break;
                u[i] = true;
            }
            k[steps]++;
        }

        double s = 0;
        for (int steps = 1; true; steps++) {
            s += k[steps];
            System.out.printf("%d\t%d\t%f\n", steps, k[steps], s / trials);
            if (2 * s >= trials)
                break;
        }
    }
}
