package dfs_bfs;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class BOJ_13549_숨바꼭질3 {
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
		
		// 수빈이의 좌표가 더 크면 -1만큼 N-K번 움직여야 한다. 1가지 방
		if(N > K) {
			System.out.println(N-K);
		}else {
			BFS(N, 0);
			System.out.println(minTime);
		}
		
	}	// end of main
	
	static void BFS(int pos, int time) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {pos, time});
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			visited[now[0]] = true;		// 처음 방문한 좌표 표시 
			if(minTime < now[1]) continue;	// 최소시간보다 오래 걸리면 continue
			
			if(now[0] == K) {			// 동생 좌표에 도달했을 때 
				if(now[1] < minTime) minTime = now[1];	// 시간이 덜 걸렸으면 작은 값으로 업데이트 
				else continue;							// 시간이 더 걸렸으면 continue, 값 업데이트X
			}	
			
			int next1 = now[0] + 1;
			int next2 = now[0] - 1;
			int next3 = now[0] * 2;
			
			if(next1 <= 100000 && !visited[next1]) {
				q.add(new int[] {next1, now[1]+1});
			}
			if(next2 >= 0 && !visited[next2]) {
				q.add(new int[] {next2, now[1]+1});
			}
			if(next3 <= 100000 && !visited[next3]) {
				q.add(new int[] {next3, now[1]});
			}
// 가중치 
		} 
		return;
	} 
}
