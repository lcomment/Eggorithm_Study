package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_20437 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			String W = br.readLine();
			int K = Integer.parseInt(br.readLine());
			
			// 리턴한 ArrayList가 비어있으면 -1, 그렇지 않으면 맨 앞과 맨 뒤 요소를 출력 
			ArrayList<Integer> result = searchString(W, K);
			
			if(result == null)
				System.out.println(-1);
			else {
				System.out.print(result.get(0) + " ");
				System.out.println(result.get(result.size() - 1));
			}
				
		}
	}
	
	static ArrayList<Integer> searchString(String str, int k) {
		ArrayList<Integer> arr = new ArrayList<>();
		int[] alphabet = new int[26];
		
		// 완전탐색을 했는데 시간초과가 나서 조건 추가
		for(int i = 0; i < str.length(); i++) {
			alphabet[str.charAt(i) - 'a']++;
		}
		
		// 문자열의 해당 알파벳의 개수가 K개 이하면 탐색하지 않음  
		for(int i=0 ; i<str.length() ; i++) {
			if(alphabet[str.charAt(i) - 'a'] < k) continue;
			
			int cnt = 0;
			for(int j=i ; j<str.length() ; j++) {
				if(str.charAt(i) == str.charAt(j)) {
					cnt++;
					
					if(cnt == k) {
                        arr.add(j - i + 1);
                        break;
                    }
				}
			}
		}
		
		if(arr.isEmpty()) return null;
		Collections.sort(arr);
		return arr;
	}
}
