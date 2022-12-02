package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1339 {
	static String[] wordList;
	static int[] alphabet = new int[26];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		wordList = new String[N];
		
		for(int i=0; i<N ; i++) wordList[i] = br.readLine();
		
		for(int i=0 ; i<N ; i++) {
			int len = wordList[i].length();
			int digit = (int)Math.pow(10, len - 1);
			
			for(int j=0 ; j<len ; j++) {
				alphabet[wordList[i].charAt(j) - 'A'] += digit;
				digit /= 10;
			}
		}
		
		Arrays.sort(alphabet);
		
		int num = 9;
		int result = 0;
		for(int i=alphabet.length-1 ; i>=0 ; i--) {
			int alpha = alphabet[i];
			
			if(alpha == 0) break;
			
			result += (alpha * num--);
		}
		
		System.out.println(result);
	}

}
