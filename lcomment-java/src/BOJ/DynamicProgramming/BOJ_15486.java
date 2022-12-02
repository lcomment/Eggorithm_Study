package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_15486 {
	static class Consulting {
		int t, p;
		Consulting(int t, int p){
			this.t = t;
			this.p = p;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Consulting[] coList = new Consulting[N+2];
		
		for(int i=1 ; i<=N ; i++) {
			int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			coList[i] = new Consulting(input[0], input[1]);
		}
		
		coList[N+1] = new Consulting(0, 0);
		
		int[] dp = new int[N+2];
		
		int total = Integer.MIN_VALUE;
		for(int i=1 ; i<=N+1 ; i++) {
			if(total < dp[i])
				total = dp[i];
			
			int deadline = calDeadline(i, coList[i].t);
			if(deadline <= N + 1)
				dp[deadline] = Math.max(coList[i].p + total, dp[deadline]);
		}
		
		System.out.println(dp[N+1]);
	}
	static int calDeadline(int cur, int deadline) {
		return cur + deadline;
	}
}
