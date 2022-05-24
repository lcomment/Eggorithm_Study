package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BOJ_1316 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		while( N-- > 0) {
			String s = br.readLine();
			HashMap<Character, Boolean> map = new HashMap<>();
			boolean flag = true;
			
			map.put(s.charAt(0), true);
			
			for(int i=1 ; i<s.length() ; i++) {
				if(!map.containsKey(s.charAt(i))) {
					map.put(s.charAt(i), true);
					continue;
				}
				if(s.charAt(i-1) != s.charAt(i)) {
					flag = false;
					break;
				}
			}
			if(flag)
				cnt++;
		} // while - N
		System.out.println(cnt);
	}
}
