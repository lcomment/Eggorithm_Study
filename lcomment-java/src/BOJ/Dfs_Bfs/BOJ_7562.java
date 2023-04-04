package BOJ.Dfs_Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class BOJ_7562 {
    static class Node {
        int r, c;

        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }

        Node(int[] input) {
            r = input[0];
            c = input[1];
        }
    }

    static int T, N;
    static Node start, destination;
    static int[][] dist;
    static boolean[][] visited;
    static int[][] dir = {{-2, -1}, {-2, 1}, {-1,  -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = stoi(br.readLine());

        while(T-- > 0) {
            N = stoi(br.readLine());
            dist = new int[N][N];
            visited = new boolean[N][N];

            for(int i=0 ; i<N ; i++)
                Arrays.fill(dist[i], Integer.MAX_VALUE);

            start = new Node(sToIntArray(br.readLine()));
            destination = new Node(sToIntArray(br.readLine()));

            System.out.println(bfs());
        }

    }

    private static int bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(start);
        dist[start.r][start.c] = 0;

        while(!q.isEmpty()) {
            Node n = q.poll();

            if(n.r == destination.r && n.c == destination.c) break;

            for(int i=0 ; i<dir.length ; i++) {
                int nr = n.r + dir[i][0];
                int nc = n.c + dir[i][1];

                if(!in(nr, nc) || visited[nr][nc] || dist[nr][nc] <= dist[n.r][n.c] + 1) continue;

                visited[nr][nc] = true;
                dist[nr][nc] = dist[n.r][n.c] + 1;
                q.offer(new Node(nr, nc));
            }

        }
        return dist[destination.r][destination.c];
    }

    private static boolean in(int r, int c) {
        return 0<=r && r<N && 0<=c && c<N;
    }

    private static int[] sToIntArray(String s) {
        return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}