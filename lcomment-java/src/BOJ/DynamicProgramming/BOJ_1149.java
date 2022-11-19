package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1149 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] rgbHouse = new int[N][3];
		
		for(int i=0 ; i<N ; i++) {
			String[] input = br.readLine().split(" ");
			
			rgbHouse[i][0] = Integer.parseInt(input[0]);
			rgbHouse[i][1] = Integer.parseInt(input[1]);
			rgbHouse[i][2] = Integer.parseInt(input[2]);
		}
		
		for(int i=1 ; i<N ; i++) {
			rgbHouse[i][0] += Math.min(rgbHouse[i-1][1], rgbHouse[i-1][2]);
			rgbHouse[i][1] += Math.min(rgbHouse[i-1][0], rgbHouse[i-1][2]);
			rgbHouse[i][2] += Math.min(rgbHouse[i-1][0], rgbHouse[i-1][1]);
		} // for_i
		
		System.out.println(Math.min(Math.min(rgbHouse[N-1][0], rgbHouse[N-1][1]), rgbHouse[N-1][2]));
	}
}