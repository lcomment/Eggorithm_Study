import java.io.IOException;
import java.util.Scanner;

public class BOJ_1904 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        long[] dp = new long[num+1];

        if(num > 2){
            dp[1] = 1;
            dp[2] = 2;
            for(int i=3; i<=num; i++) {
                dp[i] = (dp[i-2] + dp[i-1])%15746;
            }
        }
        else if(num == 2) dp[2] = 2;
        else if(num == 1) dp[1] = 1;

        System.out.println(dp[num]);
    }
}