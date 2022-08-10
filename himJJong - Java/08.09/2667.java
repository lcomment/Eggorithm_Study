package chapter2;

import java.util.*;
import java.io.*;

public class TypeInference {
	static int arr[][];
	static boolean visit[][];
	static int dirX[] = {0, 0, -1, 1};	//x축 
	static int dirY[] = {-1, 1, 0, 0};  //y축 

	static int count = 0, number = 0;
	static int nowX, nowY, N;			//범위를 계산한 좌표를 담을 변수 

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		List<Integer> list = new ArrayList<>();

		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visit = new boolean[N][N];

		for(int i=0; i<N; i++) {		//배열 담기 
			String str = br.readLine();

			for(int j=0; j<N; j++) {				
				arr[i][j] = Character.getNumericValue(str.charAt(j));
			}
		}

		for(int i=0; i<N; i++) {								// 전체 돌거임 이게 방문하지 않고 1인 값을 찾으러 
			for(int j=0; j<N; j++) {

				if(visit[i][j] == false && arr[i][j] == 1) {	//방문하지 않고, 값이 1인경우 
					count = 0;
					number++;									//단지 정보일 때 마다 +1 
					DFS(i, j);									//DFS들어가서 근접 1 모두 찾고 나오는거 
					list.add(count);						 	//각 단지 count 세기  
				}

			}
		}
		Collections.sort(list);
		bw.append(number + "\n");	//단지 전체 개수 
		for(int num : list) {
			bw.append(num + "\n"); //단지에 따른 합의 개수 
		}

		bw.flush();
		bw.close();		
	} // End of main

	static void DFS(int x, int y) {
		visit[x][y] = true;
		arr[x][y] = number;
		count ++;

		for(int i=0; i<4; i++) {
			nowX = dirX[i] + x;
			nowY = dirY[i] + y;

			if(Range_check() && visit[nowX][nowY] == false && arr[nowX][nowY] == 1) {
				visit[nowX][nowY] = true;
				arr[nowX][nowY] = number;

				DFS(nowX, nowY);
			}
		}		

	} // End of DFS

	static boolean Range_check() {
		return (nowX >= 0 && nowX < N && nowY >= 0 && nowY < N);  //미리 앞뒤를 검사하는거기 때문에 범위내에 있어야 함.
	} 
} 
