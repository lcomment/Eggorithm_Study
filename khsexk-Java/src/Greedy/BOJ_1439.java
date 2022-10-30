package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1439 {
	static int zero=0, one=0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] input = br.readLine().toCharArray();
		
		int flag = Character.getNumericValue(input[0]);
		countGroup(flag);
		
		for(int i=1 ; i<input.length ; i++) {
			if(Character.getNumericValue(input[i]) == flag) continue;
			flag = Character.getNumericValue(input[i]);
			countGroup(flag);			
		}
		
		System.out.println(Math.min(zero, one));
	}
	static void countGroup(int flag) {
		if(flag == 0) zero++;
		else one++;
	}
}
