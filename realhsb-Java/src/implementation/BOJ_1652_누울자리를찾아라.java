package implementation;

// BOJ 1652 누울 자리를 찾아라 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BOJ_1652_누울자리를찾아라 {
	static int N, cnt;
	static char[][] field;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		field = new char[N+1][N+1];
		
		for(int i = 0; i < N; i++) {
			field[i] = br.readLine().toCharArray();
		}
		
		int width = 0, height = 0;
		cnt = 0;
		
		// 가로 
		for(int i = 0; i < N; i++) {
			cnt = 0;
			for(int j = 0; j < N; j++) {
				if(field[i][j] == '.') cnt++;		// 누울 공간이 있을 경우 1 증가 
				else if(field[i][j] == 'X') cnt = 0;
				if(cnt == 2) {	// 한 줄에 2칸 이상인 부분이 있으면 카운트! ex) ..X.. 이 경우에는 자리가 2군데 있음.
					width++;
				}
			}
		}
		
		// 세로 
		for(int j = 0; j < N; j++) {
			cnt = 0;
			for(int i = 0; i < N; i++) {
				if(field[i][j] == '.') cnt++;
				else if(field[i][j] == 'X') cnt = 0;
				if(cnt == 2) {
					height++;
				}
			}
		}
		
		System.out.println(width + " " + height);
	}
}
