package kmp;

// BOJ 16916 부분 문자열 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BOJ_16916 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();	//
		String P = br.readLine();
		
		System.out.println(KMP(S, P));
	}
	
	static int KMP(String S, String P) {
		int[] table = makeTable(P);
		
		int sLen = S.length();
		int pLen = P.length();
		
		int idx = 0;	// 현재 대응되는 글자 수
		for(int i = 0; i < sLen; i++) {
			// idx번 글자와 
			// 현재 대응된 글자의 수를 table[idx-1]번으로 줄인다
			while(idx > 0 && S.charAt(i) != P.charAt(idx)) {
				idx = table[idx-1];
			}
			// 글자가 대응될 경우
			if(S.charAt(i) == P.charAt(idx)) {
				if(idx == pLen - 1) {
					idx = table[idx];
					return 1;
				}else {
					idx++;
				}
			}
		}
		return 0;
	}
	
	static int[] makeTable(String P) {
		int n = P.length();
		int[] table = new int[n];
		
		int idx = 0;
		for(int i = 1; i < n; i++) {	// 일치하는 문자가 발생했을 때, (idx > 0, 연속적으로 더 일치하지 않으면 idx = table[idx-1]로 돌려준다.
			while(idx > 0 && P.charAt(i) != P.charAt(idx)) {
				idx = table[idx-1];
			}
			if(P.charAt(i) == P.charAt(idx)) {
				idx += 1;
				table[i] = idx;
			}
		}
		return table;
	}
}