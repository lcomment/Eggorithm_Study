package String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_5052 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-- > 0) {
			int N = Integer.parseInt(br.readLine());
			
			String[] testCase = new String[N];
			
			for(int i=0 ; i<N ; i++) 
				testCase[i] = br.readLine();
			
			boolean flag = true;
			Arrays.sort(testCase);
			for(int i=0 ; i<N-1 ; i++) {
				if(testCase[i+1].startsWith(testCase[i])) {
					flag = false;
					break;
				}
			}
			if(flag) sb.append("YES\n");
			else sb.append("NO\n");
		} // while-t
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
