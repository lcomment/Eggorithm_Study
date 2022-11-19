package Geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
 

public class BOJ_1002 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
	 
		while (T-- > 0) {
			int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
	 
			int x1 = input[0];
			int y1 = input[1];
			int r1 = input[2];
	 
			int x2 = input[3];
			int y2 = input[4];
			int r2 = input[5];
			
			System.out.println(tangent_point(x1, y1, r1, x2, y2, r2));
		}
	 
	}
	 
	// 접점 개수 구하는 함수
	public static int tangent_point(int x1, int y1, int r1, int x2, int y2, int r2) {
		int distance = (int)(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));	
	 
		if(x1 == x2 && y1 == y2 && r1 == r2) {
			return -1;
		}
		else if(distance > Math.pow(r1 + r2, 2)) {
			return 0;
		}
		else if(distance < Math.pow(r2 - r1, 2)) {
			return 0;
		}
		else if(distance == Math.pow(r2 - r1, 2)) {
			return 1;
		}
		else if(distance == Math.pow(r1 + r2, 2)) {
			return 1;
		}
		else {
			return 2;
		}
	}

}
