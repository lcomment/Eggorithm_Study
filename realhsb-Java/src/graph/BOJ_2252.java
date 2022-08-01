package graph;

// BOJ 2252번 줄 세우기 

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class BOJ_2252 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	// N : 키를 비교한 횟수 
		int M = sc.nextInt();	// M : M개의 줄에 키를 비교한 두 학생의 번호 A, B
		ArrayList<ArrayList<Integer>> A = new ArrayList<>();
		
		for(int i = 0; i <= N; i++) {
			A.add(new ArrayList<>());
		}
		
		int[] indegree = new int[N + 1];	// 진입 차수 배열 
		for(int i = 0; i < M; i++) {
			int S = sc.nextInt();
			int E = sc.nextInt();
			A.get(S).add(E);
			indegree[E]++;					// 진입 차수 배열 데이터 저장하기 
		}	
		
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 1; i <= N; i++) {
			if(indegree[i] == 0) {
				queue.offer(i);
			}
		}
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			System.out.print(now + " ");
			for(int next : A.get(now)) {
				indegree[next]--;
				if(indegree[next] == 0) {
					queue.offer(next);
				}
			}
		}
	}
}
