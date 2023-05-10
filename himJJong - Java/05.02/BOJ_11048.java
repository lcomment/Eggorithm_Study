import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11048 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] NM = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[][] data = new int[NM[0]+1][NM[1]+1];
        int[][] dp = new int[NM[0]+1][NM[1]+1];

        for(int i=1; i<NM[0]+1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<NM[1]+1; j++){
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1; i<NM[0]+1; i++){
            for(int j=1; j<NM[1]+1; j++){
                dp[i][j] = Math.max(dp[i-1][j]+data[i][j],data[i][j]+dp[i][j-1]);
            }
        }
        System.out.println(dp[NM[0]][NM[1]]);
    }
}
