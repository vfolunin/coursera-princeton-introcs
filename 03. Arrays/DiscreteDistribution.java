public class DiscreteDistribution {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int[] p = new int[args.length - 1];
        for (int i = 0; i < p.length; i++)
            p[i] = Integer.parseInt(args[i + 1]) + (i > 0 ? p[i - 1] : 0);

        for (int i = 0; i < n; i++) {
            int x = (int) (p[p.length - 1] * Math.random());
            int left = 0, right = p.length - 1;
            while (left + 1 < right) {
                int mid = left + (right - left) / 2;
                if (p[mid] <= x)
                    left = mid;
                else
                    right = mid;
            }
            int res = (p[left] > x ? left : right);
            System.out.print(res + 1 + " ");
        }
    }
}
