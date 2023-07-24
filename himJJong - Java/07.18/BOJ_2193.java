import java.util.Scanner;

public class BOJ_2193 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tmp = sc.nextInt();

        long[] dp = new long[91];

        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 3;
        dp[5] = 5;

        for(int i=6; i<=tmp; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        System.out.println(dp[tmp]);
    }
}
