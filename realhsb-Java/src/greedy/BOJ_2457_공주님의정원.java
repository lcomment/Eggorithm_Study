package greedy;

// BOJ 2457 공주님의 정원 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class BOJ_2457_공주님의정원 {
	
	static int N, max, ans;
	static Flower[] flowers;
	static final int START = 301;
	static final int END = 1130;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		flowers = new Flower[N];
		ans = 0;
		
		int start, end = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken()) * 100 + Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken()) * 100 + Integer.parseInt(st.nextToken());
			flowers[i] = new Flower(start, end);
		}
		
		Arrays.sort(flowers);
		
		start = 301;
		max = 0;
		int index = 0;
		while (start < 1201) {
			boolean isFound = false;
			for(int i = index; i < N; i++) {
				if(flowers[i].start > start) break;
				else if(flowers[i].end > max) {
					isFound = true;
					max = flowers[i].end;
					index = i + 1;
				}
			}
			
			if(isFound) {
				start = max;
				ans++;
				
			} else break;
		}
		if(max < 1201) ans = 0;
		System.out.println(ans);
	}
	
	private static class Flower implements Comparable<Flower> {
		int start, end;
		
		public Flower(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		// 1. 피는 날 빠른 순 (start 기준 오름차순)
		// 2. 지는 날 느린 순 (end 기준 내림차순)
		
		@Override
		public int compareTo(Flower o) {
			if (this.start == o.start) return o.end - this.end;
			else return this.start - o.start;
		}
	}
}
