import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1743 {
    static class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int[] NM;
    static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        NM = new int[3];

        for(int i=0; i<3; i++){
            NM[i] = Integer.parseInt(st.nextToken());
        }

        map = new int[NM[0]][NM[1]];
        visited = new boolean[NM[0]][NM[1]];

        for(int i=0; i<NM[2] ;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a-1][b-1] = -1;
        }

        for(int i=0; i<NM[0]; i++){
            for(int j=0; j<NM[1]; j++){
                if(map[i][j] == -1 && !visited[i][j]){
                    int count = bfs(i,j);
                    answer = Math.max(answer, count);
                }
            }
        }
        System.out.println(answer);
    }

    private static int bfs(int x, int y) {
        int reuslt = 0;
        Queue<Node> q = new LinkedList<>();
        visited[x][y] = true;
        q.add(new Node(x,y));
        while(!q.isEmpty()){
            reuslt++;
            Node tmp = q.poll();
            for(int i=0; i<4; i++){
                int moveX = dx[i] + tmp.x;
                int moveY = dy[i] + tmp.y;

                if(moveY < 0 || moveX >= NM[0] || moveX < 0 || moveY >= NM[1] || map[moveX][moveY] != -1 || visited[moveX][moveY])   continue;
                if(map[moveX][moveY] == -1){
                    visited[moveX][moveY] = true;
                    q.add(new Node(moveX,moveY));
                }
            }
        }
        return reuslt;
    }
}