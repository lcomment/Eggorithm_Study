import java.io.*;
import java.util.*;

public class BOJ_20162 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());


        int[] data = new int[N+1];
        int[] dp = new int[N+1];

        for(int i=0; i<N; i++){
            data[i+1] = Integer.parseInt(br.readLine());
        }


        for(int i=1; i<=N; i++){
            for(int j=0 ; j<i; j++){
                if(data[i] > data[j]){
                    dp[i] = Math.max(dp[j]+data[i],dp[i]);
                }
            }
        }
        OptionalInt sum = Arrays.stream(dp).max();
        System.out.println(sum.getAsInt());
    }
}
