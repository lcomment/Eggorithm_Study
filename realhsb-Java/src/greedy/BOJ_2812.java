package greedy;

//BOJ - 2812번 크게 만들기 

import java.util.Scanner;
import java.util.Stack;

public class BOJ_2812 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		String[] S = sc.nextLine().split(" ");

		int N = Integer.parseInt(S[0]);
		int K = Integer.parseInt(S[1]);
		
		char[] C = sc.nextLine().toCharArray();

		int count = 0;
		int num = 0;
		
		for(int i = 0; i < N; i++) {
			num = C[i]-'0';
			if(stack.empty() || count == K) {	// 스택이 비어있거나, 지워야할 글자 수를 만족하면 스택에 문자 더하기 
				stack.add(num);
			}else {
				if(stack.peek() < num ) {		// 새로 추가될 숫자가 스택 peek()보다 크면 pop 계속 실시 
					while(!stack.empty() && count < K) {	// 스택이 비어있거나 count를 다 채우면 중지 
						if(stack.peek() >= num) break;		// 여기 조건문이 이상해요,,,,,, 
						stack.pop();
						count++;						
					}
				}
             stack.add(num);
			}
		}
		
		while(count != K) {
			stack.pop();
			count++;
		}
		// 54
	
		for(int i = 0; i < stack.size(); i++) {
			sb.append(stack.get(i));
		}
		System.out.println(sb.toString());
	}
}

// 10 4
// 4177252841

// 775841
