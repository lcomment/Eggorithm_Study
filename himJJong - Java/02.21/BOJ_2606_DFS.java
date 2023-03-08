import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2606_DFS {
    static int[][] data;
    static int[] check;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int node = Integer.parseInt(br.readLine());
        int connect = Integer.parseInt(br.readLine());
        int answer = 0;

        data = new int[node+1][node+1];
        check = new int[node+1];

        for(int i=0; i<connect; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            data[x][y] = 1;
            data[y][x] = 1;
        }

        dfs(1);

        for (int j : check) {
            if (j == 1) {
                answer++;
            }
        }
        System.out.println(answer-1);
    }

    private static void dfs(int i) {
        check[i] = 1;
        for(int j = 1; j<check.length; j++){
            if(data[i][j]==1 && check[j] != 1){
                check[j]=1;
                dfs(j);
            }
        }
    }
}