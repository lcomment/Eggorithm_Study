package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_11053 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String[] input = br.readLine().split(" ");
		int[] arr = new int[N];
		int[] dp =new int[N];
		
		for(int i=0 ; i<N ; i++) 
			arr[i] = Integer.parseInt(input[i]);
		
		for(int i=0 ; i<N ; i++) {
			dp[i] = 1;
			
			for(int j=0 ; j<i ; j++) {
				if(arr[j] < arr[i] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
				}
			}  // for_j
		}
		
		int max = Integer.MIN_VALUE;
		for(int i=0 ; i<N ; i++)
			max = (dp[i] > max) ? dp[i] : max;
		
		System.out.println(max);
	}
}