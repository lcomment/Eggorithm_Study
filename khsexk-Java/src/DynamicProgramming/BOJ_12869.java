package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_12869 {
	static int N; 
	static int cnt = Integer.MAX_VALUE;
	static int[] scv = new int[3]; 
	static int[][][] hp = new int[61][61][61]; 

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		for(int i=0 ; i<input.length ; i++)
			scv[i] = input[i];
		
		attack(scv[0], scv[1], scv[2], 0);
		
		System.out.println(cnt);
		
	}
	static void attack(int scv1, int scv2, int scv3, int depth) {
		if(scv1 <= 0 && scv2 <= 0 && scv3 <= 0) {
			cnt = Math.min(cnt, depth);
			return;
		}
		
		if (scv1 < 0) scv1 = 0;
		if (scv2 < 0) scv2 = 0;
		if (scv3 < 0) scv3 = 0;
		
		if(hp[scv1][scv2][scv3] != 0 && hp[scv1][scv2][scv3] <= depth)
			return;
		
		hp[scv1][scv2][scv3] = depth;
		
		attack(scv1 - 9, scv2 - 3, scv3 - 1, depth + 1);
		attack(scv1 - 9, scv2 - 1, scv3 - 3, depth + 1);
		attack(scv1 - 3, scv2 - 9, scv3 - 1, depth + 1);
		attack(scv1 - 3, scv2 - 1, scv3 - 9, depth + 1);
		attack(scv1 - 1, scv2 - 9, scv3 - 3, depth + 1);
		attack(scv1 - 1, scv2 - 3, scv3 - 9, depth + 1);
	}
}
