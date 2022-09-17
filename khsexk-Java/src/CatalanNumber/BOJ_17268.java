package CatalanNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_17268 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long[] catalan = new long[5001];
		
		catalan[0] = 1;
		catalan[1] = 1;

		for(int i=2; i<5001 ; i++) {
			for(int j=1 ; j<=i ; j++) {
				catalan[i] += catalan[i-j] * catalan[j-1];
			}
			catalan[i] /= 987654321;
		}
		
		int n = Integer.parseInt(br.readLine());
		
		System.out.println(catalan[n/2]);
	}

}
