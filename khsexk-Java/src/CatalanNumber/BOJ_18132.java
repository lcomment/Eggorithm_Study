package CatalanNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_18132 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long[] catalan = new long[5002];
		
		catalan[0] = 1;
		catalan[1] = 1;
		
		for(int i=2 ; i<5002 ; i++) {
			for(int j=1 ; j<=i ; j++) {
				catalan[i] += catalan[i-j] * catalan[j-1];
				catalan[i] %= 1000000007;
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			int input = Integer.parseInt(br.readLine());
			
			System.out.println(catalan[input + 1]);
		}
	}

}
