package BOJ.Dfs_Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 한 박스 들고 출발
// 한 박스에 20병
// 50m당 1병씩 마심 (걷기 전에 마셔야 함)
public class BOJ_9205 {
    static class Node {
        int x, y;

        Node(int[] input) {
            x = input[0];
            y = input[1];
        }
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int T;
    static List<Node> list;
    static Node start;
    static Node destination;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = sToI(br.readLine());

        while(T-- >0) {
            int n = sToI(br.readLine());
            list = new ArrayList<>();

            // 편의점의 개수(n) + 시작점 + 도착점 = n+2
            for(int i=0 ; i<n+2 ; i++) {
                int[] input = sToIntArray(br.readLine());
                if(i == 0) start = new Node(input);
                else if(i == n+1) destination= new Node(input);
                else {
                    list.add(new Node(input));
                }
            } // for_i

            System.out.println(bfs() ? "happy":"sad");
        } // while_T
    }

    private static boolean bfs() {
        int N = list.size();

        Queue<Node> q = new LinkedList<>();
        q.offer(start);
        boolean[] visited = new boolean[N];

        while(!q.isEmpty()) {
            Node n = q.poll();

            // 지금 맥주로도 도착점으로 갈 수 있는 경우
            if(Math.abs(n.x - destination.x) + Math.abs(n.y - destination.y) <= 1000) return true;

            for(int i=0 ; i<N ; i++) {
                if(visited[i]) continue;

                Node gs25 = list.get(i);

                // 갈 수 있는 편의점은 가자~
                if(Math.abs(n.x - gs25.x) + Math.abs(n.y - gs25.y) <= 1000) {
                    visited[i] = true;
                    q.offer(new Node(gs25.x, gs25.y));
                }
            }
        }
        return false;
    }

    private static int[] sToIntArray(String s) {
        return Arrays.stream(s.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static int sToI(String s) {
        return Integer.parseInt(s);
    }
}
