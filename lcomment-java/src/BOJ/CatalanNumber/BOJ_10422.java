package CatalanNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10422 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		long[] catalan = new long[2501];
		
		catalan[0] = 1;
		catalan[1] = 1;
		
		for(int i=2 ; i<2501 ; i++) {
			for(int j=1 ; j<=i ; j++) {
				catalan[i] += catalan[i-j] * catalan[j-1]; 
				catalan[i] %= 1_000_000_007;
			}
		}
		
		while(T-- > 0) {
			int L = Integer.parseInt(br.readLine());
			
			if(L%2 == 1)
				System.out.println(0);
			else
				System.out.println(catalan[L / 2]);
		}
	}

}
