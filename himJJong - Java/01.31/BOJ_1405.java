import java.io.*;
import java.util.*;

public class BOJ_1405 {
    static double[] data = new double[4];
    static boolean[][] visited = new boolean[29][29];
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int moveCount;
    static double answer;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        moveCount = Integer.parseInt(st.nextToken());

        for(int i=0; i<4; i++){
            data[i] = Integer.parseInt(st.nextToken()) * 0.01;
        }
        visited[14][14] = true;
        dfs(14,14,0,1);
        System.out.println(answer);
    }
    private static void dfs(int x, int y, int cnt,double result) {
        if(cnt == moveCount){
            answer += result;
            return;
        }
        for(int i=0; i<4; i++){
            int move_x = dx[i]+x;
            int move_y = dy[i]+y;

            if(move_x >= 0 && move_y >= 0  && move_x <= 28 && move_y <= 28 && !visited[move_x][move_y]){
                visited[move_x][move_y] = true;
                dfs(move_x,move_y,cnt+1,result*data[i]);
                visited[move_x][move_y] = false;
            }
        }
    }
}
