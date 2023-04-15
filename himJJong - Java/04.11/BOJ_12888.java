import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_12888 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int h = Integer.parseInt(br.readLine());

        long[] dp = new long[64];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 3;

        if(h<3){
            System.out.println(dp[h]);
            System.exit(0);
        }

        for(int i=3; i<=h;i++){
            if(i%2 == 1){
                dp[i] = ((dp[i-2]*2)*2)+1;
            }
            else dp[i] = ((dp[i-2]*2)*2)-1;
        }
        System.out.println(dp[h]);
    }
}


// h=0 1
// h=1 1
// h=2 3
// h=3 5
// h=4 11
// h=5 21