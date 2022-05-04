package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17144 {
	static int[][] map;
	static int R, C;
	static int[] machine = new int[2];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		int count = 0;
		
		for(int i=0 ; i<R ; i++) {
			String[] input = br.readLine().split(" ");
			
			if(input[0].equals("-1")) {
				machine[count] = i;
				count++;
			}
				
			
			for(int j=0 ; j<C ; j++)
				map[i][j] = Integer.parseInt(input[j]);
		} // for_i
		
		for(int i=0 ; i<T ; i++) {
			spread();
			cleanUp();
			cleanDown();
		}
		
		System.out.println(sum());
	}
	static void spread() {
		int[][] sMap = new int[R][C];
		for(int i=0 ; i<R ; i++) {
			for(int j=0 ; j<C ; j++) {
				if(map[i][j] >= 5) {
					int n = map[i][j] / 5;
					int cnt = 0;
					// 상
					if(i != 0 && map[i-1][j] != -1) {
						sMap[i-1][j] += n;
						cnt++;
					}
					//하 
					if(i != R-1 && map[i+1][j] != -1) {
						sMap[i+1][j] += n;
						cnt++;
					}
					// 좌  
					if(j != 0 && map[i][j-1] != -1) {
						sMap[i][j-1] += n;
						cnt++;
					}
					// 우 
					if(j != C-1) {
						sMap[i][j+1] += n;
						cnt++;
					}
					sMap[i][j] += ( map[i][j] - cnt*n);
				}
				else
					sMap[i][j] += map[i][j];
			} // for_j
		} // for_i
		map = sMap;
	}
	
	static void cleanUp() {
        // 아래
        for (int i = machine[0] - 1; i > 0; i--) 
            map[i][0] = map[i-1][0];
        // 왼쪽
        for (int i = 0; i < C - 1; i++) 
            map[0][i] = map[0][i+1];
        // 위
        for (int i = 0; i < machine[0]; i++) 
            map[i][C - 1] = map[i + 1][C - 1];
        // 오른쪽
        for (int i = C - 1; i > 1; i--) 
            map[machine[0]][i] = map[machine[0]][i-1];

        map[machine[0]][1] = 0;
	}
	static void cleanDown() {
		// 
		for (int i = machine[1] + 1; i < R - 1; i++) 
            map[i][0] = map[i + 1][0];
        // 왼쪽
        for (int i = 0; i < C - 1; i++) 
            map[R - 1][i] = map[R - 1][i + 1]; 
        // 아래
        for (int i = R - 1; i > machine[1]; i--) 
            map[i][C - 1] = map[i - 1][C - 1];
        // 오른쪽
        for (int i = C - 1; i > 1; i--) 
            map[machine[1]][i] = map[machine[1]][i - 1];
        
        map[machine[1]][1] = 0;
	}
	
	static int sum() {
		int result = 0;
		for(int[] subMap : map)
			for(int m : subMap)
				result += m;
		
		return result + 2;
	}

}
