package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BOJ_1620 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		HashMap<String, Integer> stringSearch = new HashMap<>();
		String[] numberSearch = new String[N];
		
		for(int i=0 ; i<N ; i++) {
			String s = br.readLine();
			
			stringSearch.put(s, i+1);
			numberSearch[i] = s;
		}
		
		for(int j=0 ; j<M ; j++) {
			String quiz = br.readLine();
			
			char c = quiz.charAt(0);
			
			if(c>=65 && c<=90) // 문자열 입력 
				System.out.println(stringSearch.get(quiz));
			else // 숫자 입력 
				System.out.println(numberSearch[Integer.parseInt(quiz)-1]);
		} // for_j
		
		
		// 문자열 탐색에는 HashMap이 가장 빠름 (List는 시간초과) 
		/*
		ArrayList<String> pocketmonBook = new ArrayList<>();
		
		for(int i=0 ; i<N ; i++)
			pocketmonBook.add(br.readLine());
		
		for(int j=0 ; j<M ; j++) {
			String quiz = br.readLine();
			
			char c = quiz.charAt(0);
			
			if(c<65 || c>90) 
				System.out.println(pocketmonBook.get(Integer.parseInt(quiz)-1));
			else 
				System.out.println(pocketmonBook.indexOf(quiz) + 1);
		} // for_j
		*/
	}
}