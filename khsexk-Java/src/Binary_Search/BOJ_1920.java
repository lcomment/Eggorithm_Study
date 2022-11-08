package Binary_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1920 {
	static int N, M;
	static int[] seq, search;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		seq = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(seq);
		M = Integer.parseInt(br.readLine());
		search = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		for(int s : search) {
			int result = Arrays.binarySearch(seq, s);
			
			if(result >=0) System.out.println(1);
			else System.out.println(0);
		}
	}

}
