package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_5557 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		long[][] dp = new long[N][21];
		
		dp[1][input[0]] = 1;
		
		for(int i=0 ; i<N-1 ; i++) {
			for(int j=0 ; j<21 ; j++) {
				if(dp[i][j] > 0) {
					if(0 <= j + input[i] && j + input[i] <= 20)
						dp[i+1][j + input[i]] += dp[i][j];
					
					if(0 <= j - input[i] && j - input[i] <= 20)
						dp[i+1][j - input[i]] += dp[i][j];
				}
			} // for_j
		} // for_i
		
		System.out.println(dp[N - 1][input[N - 1]]);
	}

}
