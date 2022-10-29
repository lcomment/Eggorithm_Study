package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2607 {
	static char[] standard;
	static int result = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		standard = br.readLine().toCharArray();
		
		for(int i=1 ; i<N ; i++) {
			char[] check = br.readLine().toCharArray();
			
			checkSml(check);
		}
		System.out.println(result);
	}
	static void checkSml(char[] check) {
		int contains = 0;
		for(int i=0 ; i<standard.length ; i++) {
			for(int j=0 ; j<check.length ; j++) {
				if(standard[i] == check[j]) {
					contains++;
					check[j] = '0';
					break;
				}
			} // for_j
		}
		if(standard.length >= check.length) {
			if(contains >= standard.length - 1)
				result++;
		}
		else if(standard.length < check.length) {
			if(contains >= check.length - 1)
				result++;
		}
		
		
	}

}
