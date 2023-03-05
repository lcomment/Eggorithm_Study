package dp;

/*	
 * (앞 문자 + 뒷 문자)로 숫자를 만들 수 있을 때 -> DP[i] = DP[i-1] + DP[i-2]
 * 								없을 때 -> DP[i] = DP[i-1]
 * 							 0이 나올 때 -> DP[i-1] 앞자리가 1, 2일 때만 가능, DP[i] = DP[i-2] 
 * 												다른 숫자면 잘못된 문자열이므로, 0 출력 		
 *  사용한 반례 : 121074110 | 정답 : 2				
 */

import java.util.Scanner;

public class BOJ_2011_암호코드 {
	static long[] DP;
	static long answer;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		answer = 0;
		DP = new long[s.length() + 1];
		
		DP[0] = DP[1] = 1;
		System.out.println(dp(s));
	}
	
	static long dp(String s) {
		if(s.charAt(0) == '0') return 0;
		char prev = ' ';
		char now = ' ';
		
		for(int i = 2; i < s.length() + 1; i++) {
			prev = s.charAt(i-2);
			now = s.charAt(i-1);
			
			if(now == '0') {
				if(prev == '1' || prev == '2') {
					DP[i] = DP[i-2] % 1000000;
				}else {
					return 0;
				}
			}else {
				int num = (prev - '0') * 10 + (now - '0');
				if(num < 10 || num > 26) DP[i] = DP[i-1] % 1000000;
				else DP[i] = (DP[i-1] + DP[i-2]) % 1000000;
			}
		}
		answer = DP[s.length()] % 1000000;
		for(int i = 0; i < DP.length; i++) {
			System.out.println("DP " + i + " : " + DP[i]);
		}
		return answer;
	}
}
