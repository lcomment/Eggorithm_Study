package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2616 {
	static int N, max;
	static int[] train;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		train = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		max = Integer.parseInt(br.readLine());
		
		int[] prefixSum = new int[N+1];
		
		for(int i=0 ; i<N ; i++)
			prefixSum[i+1] = prefixSum[i] + train[i];
		
		int[][] dp = new int[4][N+1];
		
		for(int i=1 ; i<4 ; i++) {
			for(int j=1 ; j<N+1 ; j++) {
				if(j >= max) 
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j-max] + (prefixSum[j] - prefixSum[j-max]));
			} // for_j
		} // for_i
		
		int result = 0;
		for(int num : dp[3])
			result = Math.max(num, result);
		
		System.out.println(result);
		
		for(int[] arr : dp) {
			for(int i : arr)
				System.out.print(i + " ");
			System.out.println();
		}
	}

}
