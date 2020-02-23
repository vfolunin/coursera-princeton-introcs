public class RandomWalkers {
    public static void main(String[] args) {
        int dist = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        double totalSteps = 0;
        for (int t = 0; t < trials; t++) {
            int x = 0, y = 0, steps = 0;
            while (Math.abs(x) + Math.abs(y) < dist) {
                double r = Math.random();
                if (r < 0.25)
                    x--;
                else if (r < 0.50)
                    y--;
                else if (r < 0.75)
                    x++;
                else
                    y++;
                steps++;
            }
            totalSteps += steps;
        }
        System.out.println("average number of steps = " + totalSteps / trials);
    }
}
