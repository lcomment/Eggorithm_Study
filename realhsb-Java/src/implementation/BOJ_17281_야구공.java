package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_17281_야구공 {
	static int N, answer;
	static boolean[] visited;	// 출전한 선수 목록 
	static int[] order; 		// 출전 선수 순서 , (1번 선수는 4번 타자 확정!)
	static int[][] scores;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		scores = new int[N][10];
		order = new int[10];
		visited = new boolean[10];
		
		StringTokenizer st;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= 9; j++) {
				scores[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		order[4] = 1;
		visited[1] = true;
		permutation(1);
		System.out.println(answer);
		
	}
	
	public static void permutation(int depth) {	// 순열 구하기 
		if(depth == 10) {
			baseball();
			return;
		}
		if(depth == 4) {
			permutation(depth+1);
			return;
		}
		for(int i = 1; i <= 9; i++) {
			if(visited[i]) {
				continue; // true 	// 이미 뽑은 숫자는 넘어가기 
			}
			visited[i] = true; 	// 뽑은 숫자는 true로 바꾸기 
			order[depth] = i;
			permutation(depth+1);
			visited[i] = false;
		}
	}
	
	public static void baseball() {
		int score = 0;
		int index = 1;	// 이닝이 끝나도 그 다음 순서의 선수가 출전 
		for(int i = 0; i < N; i++) {	// 경기 횟수(N)만큼 반복 
			int out = 0; 	// out 횟수 
			boolean[] ru = new boolean[4]; 	// 각 루에 선수가 존재하는지 확인 
			
			while(out < 3) {
				switch(scores[i][order[index]]) {	// 입력받은 점수 (scores), permutation 함수로 정한 순서대로 경기 진행. 3 out 되는 순간 이닝 종료 
					case 1 : // 안타 
						if(ru[3]) {		// 각 루마다 선수가 있는지 확인 후, 루 이동 및 점수 획득 
							score++;
							ru[3] = false;
						}
						if(ru[2]) {
							ru[3] = true;
							ru[2] = false;
						}
						if(ru[1]) {
							ru[2] = true;
						}
						ru[1] = true;	// 타자도 루에 갈 수 있다...! (빼먹은 부분)
						break;
						
					case 2 : // 2루타
						if(ru[3]) {		// 각 루마다 선수가 있는지 확인 후, 루 이동 및 점수 획득 
							score++;
							ru[3] = false;
						}
						if(ru[2]) {
							score++;
						}
						if(ru[1]) {
							ru[3] = true;
							ru[1] = false;
						}
						ru[2] = true;
						break;
						
					case 3 : // 3루타
						if(ru[3]) {		// 각 루마다 선수가 있는지 확인 후, 루 이동 및 점수 획득 
							score++;
						}
						if(ru[2]) {
							score++;
							ru[2] = false;
						}
						if(ru[1]) {
							score++;
							ru[1] = false;
						}
						ru[3] = true;
						break;
					
					case 4 : // 3루타
						if(ru[3]) {		// 각 루마다 선수가 있는지 확인 후, 루 이동 및 점수 획득 
							score++;
							ru[3] = false;
						}
						if(ru[2]) {
							score++;
							ru[2] = false;
						}
						if(ru[1]) {
							score++;
							ru[1] = false;
						}
						score++;
						break;
						
					case 0 : // 아웃
						out++;
						break;
				}
				index++;
				if(index > 9) index %= 9;
			}
		}
		
		answer = Math.max(score, answer);
	}
}
