import java.io.*;
import java.util.*;

public class ssafy_snail {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int test_case=1; test_case<=T; test_case++){
            int N = Integer.parseInt(br.readLine());

            int[][] data = new int[N][N];

            int dir = 0;
            int r = 0;
            int c = 0;

            for(int i=1; i<= N*N; i++){
                data[r][c] = i;
                if(r + dx[dir] >= N || r + dx[dir] < 0 || c + dy[dir] >= N || c + dy[dir] < 0 || data[r+dx[dir]][c + dy[dir]] != 0)   dir = (dir+1) % 4;

                r += dx[dir];
                c += dy[dir];
            }
            System.out.println("#" + test_case);
            for(int i = 0; i< N ; i++){
                for(int j=0; j<N; j++){
                    System.out.print(data[i][j] +" ");
                }
                System.out.println();
            }
        }
    }
}
