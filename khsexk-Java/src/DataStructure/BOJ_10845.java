package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class BOJ_10845 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Deque<Integer> deque = new LinkedList<>();
		
		while(N-- > 0) {
			String[] input = br.readLine().split(" ");
			
			switch(input[0]) {
				case "push":
					deque.offer(Integer.parseInt(input[1]));
					break;
					
				case "front":
					System.out.println( (!deque.isEmpty()) ? deque.peekFirst():-1);
					break;
					
				case "back":
					System.out.println( (!deque.isEmpty()) ? deque.peekLast():-1);
					break;
					
				case "pop":
					System.out.println( (!deque.isEmpty()) ? deque.poll():-1);
					break;
					
				case "empty":
					System.out.println( (deque.isEmpty()) ? 1:0 );
					break;
					
				case "size":
					System.out.println(deque.size());
					break;
					
			} // switch-case
		} // while

	}

}
