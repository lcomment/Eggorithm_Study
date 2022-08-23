package chapter2;
import java.util.*;
import java.io.*;
 
public class TypeInference {
	static int n;
    static int arr[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        String[] t = br.readLine().split(" ");  //입력값 
        
        long[][] dp = new long[n+1][21];		// [입력값개수][범위0~20]
        arr = new int[n+1];			            //입력값 
        
        for(int i=1; i<=n; i++) {                     //arr[1] ~ arr[11]             n=11 
            arr[i]=  Integer.parseInt(t[i-1]);
        }
        dp[1][arr[1]]=1;       
        
        for(int i=2; i<n; i++) {                      // dp[i-1] 의 값이 있다면, -> dp[i] 값이 범위내에 있는지 확인하고 +1 -> 여러개 있으면 중첩돼서 증가됨
            for(int j=0; j<=20; j++) {                // 중간범위가 0~20 이하여야 하기 때문에 
                if(dp[i-1][j]!=0) {                   // 0이면 넘기고 
                    if(j+arr[i]<=20) {
                        dp[i][j+arr[i]]+=dp[i-1][j];
                    }
                    if(j-arr[i]>=0) {
                        dp[i][j-arr[i]]+=dp[i-1][j];
                    }
                }
            }
        }
        System.out.println(dp[n-1][arr[n]]);          // 원하는 dp[n-1][arr[n]]의 값의 개수는!? 
                                                      //     끝값은 계산x,원하는 값에 부합하는 방법의 수!!
    }
}
