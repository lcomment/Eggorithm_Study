package dfs_bfs;

// BOJ 12023 ABCDE

import java.util.Scanner;
import java.util.ArrayList;

public class BOJ_13023_ABCDE {
	static int N;
	static ArrayList<Integer>[] list;
	static boolean[] isVisited;
	static boolean isArrived = false;	// ABCDE 친구 관계가 연결되어 있는지 여부 
	
	public static void main(String[] args)  {
		int N, M;
		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();
		M = scan.nextInt();
		
		list = new ArrayList[N];
		isVisited = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < M; i++) {
			int S = scan.nextInt();
			int E = scan.nextInt();
			
			list[S].add(E);	// 친구 관계이므로 양방향 
			list[E].add(S);
		}
		
		for(int i = 0; i < N; i++) {
			if(isArrived) break;	// 친구 관계가 확인되면 break;
			dfs(i, 1);	// count 가 1부터 시작 
		}
		
		System.out.println(isArrived ? 1 : 0);
	}
	
	private static void dfs(int index, int count) {
		if(count == 5 || isArrived) { // count가 5가 되면 종료 
			isArrived = true;	// 확인 후 break;
			return;
		}
		
		isVisited[index] = true;
		for(int i : list[index]) {
			if(!isVisited[i]) {
				dfs(i, count + 1);
			}
		}
		isVisited[index] = false;
	}
}
