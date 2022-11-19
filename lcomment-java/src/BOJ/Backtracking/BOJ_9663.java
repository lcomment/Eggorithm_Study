package Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9663 {
	static int[] board;
	static int N;
    static int count = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		board = new int[N];
		
		backtracking(0);
		
		System.out.println(count);
	}
	
	static void backtracking(int depth) {
		if(depth == N) {
			count++;
			return;
		}
		
		for(int i=0 ; i<N ; i++) {
			board[depth] = i;
			
			if(checkAttack(depth))
				backtracking(depth + 1);
		}
	}
	
	static boolean checkAttack(int depth) {
		for(int i=0 ; i<depth ; i++) {
			if(board[depth] == board[i])
				return false;
			
			/*
			 * 대각선상에 놓여있는 경우
			 * (열의 차와 행의 차가 같을 경우가 대각선에 놓여있는 경우다)
			 */
			else if (Math.abs(depth - i) == Math.abs(board[depth] - board[i])) 
				return false;
		}
		return true;
	}

}
