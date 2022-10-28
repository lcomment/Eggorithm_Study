package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_11057 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N+1][10];
		
		Arrays.fill(dp[1], 1);
		
		for(int i=2 ; i<=N ; i++) {
			for(int j=0 ; j<10; j++) {
				for(int k=0 ; k<=j ; k++) {
					dp[i][j] += dp[i-1][k];
					dp[i][j] %= 10007;
				}
			}
		}
		for(int i=0 ; i<=N ; i++) {
			for(int j=0 ; j<10 ; j++)
				System.out.print(dp[i][j] + "\t");
			System.out.println();
		}
		
		int result = 0;
		for(int i=0 ; i<10 ; i++) {
			result += dp[N][i];
		}
		System.out.println(result);
	}

}
