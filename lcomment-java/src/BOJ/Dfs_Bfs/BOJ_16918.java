package BOJ.Dfs_Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_16918 {
    static class Node {
        int r, c;

        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static int R, C, N;
    static char[][] map;
    static int[][] count;
    static int[] dr = {1, 0 ,-1, 0};
    static int[] dc = {0, 1, 0, -1};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        init();
        simulation();
        print();
    }
    public static void simulation(){
        // 1초는 그대로이기 때문에 2초부터 시작
        for(int sec=2 ; sec<=N ; sec++){
            if(sec%2 == 0) {
                setBomb(sec);
            }
            else {
                bfs(sec);
            }
        }
    }

    public static void setBomb(int sec){
        for(int r=0 ; r<R ; r++){
            for(int c=0 ; c<C ; c++){
                // 빈칸에 폭탄 설치 및 터질 시간 지정
                if(map[r][c] == '.'){
                    map[r][c] = 'O';
                    count[r][c] = sec+3;
                }
            }
        }
    }

    public static void bfs(int sec){
        Queue<Node> q = new LinkedList<>();

        // 터질 폭탄 선별
        for(int r=0 ; r<R ; r++){
            for(int c=0 ; c<C ; c++){
                if(sec == count[r][c]){
                    q.add(new Node(r, c));
                }
            }
        }

        // 터뜨림
        while(!q.isEmpty()){
            Node n = q.poll();

            map[n.r][n.c] = '.';
            count[n.r][n.c] = sec+3;

            for(int i=0 ; i<4 ; i++){
                int nr = n.r + dr[i];
                int nc = n.c + dc[i];

                if(!in(nr, nc)) continue;

                map[nr][nc] = '.';
                count[nr][nc] = sec + 3;
            }
        }

    }

    private static void print() {
        for(int i=0;i<R;i++){
            for(int j=0 ; j<C ; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean in(int r, int c) {
        return 0<=r && r<R && 0<=c && c<C;
    }

    private static void init() throws IOException {
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        R = input[0];
        C = input[1];
        N = input[2];

        map = new char[R][C];
        count = new int[R][C];

        for (int r=0; r<R; r++) {
            map[r] = br.readLine().toCharArray();

            for (int c = 0; c < C; c++) {
                // 폭탄은 3초 후에 터짐
                if(map[r][c] == 'O') {
                    count[r][c] = 3;
                }
            }
        }
    }
}
