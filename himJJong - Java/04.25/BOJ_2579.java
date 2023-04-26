import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2579 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());

        int[] data = new int[count+1];
        int[] dp = new int[count+1];

        for(int i=1; i<=count; i++){
            data[i] = Integer.parseInt(br.readLine());
        }


        dp[1] = data[1];
        if(count>=2) dp[2] = data[1]+ data[2];
        for (int i =3; i<=count; i++){
            dp[i] = Math.max(dp[i-2],dp[i-3]+data[i-1])+data[i];
        }

        System.out.println(dp[count]);
    }
}
