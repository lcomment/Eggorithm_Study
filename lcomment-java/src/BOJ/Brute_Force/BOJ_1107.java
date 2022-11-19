package Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1107 {
	static final int p = 100;
	static String N;
	static int M;
	static boolean[] brokenBtn = new boolean[11];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = br.readLine();
		M = Integer.parseInt(br.readLine());
		
		if(M != 0) {
			int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
			for(int i=0 ; i<M ; i++) {
				brokenBtn[input[i]] = true;
			}
		}
		
		
		int result = Math.abs(p - Integer.parseInt(N));
		for(int i=0 ; i<=1000000 ; i++) {
			boolean flag = true;
			String s = String.valueOf(i);
			
			for(int j=0 ; j<s.length() ; j++) {
				int num = Character.getNumericValue(s.charAt(j));
				if(brokenBtn[num]) {
					flag = false;
					break;
				}
			} // for_j
			
			if(flag) {
				int res = s.length() + Math.abs(i - Integer.parseInt(N));
				result = Math.min(result, res);
			}
		}
		
		System.out.println(result);
	} 

}
