package CatalanNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_4811 {
	static long[] catalan = new long[31];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		catalan[0] = 1;
		catalan[1] = 1;
		
		for(int i=2 ; i<31 ; i++) {
			for(int j=1 ; j<=i ; j++) {
				catalan[i] += catalan[i-j] * catalan[j-1];
			}
		}
		
		while(true) {
			int T = Integer.parseInt(br.readLine());
			
			if(T == 0)
				break;
			
			System.out.println(catalan[T]);
		}
	}

}
