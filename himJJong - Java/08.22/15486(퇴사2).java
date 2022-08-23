package chapter2;
import java.util.*;
import java.io.*;
 
public class TypeInference {
	static int N;
    public static void main(String[] args)throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        
        int max = -1;
        int[] time = new int[N+2];
        int[] money = new int[N+2];
        int[] dp = new int[N+2];
        
        for(int i=1; i<=N ;i++) {
        	st = new StringTokenizer(br.readLine());
        	time[i] = Integer.parseInt(st.nextToken());
        	money[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=1; i<=N+1 ;i++) {
        	max = Math.max(max, dp[i]);
        	
        	if(i+time[i]<=N+1)
        		dp[time[i]+i] = Math.max(max+money[i], dp[i+time[i]]);
        }
        System.out.println(max);
    }
}
