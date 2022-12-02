package Dfs_Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ_2660 {
	static int[] point;
	static ArrayList<Integer>[] adjList;
	static int[] depth;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		adjList = new ArrayList[N+1];
		point = new int[N+1];
		
		for(int i=1 ;i<N+1 ;i++) 
			adjList[i] = new ArrayList<Integer>();
		
		
		while(true) {
			String[] input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			
			if(a == -1 && b == -1)  break;
			
			adjList[a].add(b);
			adjList[b].add(a);
		} // while-true
		
		for(int i=1 ; i<N+1 ; i++) {
			boolean[] visited = new boolean[N+1];
			depth = new int[N+1];
			Arrays.fill(depth, Integer.MAX_VALUE);
			dfs(visited, depth, i, 0);
			point[i] = calPoint(depth);
		} // for_i
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		
		int min = calScore(point);
		int cnt = 0;
		ArrayList<Integer> result = new ArrayList<>();
		
		for(int i=1 ; i<point.length ; i++) {
			if(min == point[i]) {
				sb2.append(i + " ");
				cnt++;
			}
		}
		System.out.println(min + " " + cnt);
		System.out.println(sb2.toString());
	}
	public static void dfs(boolean[] visited, int[] depth, int start, int cnt) {
		visited[start] = true;
		ArrayList<Integer> arr = adjList[start];
		depth[start] = Math.min(depth[start], cnt);
		
		for(int i=0 ; i<arr.size() ; i++) {
			if(!visited[arr.get(i)]) {
				dfs(visited, depth, arr.get(i), cnt+1);
			}
		}
		visited[start] = false;
	}
	public static int calPoint(int[] depth) {
		int max = Integer.MIN_VALUE;
		for(int i=1 ; i<depth.length ; i++) 
			max = depth[i]>max ? depth[i]:max;
		
		return max;
	}
	public static int calScore(int[] point) {
		int min = Integer.MAX_VALUE;
		for(int i=1 ; i<point.length ; i++) 
			min = Math.min(point[i], min);
		
		return min;
	}
}