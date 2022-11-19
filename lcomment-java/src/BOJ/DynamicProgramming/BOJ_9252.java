package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9252 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s1 = br.readLine();
		String s2 = br.readLine();
		
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];
		
		for(int i=1 ; i<s1.length()+1; i++) {
			for(int j=1 ; j<s2.length()+1; j++) {
				if(s1.charAt(i-1) == s2.charAt(j-1)) 
					dp[i][j] = dp[i-1][j-1] + 1;
				else 
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			} // for_j
		} // for_i
		
		
		
		System.out.println(dp[s1.length()][s2.length()]);
		
		String lcs = "";
		int i = dp.length - 1, j = dp[0].length - 1;
		while(i != 0 && j != 0) {
			if(dp[i][j] == dp[i - 1][j]) {
				i--;
			}
			else if(dp[i][j] == dp[i][j - 1]) {
				j--;
			}
			else {
				lcs += s1.charAt(i - 1);
				i--;
				j--;
			}
		}
		
		System.out.print(new StringBuilder(lcs).reverse());
    }


}
