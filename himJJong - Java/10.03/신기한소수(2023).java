import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int N;
	static boolean ok;
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dfs("",0);
		System.out.println(sb.toString());
	}
	static void dfs(String s, int cnt){
		if(cnt == N) {
			sb.append(s+"\n");
			return;
		}
		for(int i=1; i<=9; i++) {
			if(isPrime(Integer.parseInt(s+i))){
					dfs(s+i, cnt+1);
			}
		}
	}
	static boolean isPrime(int num) {
		if(num==1) return false;
		
		int n = (int)Math.sqrt(num);
		for(int i=2; i<=n;i++) {
			if(num%i==0) return false;
		}
		return true;
	}
}
