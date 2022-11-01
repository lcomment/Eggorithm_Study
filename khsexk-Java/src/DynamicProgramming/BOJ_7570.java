package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_7570 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		int[] dp = new int[N+1];
		for(int i=1 ; i<=N ; i++)
			dp[input[i-1]] = dp[input[i-1] - 1] + 1;
		
		Arrays.sort(dp);
		System.out.println(N - dp[N]);
	}

}
