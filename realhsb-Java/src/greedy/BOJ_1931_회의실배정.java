package greedy;

// BOJ 1931 회의실 배정

/*
 * 첫째 줄에 회의의 수 N(1 ≤ N ≤ 100,000)
 * 둘째 줄부터 N+1 줄까지 각 회의의 정보
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

// BOJ 1931 회의실 배정 

/*
 * 사용한 반례
 *	3
	4 4
	4 4
	1 4

	기댓값 3
 * 
 */

public class BOJ_1931_회의실배정 {
	
	static int N, endTime, ans;
	static PriorityQueue<Time> p_queue;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		p_queue = new PriorityQueue<Time>();
		
		N = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			p_queue.add(new Time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
//		while (!p_queue.isEmpty()) {
//			Time t = p_queue.poll();
//			System.out.println(t.start + " " + t.end);
//		}
		
		endTime = 0;
		
		while (!p_queue.isEmpty()) {
			Time t = p_queue.poll();
			if (endTime <= t.start) {
				endTime = t.end;
				ans++;
			}
		}
		
		System.out.println(ans);
		
	}
	
	private static class Time implements Comparable<Time> {
		int start, end;
		public Time(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		// 회의 종료가 빠른 순서대로 오름차순 0, 1, 2 ...
		@Override
		public int compareTo(Time o) {	// 조건 제대로 쓰기 ,,, 
			// 단, 종료 시각이 같을 경우, 시작 시각이 빠른 순서대로 정렬 
			if(this.end == o.end) return this.start - o.start;
			return this.end - o.end;
		}
	}
}
