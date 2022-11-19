package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1205 {
	static int N, score, P;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] NSP = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		N = NSP[0];
		score = NSP[1];
		P = NSP[2];
		
		if(N==0) {
			System.out.println(1);
			System.exit(0);
		}
			
		
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		int rank = 1;
		int cnt = 1;
		for(int i=0 ; i<input.length ; i++) {
			if(input[i] > score) {
				rank++;
				cnt++;
			} else if(input[i] == score){
				if(i+2 <= P) {
					cnt++;
				} else {
					System.out.println(-1);
					System.exit(0);
				}
			}
		}
		
		if(cnt <= P)
			System.out.println(rank);
		else
			System.out.println(-1);
	}

}
