package dataStructure;

// BOJ - 2504번 괄호의 값 
// 22.07.12.

import java.util.Stack;
import java.util.Scanner;

public class BOJ_2504 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] charArr = sc.nextLine().toCharArray();
		int answer = 0;
		int tmp = 1;
		Stack<Character> stack = new Stack<>();
		
		
		for(int i = 0; i < charArr.length; i++) {
			char c = charArr[i];
			
			if(c == '(') {
				stack.push(c);
				tmp *= 2;
			}else if(c == '[') {
				stack.push(c);
				tmp *= 3;
			}else if(c == ')') {
				if(stack.peek() == '[' || stack.isEmpty()) {
					answer = 0;
					break;
				}
				if(charArr[i-1] == '(') {
					answer += tmp;
				}
				stack.pop();
				tmp /= 2;
			}else {	// ]
				if(stack.peek() == '(' || stack.isEmpty()) {
					answer = 0;
					break;
				}
				if(charArr[i-1] == '[') {
					answer += tmp;
				}
				stack.pop();
				tmp /= 3;
			}
			
		}
		if(stack.isEmpty()) {
			System.out.println(answer);
		}else {
			System.out.println(0);
		}
	}
}
