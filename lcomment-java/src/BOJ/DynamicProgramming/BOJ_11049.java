package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_11049 {
	static int[] matrixList;
	static long[][] dp;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		matrixList = new int[N+1];
		
		for(int i=0 ; i<N ; i++) {
			int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			matrixList[i] = input[0];
			matrixList[i+1] = input[1];
		}
		
		dp = new long[N][N];
		for(int i=0 ; i<N ; i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		
		System.out.println(topDown(0, N-1));
		
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				System.out.print(dp[i][j]+ " ");
				
			}
			System.out.println();
		}
	}
	
	public static long topDown(int start, int current) {
		if(start == current) return 0;
		if(dp[start][current] != Integer.MAX_VALUE) return dp[start][current];
		
		for(int i=start ; i<current ; i++) {
			long multi = topDown(start, i) + topDown(i+1, current) + (matrixList[start] * matrixList[i+1] * matrixList[current+1]);
			dp[start][current] = Math.min(dp[start][current], multi);
		}
		return dp[start][current];
	}

}
