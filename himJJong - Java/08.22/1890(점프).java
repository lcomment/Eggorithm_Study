package chapter2;
import java.util.*;
import java.io.*;
 
public class TypeInference {
	static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        int[][] array = new int[n+1][n+1];
        
        for(int i=1; i<=n; i++) {
        	String[] t = br.readLine().split(" ");  //입력값
            for(int j=1; j<=n; j++) {	//array[1][1] ~ array[n][n]
                array[i][j] =  Integer.parseInt(t[j-1]);
            }
        }
        long[][] dp = new long[n+1][n+1];		// 경로 값 저
        
        dp[1][1] = 1;							//처음 시작 (1,1)
        
        for(int i=1; i<=n; i++) {
        	for(int j=1; j<=n ;j++) {	
        		if(i==n && j==n) continue;
        		if(i+array[i][j]<n+1) {		//행 사이즈  array[array[i-1][j]+1][j]
        			dp[i+array[i][j]][j]+=dp[i][j];
        		}
        		if(j+array[i][j]<n+1){		//열 사이즈 
        				dp[i][j+array[i][j]]+=dp[i][j];
        			}
        		}
        }
        System.out.println(dp[n][n]);
       }
}
