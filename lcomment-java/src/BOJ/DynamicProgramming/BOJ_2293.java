package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2293 {
	static int n, k;
	static int[] coin;
	static int[] dp;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] nk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		n = nk[0];
		k = nk[1];
		
		coin = new int[n];
		dp = new int[k+1];
		
		for(int i=0 ; i<n ; i++){
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		dp[0] = 1;
		
		for(int i=0 ; i<n ; i++) {
			for(int j=1 ; j<=k ; j++) {
				if(j >= coin[i]) {
					dp[j] += dp[j - coin[i]];
				}
			} // for_j
		}
		System.out.println(dp[k]);
	}
}
