package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1890 {
	static int[][] map;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i=0 ; i<N ; i++) {
			map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		
		long[][] dp = new long[N][N];
		dp[0][0] = 1;
		
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				if(i==N-1 && j==N-1)
					break;
				
				int ni = map[i][j] + i;
				int nj = map[i][j] + j;
				
				if(ni < N) {
					dp[ni][j] += dp[i][j];
				}
				if(nj < N) {
					dp[i][nj] += dp[i][j];
				}
			}
		}

		System.out.println(dp[N-1][N-1]);
	}

}
