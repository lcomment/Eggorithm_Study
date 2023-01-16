import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ_2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int[] data = new int[num+1];
        int[] dp = new int[num+1];

        for(int i=1; i<=num; i++) {
            data[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 0;
        dp[1] = data[1];
        if(num > 1) {
            dp[2] = data[1] + data[2];
        }

        for(int i=3; i<=num; i++){
            dp[i] = Math.max(Math.max(dp[i-2]+data[i],dp[i-3]+data[i-1]+data[i]),dp[i-1]);
        }
        System.out.println(dp[num]);
    }
}