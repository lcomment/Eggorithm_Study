package dfs_bfs;

// BOJ 2644 촌수계산 

import java.util.ArrayList;
import java.util.Arrays;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class BOJ_2644_촌수계산 {
	static int n, m;
	static int answer = -1;
	static int[] target;	// 촌수 계산할 사람의 번호 
	static ArrayList<Integer>[] tree;
	static boolean isFamily = false;
	static boolean[] isVisited;
	
	public static void main(String[] args) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			n = Integer.parseInt(br.readLine());	// 전체 사람 수 
			target = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();	// 촌수 계산할 사람들 
			tree = new ArrayList[n+1];
			isVisited = new boolean[n+1];
			m = Integer.parseInt(br.readLine());	// 가족 관계 수 
			
			for(int i = 0; i <= n; i++) {
				tree[i] = new ArrayList<>();
			}
			
			for(int i = 0; i < m; i++) {
				int[] relationships = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				
				tree[relationships[0]].add(relationships[1]);
				tree[relationships[1]].add(relationships[0]);
			}
			
			dfs(target[0], 0); // target[0]과 target[1] 사이 
			
			System.out.println(answer);
		}
	}
	
	private static void dfs(int index, int count) {
		isVisited[index] = true;
		
		if(index == target[1]) {
			answer = count;
		}
		
		for(int i : tree[index]) { // ArrayList 순회 
			if(!isVisited[i]) { // 방문하지 않은 원소가 있다면 
				dfs(i, count + 1);
			}
		}
	}
}
