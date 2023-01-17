package BOJ.Dfs_Bfs;

import java.io.*;
import java.util.*;

// 0: 빈 칸, 1: 벽, 2: 바이러스
public class BOJ_14502 {
    static class Node {
        int r, c;
        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
        Node(Node n) {
            this.r = n.r;
            this.c = n.c;
        }
    }
    static int R, C, result = -1;
    static int[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};
    static List<Node> emptyNodes = new ArrayList<>();
    static List<Node> virusNodes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        initRC(br.readLine());
        map = new int[R][C];
        for(int i=0 ; i<R ; i++) {
            map[i] = sToIntArray(br.readLine());

            for(int j=0 ; j<C ; j++) {
                if(map[i][j] == 0) {
                    emptyNodes.add(new Node(i, j));
                } else if(map[i][j] == 2) {
                    virusNodes.add(new Node(i, j));
                }
            }
        }

        backTracking(new boolean[emptyNodes.size()], 0, 0);
        System.out.println(result);
    }

    private static void initRC(String s) {
        int[] input = sToIntArray(s);
        R = input[0];
        C = input[1];
    }
    private static int[] sToIntArray(String s) {
        return Arrays.stream(s.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static void backTracking(boolean[] visited, int start, int cnt) {
        if(cnt == 3) {
            ArrayList<Node> selected = save(visited);
            int[][] newMap = makeWall(selected);
            bfs(newMap);
            int r = countSafeZone(newMap);
            result = Math.max(result, r);
            return;
        }

        for(int i=start ; i<emptyNodes.size() ; i++) {
            visited[i] = true;
            backTracking(visited, i+1, cnt+1);
            visited[i] = false;
        }
    }

    private static ArrayList<Node> save(boolean[] visited) {
        ArrayList<Node> selected = new ArrayList<>();
        for(int i=0 ; i<visited.length ; i++) {
            if(visited[i])
                selected.add(new Node(emptyNodes.get(i)));
        }
        return selected;
    }

    private static int[][] makeWall(List<Node> selected) {
        int[][] newMap = new int[R][C];
        for(int i=0; i<newMap.length; i++){
            System.arraycopy(map[i], 0, newMap[i], 0, newMap[0].length);
        }

        for(Node n : selected) {
            newMap[n.r][n.c] = 1;
        }
        return newMap;
    }

    private static void bfs(int[][] map) {
        Queue<Node> q = new LinkedList<>(virusNodes);

        boolean[][] visited = new boolean[R][C];

        for(Node n : q) {
            visited[n.r][n.c] = true;
        }

        while(!q.isEmpty()) {
            Node n = q.poll();

            for(int i=0 ; i<4 ; i++) {
                int nr = n.r + dr[i];
                int nc = n.c + dc[i];

                if(!in(nr, nc) || visited[nr][nc]) continue;
                if(map[nr][nc] != 0) continue;

                visited[nr][nc] = true;
                map[nr][nc] = 2;
                q.offer(new Node(nr, nc));
            }
        }
//        countSafeZone(map);
    }

    private static boolean in(int r, int c) {
        return (0<=r && r<R) && (0<=c && c<C);
    }

    private static int countSafeZone(int[][] map) {
        int cnt = 0;
        for(int r=0 ; r<R ; r++) {
            for(int n : map[r]) {
                if(n == 0) cnt++;
            }
        }
        return cnt;
    }
}
