package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1515 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine();
		
		int idx = 0;
		int N = 0;
		
		// 1부터 30000(최대)까지 완전탐색  
		Loop:
		for(int i=1 ; i<30001 ; i++) {
			String temp = Integer.toString(i);
			
			// 1부터 오름차순으로 탐색하기 때문에 포함돼 있으면 idx++  
			for(int j=0; j<temp.length() ; j++) {
				if(temp.charAt(j) == S.charAt(idx))
					idx++;
				if(idx == S.length()) {
					N = i;
					break Loop;
				}
			} // for_j
		} // for_i
		
		System.out.println(N);
	}

}
