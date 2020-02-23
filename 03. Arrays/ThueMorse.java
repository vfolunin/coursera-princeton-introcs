public class ThueMorse {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int onesI = 0, onesJ = 0;
                for (int x = i; x > 0; x &= x - 1)
                    onesI++;
                for (int x = j; x > 0; x &= x - 1)
                    onesJ++;
                System.out.print(onesI % 2 == onesJ % 2 ? "+  " : "-  ");
            }
            System.out.println();
        }
    }
}
