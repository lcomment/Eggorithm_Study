package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9935 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s= br.readLine();
		String bomb = br.readLine();
		
		StringBuilder sb = new StringBuilder();
		Stack<Character> st = new Stack<>();
		
		for(int i=0 ; i<s.length() ; i++) {
			st.push(s.charAt(i));
			
			// stack의 길이가 bomb의 길이보다 크거나 같을 때 폭발 문자열 탐색 
			if(st.size() >= bomb.length()) {
				boolean flag = true;
				
				for(int j=0 ; j<bomb.length(); j++) {
					if(st.get(st.size() - bomb.length() + j) != bomb.charAt(j)) {
						flag = false;
						break;
					}
				} // for_j
				if(flag) {
					for(int k=0 ; k<bomb.length() ; k++)
						st.pop();
				}
			} // if_st
		} // for_i
		
		for(char c: st) {
			sb.append(c);
		}
		System.out.println( (sb.length() != 0) ? sb.toString():"FRULA" );
	}
}