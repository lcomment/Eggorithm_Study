package Geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_11758 {
	static class Point {
		int x, y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		Point[] p = new Point[3];
		
		for(int i=0 ; i<3 ; i++) {
			int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			p[i] = new Point(input[0], input[1]);
		}
		
		System.out.println(ccw(p[0], p[1], p[2]));
	}
	static int ccw(Point A, Point B, Point C) {
		int a = A.x*B.y + B.x*C.y + C.x*A.y;
		int b = A.y*B.x + B.y*C.x + C.y*A.x;
		
		if(a-b > 0)
			return 1;
		else if(a-b < 0)
			return -1;
		else
			return 0;
	}
}
