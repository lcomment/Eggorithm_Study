import java.util.Scanner;

public class BOJ_2023 {
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        dfs(2);
        dfs(3);
        dfs(5);
        dfs(7);
    }

    public static void dfs(int n) {
        if(String.valueOf(n).length() == N) {
            System.out.println(n);
        } else {
            n = n * 10;
            for(int i = 1; i < 10; i++) {
                if(isPrime(n + i)) {
                    dfs(n + i);
                }
            }
        }
    }

    public static boolean isPrime(int number) {
        if(number < 2) {
            return false;
        }

        for(int i = 2; i < (int) Math.pow(number, 0.5) + 1; i++) {
            if(number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
