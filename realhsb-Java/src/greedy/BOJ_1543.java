package greedy;

// BOJ - 1543번 문서 검색 

import java.util.Scanner;

public class BOJ_1543 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] C = sc.nextLine().toCharArray();
		char[] word = sc.nextLine().toCharArray();
		
		int i = 0; 
		int answer = 0;
		int count = 0;
		
		while(i < C.length - word.length + 1) {
			if(C[i] == word[0]) {	// 첫 글자가 같을 경우 따라오는 글자들도 같은지 확인 
				while(count < word.length && C[i+count] == word[count]) {
					count++;
				}
				if(count == word.length) {	// 겹치는 글자 수가 같으면 answer++ 
					answer++;
					i += count;
				}else {			// 중간에 틀렸을 경우, 다음 문자로 넘어감 
					i++;
				}
				count = 0;		// count = 0로 초기화 
			}else {
				i++;			// 첫글자부터 다를 경우, 다음 글자로 넘어감 
			}
			
		}
		System.out.println(answer);
	}
}
