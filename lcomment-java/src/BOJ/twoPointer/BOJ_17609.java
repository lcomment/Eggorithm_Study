package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_17609 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			String input = br.readLine();
			
			sb.append(check(input, 0, 0, input.length()-1)+"\n");
		}
		
		System.out.println(sb.toString());
	}
	static int check(String s, int cnt, int start, int end) {
		if(cnt >= 2)
			return 2;
		
		while(start <= end) {
			if(s.charAt(start) == s.charAt(end)) {
				start++;
				end--;
			} else {
				// case : abccbca
				cnt = Math.min(check(s, cnt+1, start+1, end), check(s, cnt+1, start, end-1));
				break;
			}
		}
		
		return cnt;
	}
}
