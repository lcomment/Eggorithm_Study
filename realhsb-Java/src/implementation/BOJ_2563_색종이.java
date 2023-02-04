package implementation;

// BOJ 2563 색종이 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_2563_색종이 {
	static int N;
	static int count;
	static int[][] array;
	static boolean[][] paper;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		count = 0;
		paper = new boolean[100][100];	// 흰 도화지 배열 
		array = new int[N][2];			// 검은색종이 배열 
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			array[i][0] = Integer.parseInt(st.nextToken());
			array[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// 맞히고도 찝찝한 3중 for문 ,,,
		
		// 흰 도화지에 이미 색종이가 붙어있으면 true, 비어있으면 false 
		for(int i = 0; i < N; i++) {
			for(int j = array[i][0]; j < array[i][0] + 10; j++) {
				for(int k = array[i][1]; k < array[i][1] + 10; k++) {
					if (!paper[j][k]) {	// false일 경우 (비어있음)
						paper[j][k] = true;	// true로 바꾸고 count 1 증가 
						count++;
					}
				}
			}
		}
		
		System.out.println(count);
	}
}
