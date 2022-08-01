package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9251 {
	static char[] s1;
	static char[] s2;
	static Integer[][] dp;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		s1 = br.readLine().toCharArray();
		s2 = br.readLine().toCharArray();
		
		dp = new Integer[s1.length][s2.length];
		
		System.out.println(lcs(s1.length-1, s2.length-1));
	}
	
	public static int lcs(int idx1, int idx2) {
		if(idx1<0 || idx2<0)
			return 0;
		
		if(dp[idx1][idx2] == null) {
			dp[idx1][idx2] = 0;
			
			if(s1[idx1] == s2[idx2])
				dp[idx1][idx2] = lcs(idx1-1, idx2-1)+1;
			else
				dp[idx1][idx2] = Math.max(lcs(idx1-1,idx2), lcs(idx1,idx2-1));
		}
		return dp[idx1][idx2];
	}
}
