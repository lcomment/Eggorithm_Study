package BOJ.;

import java.io.*;

public class BOJ_12852 {
    static int N;
    static int[] dp, parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = sToI(br.readLine());
        dp = new int[N + 1];
        parents = new int[N + 1];


        for(int i=2 ; i<=N ; i++) {
            dp[i] = dp[i-1] + 1;
            parents[i] = i-1;

            if(i % 2 == 0 && dp[i] > dp[i/2] + 1) {
                dp[i] = dp[i/2] + 1;
                parents[i] = i/2;
            }
            if(i % 3 == 0 && dp[i] > dp[i/3] + 1) {
                dp[i] = dp[i/3] + 1;
                parents[i] = i/3;
            }
        }

        sb.append(dp[N]).append("\n");
        int index = N;
        sb.append(index).append(" ");

        while(parents[index] != 0) {
            sb.append(parents[index]).append(" ");
            index = parents[index];
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static int sToI(String s) {
        return Integer.parseInt(s);
    }
}
