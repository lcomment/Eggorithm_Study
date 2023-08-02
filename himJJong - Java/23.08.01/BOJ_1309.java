import java.util.Scanner;

public class BOJ_1309 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] dp = new int[N+1];

        if(N == 0) {
            System.out.println(1);
            System.exit(0);
        }
        if(N == 1) {
            System.out.println(3);
            System.exit(0);
        }
        if(N == 2) {
            System.out.println(7);
            System.exit(0);
        }

        dp[0] = 1;
        dp[1] = 3;
        dp[2] = 7;

        for(int i=3; i<=N; i++){
            dp[i] = ((dp[i-1] * 2) + dp[i-2]) % 9901;
        }

        System.out.println(dp[N]);
    }
}
