package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ_1141 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] words = new String[N];
		
		for(int i=0 ; i<N ; i++)
			words[i] = br.readLine();
		
		Arrays.sort(words);
		ArrayList<String> set = new ArrayList<>();
		set.add(words[N-1]);
		int idx = 0;
		
		for(int i=N-2 ; i>=0 ; i--) {
			if(!set.get(idx).startsWith(words[i])) {
				set.add(words[i]);
				idx++;
			}
		}
		
		System.out.println(set.size());
	}

}
