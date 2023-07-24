import java.util.Scanner;

public class BOJ_10844 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long answer = 0;
        int tmp = sc.nextInt();

        long[][] dp = new long[tmp+1][10];

        for(int i=1; i<=9 ;i++){
            dp[1][i] = 1;
        }

        for(int i=2; i<=tmp; i++){
            for(int j=0; j<=9; j++){
                if(j==0){
                    dp[i][j] = dp[i-1][j+1] % 1000000000;
                }
                else if(j==9){
                    dp[i][j] = dp[i-1][j-1] % 1000000000;
                }
                else{
                    dp[i][j] = (dp[i-1][j-1] %  1000000000) + (dp[i-1][j+1] % 1000000000);
                }
            }
        }

        for(int i=0; i<=9; i++){
            answer += dp[tmp][i];
        }
        System.out.println(answer%1000000000);
    }
}
