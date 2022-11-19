package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ_12865 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] NK = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int N = NK[0];
		int K = NK[1];
		ArrayList<Item> items = new ArrayList<>();
		int[][] dp = new int[N+1][K+1];
		
		for(int i=0 ; i<N ; i++) {
			int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			items.add(new Item(input[0], input[1]));
		}
		
		for(int i=1 ; i<=N ; i++) {
			int w = items.get(i-1).w;
			int v = items.get(i-1).v;
			
			for(int j=1 ; j<=K ; j++) {
				if(w > j) {
					dp[i][j] = dp[i-1][j];
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j-w] + v , dp[i-1][j]);
				}
			}
		}
		
		System.out.println(dp[N][K]);
	}
}

class Item {
	int w;
	int v;
	
	Item(int w, int v){
		this.w = w;
		this.v = v;
	}
}