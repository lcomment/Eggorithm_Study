package greedy;

// BOJ 1946 신입사원 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_1946_신입사원 {
	static int T, N;
	static ArrayList<Applicant> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			list = new ArrayList<>();
			N = Integer.parseInt(br.readLine());
			StringTokenizer st;
			for(int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list.add(new Applicant(a, b));
			}
			
			Collections.sort(list);		// 서류점수로 내림차순 정렬 
			
//			for(Applicant a : list) {
//				System.out.println("a : " + a.a + " b : " + a.b);
//			}
			
			int answer = 1;
			int min = list.get(0).b;
			for(int k = 1; k < N; k++) {
				if(min > list.get(k).b) {
					answer++;
					min = list.get(k).b;
				}
			}
			System.out.println(answer);
		}
		
	}
	
	static class Applicant implements Comparable<Applicant> {
		int a, b;
		public Applicant(int a, int b) {
			this.a = a;
			this.b = b;
		}
		
		@Override
		public int compareTo(Applicant o) {
			
			if(this.a > o.a  ) {
				return 1;
			}else {
				return -1;
			}
		}
	}

}
