package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_21310 {
	static String S = "";
	static int zero=0, one=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		S = br.readLine();
		
		for(int i=0 ; i<S.length() ; i++) {
			char c = S.charAt(i);
			
			if(c == '0') zero++;
			else one++;
		}
		
		zero /= 2;
		one /= 2;
		
		StringBuilder sb = new  StringBuilder(S);
		
		int idx = 0;
		for(int i=0 ; i<S.length(); i++) {
			if(one == 0)
				break;
			if(sb.charAt(idx) == '1') {
				sb.deleteCharAt(idx);
				one--;
				continue;
			}
			idx++;
		}
		
		int start = sb.length() - 1;
		idx = sb.length();
		for(int i=start ; i>=0 ; i--) {
			if(zero == 0)
				break;
			if(sb.charAt(i) == '0') {
				sb.deleteCharAt(i);
				zero--;
				continue;
			}
		}
		
		System.out.println(sb.toString());
	}

}
