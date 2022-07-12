package Dfs_Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_14888 {
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static int N;
	static int[] seq;
	static int[] op;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		seq = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		op = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		dfs(seq[0], 1);
		System.out.println(max);
		System.out.println(min);
	}
	static void dfs(int num, int index) {
		if(index == N) {
			max = Math.max(max, num);
			min = Math.min(min, num);
			return;
		}
		
		for(int i=0 ; i<4 ; i++) {
			if(op[i] > 0) {
				op[i]--;
				
				switch(i) {
					case 0:
						dfs(num+seq[index], index+1);
						break;
					case 1:
						dfs(num-seq[index], index+1);
						break;
					case 2:
						dfs(num*seq[index], index+1);
						break;
					case 3:
						dfs(num/seq[index], index+1);
						break;
				}
				
				op[i]++;
			}
		} // for_i
	} // dfs

}
