package Dfs_Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_12851 {
	static int N, K, cnt = 0;
	static int[] map = new int[100_001];
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		N = input[0];
		K = input[1];
		
		
		bfs();
		
		System.out.println(min);
		System.out.println(cnt);
	}
	static void bfs() {
		if (N >= K) {
            min = N-K;
            cnt++;
            return;
        }
		
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(N);
		map[N] = 0;
		
		while(!queue.isEmpty()) {
			int p = queue.poll();
			
			if(min < map[p])
				return;
			
			if(p == K) {
				if(cnt == 0)
					min = map[p];
				if(min == map[p])
					cnt++;
			}
			
			for(int i=0 ; i<3 ; i++) {
				int next;
				
				if(i==0) next = p +1;
				else if(i==1) next = p -1;
				else next = p *2;
				
				if(next < 0 || next > 100000)
					continue;
				
//				if(next == K) {
//					min = map[p];
//					cnt++;
//					
//				}
				
				if(map[next] == 0 || map[next] == map[p] + 1) {
					queue.offer(next);
					map[next] = map[p] + 1;
				}
			}
		}
		
	}
}

// 5 10 9 18 17