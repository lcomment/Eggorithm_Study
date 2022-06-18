package Dfs_Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_18352 {
	static int[] table;
	static ArrayList<Integer>[] adjList;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] condition = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		int N = condition[0];
		int M = condition[1];
		int K = condition[2];
		int X = condition[3];
		
		adjList = new ArrayList[N+1];
		table = new int[N+1];
		visited = new boolean[N+1];
		
		for(int i=1 ; i<=N ; i++) 
			adjList[i] = new ArrayList<>();
		
		
		for(int i=0 ; i<M ; i++) {
			int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			adjList[input[0]].add(input[1]);
		}
		
		bfs(X);
		StringBuilder sb = new StringBuilder();
		for(int t=1 ; t<=N ; t++)
			if(table[t] == K)
				sb.append(t + "\n");
		
		if(sb.length() == 0)
			System.out.println(-1);
		else
			System.out.println(sb.toString());
	}
	static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		visited[start] = true;
		queue.offer(start);
		
		while(!queue.isEmpty()) {
			int s = queue.poll();
			ArrayList<Integer> arr = adjList[s];
			
			for(int adj : arr) {
				if(!visited[adj]) {
					visited[adj] = true;
					table[adj] = table[s] + 1;
					queue.offer(adj);
				}
			}
		} // while-queue
	}
}
