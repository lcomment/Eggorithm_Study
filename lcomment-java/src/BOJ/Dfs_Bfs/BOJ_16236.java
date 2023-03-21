package BOJ.Dfs_Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_16236 {
    static class Node {
        int r, c;
        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static int N;
    static int[][] map, dist;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};
    static Node shark;
    static int sharkSize = 2, eat = 0, count = 0, minDist, minR, minC;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = stoi(br.readLine());
        map = new int[N][N];
        boolean flag = false;

        for(int i=0 ; i<N ; i++) {
            map[i] = sToIntArray(br.readLine());

            for(int j=0 ; j<N && !flag ; j++) {
                if(map[i][j] == 9) {
                    shark = new Node(i, j);
                    flag = true;
                    map[i][j] = 0;
                }
            } // for_j
        } // for_i

        while(true) {
            dist = new int[N][N];
            minR = minC = minDist = Integer.MAX_VALUE;

            bfs();

            if(minR == Integer.MAX_VALUE || minC == Integer.MAX_VALUE) break;

            eat++;
            map[minR][minC] = 0;
            shark = new Node(minR, minC);
            count += dist[minR][minC];

            // 크기와 같은 수의 물고기를 먹으면 성장
            if(eat == sharkSize) {
                sharkSize++;
                eat = 0;
            }
        }
        System.out.println(count);
    }

    private static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(shark);

        while(!q.isEmpty()) {
            Node n = q.poll();

            for(int i=0 ; i<4 ; i++) {
                int nr = n.r + dr[i];
                int nc = n.c + dc[i];

                if(!in(nr, nc) || !checkMove(map[nr][nc]) || dist[nr][nc] != 0) continue;

                dist[nr][nc] = dist[n.r][n.c] + 1;
                q.offer(new Node(nr, nc));

                if(checkEat(map[nr][nc])) {
                    changeEat(nr, nc);
                }
            } // for_i
        } // while_q
    }

    private static void changeEat(int nr, int nc) {
        if(minDist > dist[nr][nc]) {
            minDist = dist[nr][nc];
            minR = nr;
            minC = nc;
        }
        // 같을 땐 가장 위, 가장 좌측 물고기부터
        else if(minDist == dist[nr][nc]) {
            if(minR > nr) {
                minR = nr;
                minC = nc;
            } else if(minR == nr && minC > nc) {
                minC = nc;
            }
        }
    }

    private static boolean checkEat(int size) {
        return size!=0 && size<sharkSize;
    }

    private static boolean checkMove(int size) {
        return size <= sharkSize;
    }

    private static boolean in(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }

    private static int[] sToIntArray(String s) {
        return Arrays.stream(s.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
