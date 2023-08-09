import java.util.Scanner;

public class BOJ_1660 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dp = new int[N+1];

        dp[1] = 1;

        for(int i = 2; i <= N; i++) {
            int min = 300000;
            int sum = 0;
            int sum2 = 0;
            int j = 1;
            while(sum2 <= i){
                sum += j;
                sum2 += sum;
                if(sum2 <= i && min > dp[i-sum2]) {
                    min = dp[i-sum2];
                }
                j++;
            }
            dp[i] = min + 1;
        }
        System.out.println(dp[N]);
    }
}
