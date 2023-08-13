package shortestPath;

// BOJ 1956 운동

/*
 * V개의 마을, E개의 도로 / 도로는 마을 - 마을 사이에 놓임, 일방통행
 * 시작점으로 되돌아오기. 최단거리
 * 사이클을 이루는 도로의 길이의 합이 최소
 * 
 * -> V개의 노드, E개의 간선 
 * 
 * 플로이드 워셜 알고리즘 
 * 
 * 사이클 발생 여부?
 * 플로이드 와샬 알고리즘을 수행한 배열에서
 * graph[a][b] = 1, graph[b][a] = 3과 같이 초기값 INF가 아닌 정수로 초기화되어 있으면
 * 사이클 발생!
 * 
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_1956_운동 {
	static final int INF = (int) 1e8;
	static int V, E, answer;
	static int[][] graph;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		graph = new int[V + 1][V + 1];
		
		// 자기 자신에서 자기 자신으로 가는 비용은 0으로 초기화
		for (int a = 1; a <= V; a++) {
			for (int b = 1; b <= V; b++) {
				if (a != b) graph[a][b] = INF;
			}
		}
		
		// 각 간선에 대한 정보를 입력 받아, 그 값으로 초기화
		for (int i = 1; i <= E; i++) {
			// A에서 B로 가는 비용은 C라고 설정
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[a][b] = c;
		}
		
		// 플로이드 워셜 알고리즘 수행 
		for (int k = 1; k <= V; k++) {
			for (int a = 1; a <= V; a++) {
				for (int b = 1; b <= V; b++) {
					if (a == b) continue;	// 자기 자신 제외
					graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
				}
			}
		}
		
		// 플로이드 워셜 알고리즘을 수행한 수열에서
		// 자기 자신을 제외하고
		// 서로에게 가는 경로가 있다면, 사이클이 존재
		answer = INF;
		for (int a = 1; a <= V; a++) {
			for (int b = 1; b <= V; b++) {
				if(a == b) continue;
				if(graph[a][b] != INF && graph[b][a] != INF) {
					answer = Math.min(graph[a][b] + graph[b][a], answer);
				}
			}
		}
		
		// 답이 INF 그대로일 경우, 사이클이 발생하지 X -> -1 출력
		System.out.println(answer != INF ? answer : -1);
	}
}