package dfs_bfs;

// BOJ 2660 회장 뽑기 

import java.util.Scanner;

public class BOJ_2660_회장뽑기 {
	
	static int N, ans;
	static int[][] graph;
	static final int INF = 1000000;	// MAX_VALUE 하면 음수 나오니까 하지 말기...

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();
		
		graph = new int[N+1][N+1];
		
		// 자기 자신에서 자기 자신으로 가는 노드를 제외하고 INF로 초기화 
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i != j) graph[i][j] = INF;
			}
		}
		
		// 친구 관계 입력 받기 
		while(true) { 
			int S = scan.nextInt();
			int E = scan.nextInt();

			if (S == -1 && E == -1) break;	// -1 경우 break 
			
			graph[S][E] = graph[E][S] = 1;	// 친구 관계는 양방향, 거리 1 
		}
		
		// 플로이드-워셜 알고리즘 진행 
		for (int k = 1; k <= N; k++) {
			for (int a = 1; a <= N; a++) {
				for (int b = 1; b <= N; b++) {
					if (a == b) continue;	// 자기 자신 제외
					graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
				}
			}
		}
	
		
		int minScore = INF;
		int[] allScores = new int[N + 1];	// 각 학생의 점수를 담는 배열 
		
		// 플로이드 워셜 알고리즘 수행 후,
		// 각 학생들이 가진 점수 중 가장 큰 점수만 대표로 배열(allScores)에 담아둔다.
		for (int a = 1; a <= N; a++) {
			int score = 0;
			for (int b = 1; b <= N; b++) {
				if (graph[a][b] != INF) score = Math.max(graph[a][b], score);
			}
			
			allScores[a] = score;
			minScore = Math.min(minScore, score);	// 학생들의 대표 점수 중 가장 작은 값을 구한다 -> 회장 후보의 점수 (minScore) 
		}
		
		StringBuilder sb1 = new StringBuilder();	// 회장 후보의 점수 (minScore) & 후보 학생의 인원 (readerNum)
		StringBuilder sb2 = new StringBuilder();	// 후보 학생
		
		int readerNum = 0;
		for (int i = 1; i <= N; i++) {
			if (allScores[i] == minScore) {	// 회장 후보의 점수를 가진 학생과 후보 수를 구한다.
				readerNum++;
				sb2.append(i + " ");
			}
		}
		
		sb1.append(minScore + " " + readerNum);
		
		System.out.println(sb1.toString());
		System.out.println(sb2.toString());
		
	}
}
