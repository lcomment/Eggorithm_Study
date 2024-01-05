
import java.io.*;
import java.util.*;

public class SX_1 {
    static class Node {
        int val;
        int count;
        public Node(int val, int count) {
            this.val = val;
            this.count = count;
        }
    }
    static ArrayList<Integer>[] list = new ArrayList[10001];
    static boolean[] visited = new boolean[10001];
    static int s;
    static int e;
    static int result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < 10001; i++) {
            list[i] = new ArrayList<>();
        }
        check();

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            Arrays.fill(visited, false);
            visited[s] = true;
            bfs();

            System.out.println("#" + t + " " + result);
        }
    }
    private static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(s, 0));

        while(!q.isEmpty()) {
            Node node = q.poll();
            if(node.val == e) {
                result = node.count;
                return;
            }

            for(Integer next : list[node.val]) {
                if(next > 10000) continue;
                if(!visited[next]) {
                    visited[next] = true;
                    q.add(new Node(next, node.count +1));
                }
            }
        }
    }
    private static void check() {
        diagRightBelow();
        diagLeftBelow();
        moveRight();
    }

    private static void diagRightBelow() {
        int step = 1;
        int next = 2;

        while(true) {
            boolean flag = false;

            for (int i = 1; i < 10001; i++) {
                if(!visited[i] && (i + next) < 10001) {
                    flag = true;
                    visited[i] = true;
                    list[i].add(i+next);
                    list[i+next].add(i);
                    i += next-1;
                    next++;
                }
            }
            next = 2 + step;
            step++;
            if(!flag) break;
        }
        Arrays.fill(visited, false);
    }

    private static void diagLeftBelow() {
        int step = 1;
        int next = 1;

        while(true) {
            boolean flag = false;

            for (int i = 1; i < 10001; i++) {
                if(!visited[i] && (i + next) < 10001) {
                    flag = true;
                    visited[i] = true;
                    list[i].add(i+next);
                    list[i+next].add(i);
                    i += next-1;
                    next++;
                }
            }
            next = 1 + step;
            step++;
            if(!flag) break;
        }
        Arrays.fill(visited, false);
    }

    private static void moveRight() {
        int step = 1;
        int next = 1;
        int index = 1;

        while(true) {
            boolean flag = false;

            for (int i = step; i < 10001; i++) {
                if(!visited[i] && (i + 1) < 10001) {
                    flag = true;
                    visited[i] = true;
                    if(i == next) break;
                    list[i].add(i+1);
                    list[i+1].add(i);
                }
            }
            step+= index;
            next += ++index;

            if(!flag) break;
        }
    }
}