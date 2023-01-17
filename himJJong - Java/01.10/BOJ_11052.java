import java.io.*;
import java.util.*;

public class BOJ_11052 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int card = sc.nextInt();
        int[] data = new int[card+1];
        int[] dp = new int[card+1];

        for(int i = 1; i<=card; i++) {
            data[i] = sc.nextInt();
        }

        data[0] = 0;

        for(int i=1; i<=card; i++){
            for(int j=1; j<=i; j++){
                dp[i] = Math.max(dp[i],data[j]-dp[i-j]);
            }
        }
        System.out.println(dp[card]);
    }
}

/*
//top-bottom
public class No11052_CardTrade {

        static int dp[];
        static int data[];

        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int card = Integer.parseInt(br.readLine());
            String tc = br.readLine();
            data = new int[card+1];
            dp = new int[card+1];
            StringTokenizer st = new StringTokenizer(tc, " ");
            for(int i =1; i<=card; i++){
                data[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.fill(dp, -1);
            dp[0] = 0;
            dp[1] = data[1];
            System.out.println(func(card));
        }

        private static int func(int n) {
            if(n == 1){
                return dp[1];
            }
            for(int i =0; i<n; i++){
                if(dp[i] != -1){
                    dp[n] =Math.max(dp[n], dp[i]+ data[n-i]);
                }
                else{
                    dp[n] =Math.max(dp[n], func(i)+ data[n-i]);
                }
            }
            return dp[n];
        }

    }
 */