import java.io.*;
import java.util.*;

public class BOJ_14889 {
    static boolean[] check;
    static int N;
    static int answer = Integer.MAX_VALUE;
    static int[][] data;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        check = new boolean[N];
        data = new int[N][N];

        for (int i = 0; i < N; i++) {
            data[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        competition(0,0);
        System.out.println(answer);
    }

    private static void competition(int depth, int a) {
        if(depth == N/2){
            circulate();
            return;
        }

        for(int i=a; i<N; i++){
            check[i] = true;
            competition(depth+1, i+1);
            check[i] = false;
        }
    }

    private static void circulate() {
        int start = 0;
        int link = 0;
        for(int i=0; i<N-1; i++){
            for(int j=i+1; j<N; j++){
                if(check[i] && check[j]){
                    start += data[i][j] + data[j][i];
                }
                else if(!check[i] && !check[j]){
                    link += data[i][j] + data[j][i];
                }
            }
        }

        int result = Math.abs(start-link);

        if(result == 0) {
            System.out.println(result);
            System.exit(0);
        }
        answer = Math.min(result,answer);
    }
}