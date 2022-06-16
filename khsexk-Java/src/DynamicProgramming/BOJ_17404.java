package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_17404 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] rgb = new int[N][3];
		
		int[] result = new int[3];
		
		for(int i=0 ; i<N ; i++) {
			 int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			rgb[i][0] = input[0];
			rgb[i][1] = input[1];
			rgb[i][2] = input[2];
		}
		
		for(int i=0 ; i<3 ; i++) {
			int[][] dp = new int[N][3];
			for(int j=0 ; j<3 ; j++) {
				if(i==j) { dp[0][j] = rgb[0][j]; }
				else { dp[0][j] = 1001; }
			}

			for(int k=1 ; k<N ; k++) {
				dp[k][0] += Math.min(dp[k-1][1], dp[k-1][2]) + rgb[k][0];
				dp[k][1] += Math.min(dp[k-1][0], dp[k-1][2]) + rgb[k][1];
				dp[k][2] += Math.min(dp[k-1][0], dp[k-1][1]) + rgb[k][2];
			}
			
			if(i==0) {
				result[0] = Math.min(dp[N-1][1], dp[N-1][2]);
			}
			else if(i==1) {
				result[1] = Math.min(dp[N-1][0], dp[N-1][2]);
			}
			else if(i==2) {
				result[2] = Math.min(dp[N-1][0], dp[N-1][1]);
			}
		}
		System.out.println(Math.min(result[0], Math.min(result[1], result[2])));
	}
}