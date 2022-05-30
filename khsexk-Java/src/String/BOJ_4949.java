package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_4949 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		
		while(!(s=br.readLine()).equals(".")) {
			Stack<Character> stack = new Stack<>();
			boolean flag = true;
			
			for(int i=0 ; i<s.length() ; i++) {
				char c = s.charAt(i);
				
				switch(c) {
					case '(':
						stack.push(c);
						break;
					case ')':
						if(stack.isEmpty() || stack.peek() != '(') flag = false;
						else stack.pop();
						break;
					case '[':
						stack.push(c);
						break;
					case ']':
						if(stack.isEmpty() || stack.peek() != '[') flag = false;
						else stack.pop();
						break;
					default:
						break;
				} // switch-c
				if(!flag) {
					break;
				}
			} // for_i
			if(stack.isEmpty() && flag){
				System.out.println("yes");
			}
			else
				System.out.println("no");
		} // while-"."
	}
}
