package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_12919 {
	static String S = "";
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		S = br.readLine();
		String T = br.readLine();
		
		boolean check = check(T);
		System.out.println(check ? 1:0);
	}
	static boolean check(String T) {
		if(S.length() >= T.length()) {
			if(S.equals(T)) {
				return true;
			}
			return false;
		}
		
		boolean flag1 = false;
		boolean flag2 = false;
		if(T.charAt(0) == 'B') {
			flag1 = check(new StringBuilder(T.substring(1)).reverse().toString());
		}
		if(T.charAt(T.length()-1) == 'A') {
			flag2 = check(T.substring(0, T.length()-1));
		}
		
		return (flag1 || flag2);
	}
}
