public class RevesPuzzle {

    private static void transfer3(int n, int shift, String from, String aux, String to) {
        if (n == 0)
            return;
        transfer3(n - 1, shift, from, to, aux);
        StdOut.println("Move disc " + (n + shift) + " from " + from + " to " + to);
        transfer3(n - 1, shift, aux, from, to);
    }

    private static void transfer4(int n, String from, String aux1, String aux2, String to) {
        if (n == 0)
            return;
        int k = (int) Math.round(n + 1 - Math.sqrt(2 * n + 1));
        transfer4(k, from, aux2, to, aux1);
        transfer3(n - k, k, from, aux2, to);
        transfer4(k, aux1, from, aux2, to);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        transfer4(n, "A", "B", "C", "D");
    }
}
