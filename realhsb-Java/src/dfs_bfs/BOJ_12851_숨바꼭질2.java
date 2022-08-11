package dfs_bfs;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class BOJ_12851_숨바꼭질2 {
	static int minTime = 100000;
	static int count = 1;
	static int N;
	static int K;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();	// 수빈이 좌표 
		K = sc.nextInt();	// 동생 좌표 
		
		visited = new boolean[100001];
		visited[N] = true;
		
		// 수빈이의 좌표가 더 크면 -1만큼 N-K번 움직여야 한다. 1가지 방법 
		if(N > K) {
			System.out.println(N-K);
			System.out.println(1);
		}else {
			BFS(N, 0);
			System.out.println(minTime);
			System.out.println(count);
		}
		
		
	}	
	
	static void BFS(int pos, int time) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {pos, time});
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			visited[now[0]] = true;		// 처음 방문한 좌표 표시 
			if(minTime < now[1]) continue;	// 최소시간보다 오래 걸리면 continue
			
			if(now[0] == K) {			// 동생 좌표에 도달했을 때 
				if(now[1] < minTime) minTime = now[1];	// 시간이 덜 걸렸으면 작은 값으로 업데이트 
				else if(now[1] == minTime) count++;		// 같은 시간이 걸렸다면 경우의 수 증가 
				else continue;							// 시간이 더 걸렸으면 continue, 값 업데이트X
			}	
			
			for(int i = 0; i < 3; i++) {		// 3가지 이동방법 확인, +1, -1, *2
				int next = 0;
				
				if(i == 0) next = now[0] + 1;
				else if(i == 1) next = now[0] - 1;
				else next = now[0] * 2;
				
				if(next >= 0 && next <= 100000 && !visited[next]) {	
					// 각 이동방법을 진행했을 때, 좌표의 유효범위에 드는지, 방문했는지 확인하고 큐에 추가 
					q.add(new int[] {next, now[1]+1});
				}
			} 
		} 
		return;
	} 
}	
