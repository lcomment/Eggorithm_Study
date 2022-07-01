package Dfs_Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_16928 {
	static int[] map = new int[101];
	static boolean[] visited = new boolean[101]; 
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int N = NM[0];
		int M = NM[1];
		
		for(int i=0 ; i<N+M ; i++) {
			int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			map[input[0]] = input[1];
		} // for_i
		
		System.out.println(bfs());
	}
	
	static int bfs() {
		int cnt = 0;
		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		visited[1] = true;
		
		while(!q.isEmpty()) {
			int size = q.size();
			
			for(int i=0 ; i<size ; i++) {
				int p = q.poll();
				
				if(p==100) return cnt;
				
				for(int j=1 ; j<=6 ; j++){
					int next = p + j;
					
					if(next > 100) break;
					if(visited[next]) continue;
					
					if(map[next] != 0) {
						next = map[next];
						
						if(visited[next]) continue;
					}
					
					q.offer(next);
					visited[next] = true;
				}
			} // for_i
			cnt++;
		}
		
		return cnt;
	}
}
