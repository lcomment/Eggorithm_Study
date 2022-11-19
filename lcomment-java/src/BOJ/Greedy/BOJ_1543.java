package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1543 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String word = br.readLine();
		
		int cnt = 0;
		
		while(str.contains(word)) {
			int idx = str.indexOf(word);
			if(idx == 0) str = str.substring(idx+word.length());
			else str = str.substring(idx+word.length());
			
			cnt++;
		} // while-str
		System.out.println(cnt);
	}
}