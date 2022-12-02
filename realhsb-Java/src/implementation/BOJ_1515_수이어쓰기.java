package implementation;

/*
 *  input : 234092 
 *  2 3 4 0 9 2
 *  n : 1에서 시작, 1씩 증가하면서 n의 자릿수와 input의 각 자릿수 비교
 *  1, 2(n의 일의 자리 포함), 3(일의 자리 포함), 4(일의 자리 포함), 5(일의 자리 포함), ... , 10(일의 자리 포함), ... , 19(일의 자리 포함), 20(십의 자리 포함)
 *  이때, 비교하는 수의 각 자릿수를 비교해서 같은 숫자가 있는 경우, input의 index 증가 (n을 String으로 바꾼 뒤, charAt()으로 각 자릿수 접근) 
 *  겹치는 게 더이상 없을 경우 n 1증가 

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1515_수이어쓰기 {
	static String input;			// 입력 받을 수, 최대  3,000자리 
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // Scanner 쓸까 고민했음 최대 3000자리라길래 버퍼로 바꿈. 
		input = br.readLine();
		int n = 1;		// 1 <= n <= N
		int index = 0;	// input의 인덱스		1 ~ 3,000
		while(index <= input.length()) {
			
			String s = String.valueOf(n);			// String.valueOf(n) : int인 n을 String으로 변환하는 메소드 

			for(int i = 0; i < s.length(); i++) {	// s 바꾼 뒤, 각 자릿수와 을 비교 
				if((int)s.charAt(i) == (int)input.charAt(index)) {
					index++;
				}
				if(index == input.length()) {		// input의 각 자릿수를 다 돌았으면 n 출력 
					System.out.println(n);
					return;
				}
			}
			n++;
		}
		
	}
}
