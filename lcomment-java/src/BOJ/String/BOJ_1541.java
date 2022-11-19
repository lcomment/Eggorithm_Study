package String;

import java.io.*;

public class BOJ_1541 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int plus = 0, minus = 0;
		
		for(int i=0 ; i<s.length() ; i++) {
			char c = s.charAt(i);
			
			if(c == '-') {
				String num = "";
				for(int j=i+1 ; j<s.length() ; j++) {
					char n = s.charAt(j);
					if('0' <= n && n <= '9')
						num += n;
					else {
						minus += Integer.parseInt(num);
						num = "";
					}
				}
				minus += Integer.parseInt(num);
				break;
			} // if_minus
			else {
				String num = "";
				int cnt = -1;
				for(int j=i ; j<s.length() ; j++) {
					char n = s.charAt(j);
					
					if('0' <= n && n <= '9') {
						num += n;
						cnt++;
					}
					else if(n == '+') {
						plus += Integer.parseInt(num);
						num = "";
						cnt++;
					}
					else 
						break;
				}
				plus += Integer.parseInt(num);
				i += cnt;
			}
		} // for_i
		System.out.println(plus-minus);
	}

}