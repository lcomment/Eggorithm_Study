package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_12026 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String road = br.readLine();
		
		int[] dp = new int[N+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[1] = 0;
		
		for(int i=1 ; i<=N-1 ; i++) {
			char next = next(road.charAt(i-1));
			
			for(int j=i+1 ; j<=N ; j++) {
				if(next != road.charAt(j-1) || dp[i] == Integer.MAX_VALUE) continue;
				
				dp[j] = Math.min(dp[j], dp[i] + (j-i)*(j-i));
			}
		}
		
		System.out.println( (dp[N] != Integer.MAX_VALUE) ? dp[N]:-1);
	}
	static char next(char c) {
		if(c == 'B') return 'O';
		else if(c == 'O') return 'J';
		else return 'B';
	}
}
