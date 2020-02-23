public class RandomWalker {
    public static void main(String[] args) {
        int dist = Integer.parseInt(args[0]);
        int x = 0, y = 0, steps = 0;
        System.out.println("(" + x + ", " + y + ")");
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
            System.out.println("(" + x + ", " + y + ")");
            steps++;
        }
        System.out.println("steps = " + steps);
    }
}
