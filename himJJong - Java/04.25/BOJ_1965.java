import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.StringTokenizer;

public class BOJ_1965 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] box = new int[N+1];
        int[] dp = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            box[i] = Integer.parseInt(st.nextToken());
        }


        for(int i=1; i<=N;i++){
            for(int j=0; j<i; j++){
                if(box[j]<box[i]){
                    dp[i] = Math.max(dp[j]+1,dp[i]);
                }
            }
        }

        OptionalInt max = Arrays.stream(dp).max();
        System.out.println(max.getAsInt());
    }
}
