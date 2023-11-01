import com.sun.org.apache.xerces.internal.impl.dtd.models.CMNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BOJ_4485 {
    static class Node implements Comparable<Node> {
        int x;
        int y;
        int w;
        Node(int x, int y, int w){
            this.x = x;
            this.y = y;
            this.w = w;
        }
        public int compareTo(Node o){
            return this.w - o.w;
        }
    }
    static boolean[][] visited;
    static int[][] map;
    static int N;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int answer = 0;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int index = 1;
        while(true){
            N = Integer.parseInt(br.readLine());
            answer = 0;
            if(N == 0)  break;

            map = new int[N][N];
            visited = new boolean[N][N];

            for(int i=0; i<N; i++){
                map[i] = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
            }

            bfs(0,0);
            System.out.println("Problem "+index+": "+answer);
            index++;
        }
    }

    private static void bfs(int row, int col) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(row, col, map[row][col]));
        visited[row][col] = true;

        while(!pq.isEmpty()){
            Node tmp = pq.poll();
            for(int i=0; i<4; i++){
                int moveX = tmp.x + dx[i];
                int moveY = tmp.y + dy[i];

                if(moveX < 0 || moveX >= N || moveY < 0 || moveY >= N || visited[moveX][moveY])  continue;
                if(moveX == N-1 && moveY == N-1){
                    pq.clear();
                    answer = tmp.w + map[moveX][moveY];
                    break;
                }
                visited[moveX][moveY] = true;
                pq.add(new Node(moveX,moveY,tmp.w + map[moveX][moveY]));
            }
        }

    }
}
