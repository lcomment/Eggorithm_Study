package greedy;

// BOJ - 13904번 과제 

import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_13904 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = Integer.parseInt(sc.nextLine());
		int scores[] = new int[1001];
		
		PriorityQueue<Assignment> pq = new PriorityQueue<>();
		
		for(int i = 0; i < N; i++) {
			String s[] = sc.nextLine().split(" ");
			pq.add(new Assignment(Integer.parseInt(s[0]), Integer.parseInt(s[1])));
		}
		
		
//		4 60
//		2 50
//		4 40
//		3 30
//		1 20
//		4 10
//		6 5
		
		for(int i = 0; i < N; i++) {	// 최대한 마감일에 과제를 하는 거로 
			Assignment as = pq.poll();	// 1. 점수가 높은 순, 2. 점수가 같다면 마감일이 짧은 순 
			for(int j = as.day; j >= 1; j--) {
				if(scores[j] == 0) {	// 마감 날에 아무것도 하지 않으면 대입 
					scores[j] = as.score;
					break;
				}else {
					if(scores[j] < as.score) {	
						scores[j] = as.score;
						break;
						/*
						 * 마감날에 하기로 한 과제가 있을 때, 새로 넣을 과제의 점수가 더 크면 대입
						 * (day = 3, score = 30)가 첫 번째 날(scores[1])에 하기로 되어있음 
						 * (day = 1, score = 20) < (day = 3, score = 30) 이므로 score[1]에는 30점 과제 유지 
						 */
						
					}
				}
			}
		}
		
		int answer = 0;
		for(int i = 1; i < 1001; i++) {
			answer += scores[i];
		}
		System.out.println(answer);
	}
}

class Assignment implements Comparable<Assignment>{
	int day;
	int score;
	
	Assignment(int day, int score){
		this.day = day;
		this.score = score;
	}
	
	@Override
	public int compareTo(Assignment o) {
		if(this.score == o.score) {	// 점수가 같으면 마감 기한이 더 짧은 순으로 
			return this.day - o.day;
		}else {
			return o.score - this.score;	// 점수가 더 높은 순으로 
		}
	}
}