import java.util.Scanner;

public class BOJ_6487 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        while (n-- > 0) {
            int[] x = new int[4];
            int[] y = new int[4];

            for (int i = 0; i < 4; i++) {
                x[i] = scanner.nextInt();
                y[i] = scanner.nextInt();
            }

            double a = x[1] - x[0];
            double b = y[1] - y[0];
            double c = x[3] - x[2];
            double d = y[3] - y[2];

            if (a * d - b * c != 0) {
                double r = (d * (x[2] - x[0]) - c * (y[2] - y[0])) / (a * d - b * c);
                System.out.printf("POINT %.2f %.2f\n", a * r + x[0], b * r + y[0]);
            } else {
                if ((x[2] - x[0]) * b - (y[2] - y[0]) * a != 0)
                    System.out.println("NONE");
                else
                    System.out.println("LINE");
            }
        }
    }
}
