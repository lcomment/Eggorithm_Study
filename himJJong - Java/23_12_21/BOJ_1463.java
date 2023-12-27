import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1463 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int count = 0;

        int[] dp = new int[N+1];

        if(N == 1){
            System.out.println(0);
            System.exit(0);
        }
        else if(N==2){
            System.out.println(1);
            System.exit(0);
        }
        else if(N==3){
            System.out.println(1);
            System.exit(0);
        }
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;

        for(int i=4; i<=N; i++){
            int divideTwo = Integer.MAX_VALUE;
            int divideThree = Integer.MAX_VALUE;

            if(i % 2 == 0){
                divideTwo = i/2;
            }
            if(i % 3 == 0){
                divideThree = i/3;
            }

            if(divideTwo == Integer.MAX_VALUE && divideThree == Integer.MAX_VALUE){
                dp[i] = dp[i-1] + 1;
            }
            else if(divideTwo == Integer.MAX_VALUE){
                dp[i] = Math.min(dp[i-1], dp[divideThree])+1;
            }
            else if(divideThree == Integer.MAX_VALUE){
                dp[i] = Math.min(dp[i-1], dp[divideTwo])+1;
            }
            else{
                dp[i] = Math.min(dp[i-1], Math.min(dp[divideTwo], dp[divideThree]))+1;
            }
        }

        System.out.println(dp[N]);
    }
}
