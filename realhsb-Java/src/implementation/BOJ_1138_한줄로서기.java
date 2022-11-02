package implementation;


/*
 *  1	2	3	4
 *  2	1	1	0	자기가 위치한 자리에서 앞에 빈 칸이 몇 개 있는지, 이미 숫자가 있는 칸은 제외하고 카운트 
 *  ㅁ	ㅁ	1		: 1은 앞에 빈 칸 2개 
 *  ㅁ	2	1		: 2는 앞에 빈 칸 1개 
 *  ㅁ	2	1	3 	: 3은 앞에 빈 칸 1개 
 *  4	2	1	3	: 4는 앞에 빈 칸 0개 
 */

import java.util.Scanner;	// N의 범위가 1~10이길래 Scanner 사용 

public class BOJ_1138_한줄로서기 {
	static int N;			// 1 <= N <= 10
	static int count = 0;	// 자기 앞에 빈 자리가 몇 개인지 세는 변수
	static int[] left;		// 왼쪽에 몇 명 있었는지 담는 배열 
	static int[] answer;	// 줄 서는 위치 담는 배열 
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		left = new int[N+1];
		answer = new int[N+1];	
		
		for(int i = 1; i < N+1; i++) {	// 입력 정보 배열에 담기 
			left[i] = scan.nextInt();
		}
		
		for(int i = 1; i < N+1; i++) {
			int now = left[i];
			for(int j = 1; j < N+1; j++) {
				if(answer[j] != 0) continue;	// 이미 숫자가 있을 경우 continue 
				else if(now == count && answer[j] == 0) {
					answer[j] = i;
					break;
				}else if(answer[j] == 0) {
					count++;
				}
			}
			count = 0;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i < N+1; i++) {
			sb.append(answer[i] + " ");	// StringBuilder에 한 글자씩 담아서 출력 
		}
		System.out.println(sb.toString());
	}
}
