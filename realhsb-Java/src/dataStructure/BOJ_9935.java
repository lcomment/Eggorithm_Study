package dataStructure;

// BOJ - 9935번 문자열 폭발 (미완성)

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class BOJ_9935 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 문자열을 담을 stack
		Stack<Character> stack = new Stack<>();
		
		// 입력 받을 문자열 
		String str = br.readLine();
		char[] strArr = str.toCharArray();
		
		// 폭발 문자열  
		char[] bombArr = br.readLine().toCharArray();
		

		
		// 외 않됌 
		
		// stack의 커서 (폭발 문자열이 있어서 pop하면 커서도 똑같이 감소, 마지막 요소의 인덱스?) 
		int cursor = -1;
		for(int i = 0; i < strArr.length; i++) {
			
			// 스택에 요소를 하나씩 더해줌 
			stack.add(strArr[i]);
			// 스택의 마지막 요소를 가리키는 커서 
			cursor++;
			
			// 스택의 크기가 폭발문자열의 크기보다 크거나 같을 때 검사 
			if(stack.size() >= bombArr.length) {
				
				// count 는 폭발문자열을 뒤에서부터 가리키는 용도 
				int count = bombArr.length -1;
				
				boolean isSame = true;
				int cur = cursor;
				
				// 스택 마지막 요소에서 시작해서 폭발문자열의 길이만큼 검사 
				while(count > 0) {
					if(stack.get(cur) != bombArr[count]) {
						isSame = false;
						break;
					}
					cur--;
					count--;
				}
				
				// 폭발문자열이 있는 것이 확인되면 pop 진행 
				if(isSame) {
					for(int j = 0; j < bombArr.length; j++) {
						stack.pop();
						cursor--;
					}
				}
				
			}
		}
		if(stack.isEmpty()) {
			sb.append("FRULA");
		}else {
			for(int i = 0; i < stack.size(); i++) {
				sb.append(stack.get(i));
			}
		}
		System.out.print(sb.toString());
	}
}