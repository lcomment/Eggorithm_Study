package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1495 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] NSM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int N = NSM[0];
		int S = NSM[1];
		int M = NSM[2];
		
		int[] P = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] v = new int[M + 1];
		
		Arrays.fill(v, -1);
		
		// 0번 인덱스  
		if(0 <= S + P[0] && S + P[0] <= M) {
			v[S + P[0]] = 0;
		}
		if(0 <= S - P[0] && S - P[0] <= M) {
			v[S - P[0]] = 0;
		}
		
		for(int i=1 ; i<N ; i++) {
			for(int j=0 ; j<=M ; j++) {
				if(v[j] != i-1) continue;
				
				if(0 <= j + P[i] && j + P[i] <= M)
					v[j + P[i]] = i;
				if(0 <= j - P[i] && j - P[i] <= M)
					v[j - P[i]] = i;
			} // for_j
		} // for_i
		
		for(int i=M ; i>=0 ; i--) {
			if(v[i] == N-1) {
				System.out.println(i);
				return;
			}
		}
		
		System.out.println(-1);
	}

}
