package Dfs_Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_14226 {
	static int S;
	static boolean[][] visited = new boolean[1001][1001];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		S = Integer.parseInt(br.readLine());
		
		bfs();
	}
	static void bfs() {
		Queue<Emoticon> q = new LinkedList<>();
		q.offer(new Emoticon(1, 0, 0));
		visited[0][1] = true;
		
		while(!q.isEmpty()) {
			Emoticon e = q.poll();
			
			if(e.emo == S) {
				System.out.println(e.sec);
				break;
			}
			
			// 복사 
			q.offer(new Emoticon(e.emo, e.emo, e.sec + 1));
			
			// 붙여넣기 
			if(e.emo > 0 && e.emo + e.clip <= S && !visited[e.clip][e.emo + e.clip]) {
				visited[e.clip][e.emo + e.clip] = true;
				q.offer(new Emoticon(e.emo + e.clip, e.clip, e.sec + 1));
			}
			if(e.emo > 0 && !visited[e.clip][e.emo - 1]) {
				visited[e.clip][e.emo - 1] = true;
				q.offer(new Emoticon(e.emo-1, e.clip, e.sec + 1));
			}
		}
		
	}
	
	static class Emoticon {
		int emo;
		int clip;
		int sec;
		
		Emoticon(int emo, int clip, int sec){
			this.emo = emo;
			this.clip = clip;
			this.sec = sec;
		}
	}
}
