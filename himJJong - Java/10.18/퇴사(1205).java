import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(reader.readLine());
		
		int[] t = new int[n];
		int[] p = new int[n];
		
		StringTokenizer st;
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(reader.readLine());
			
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		//dp : N일에 얻을 수 있는 최대 수익
		int[] dp = new int[n+1];

		for (int i=0; i<n; i++) {
			if (i + t[i] <= n) {
				//날짜가 범위를 넘어가지 않는 경우
				dp[i + t[i]] = Math.max(dp[i + t[i]], dp[i] + p[i]);
			}
		
			dp[i+1] = Math.max(dp[i+1], dp[i]);
		}
		System.out.println(dp[n]);
		
	}
}

