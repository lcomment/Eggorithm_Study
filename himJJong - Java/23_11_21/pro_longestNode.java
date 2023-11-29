import java.util.*;
import java.io.*;

class pro_longestNode {
    static class Node implements Comparable<Node> {
        int val;
        int w;

        Node(int val, int w) {
            this.val = val;
            this.w = w;
        }

        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }

    static int[] dist;
    static boolean[] visited;
    static List<Node>[] list;
    static int n = 6;
    static int[][] edge = {{3,6}, {4,3}, {3,2}, {1,3}, {1,2}, {2,4}, {5,2}};
    public static void main(String[] args) {
        dist = new int[n + 1];
        visited = new boolean[n + 1];
        list = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < edge.length; i++) {
            int nodeA = edge[i][0];
            int nodeB = edge[i][1];

            list[nodeA].add(new Node(nodeB, 1));
            list[nodeB].add(new Node(nodeA, 1));
        }

        Arrays.fill(dist, Integer.MAX_VALUE);
        dijgkstra(1);

        int answer = 0;
        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (result < dist[i]) {
                answer = 1;
                result = dist[i];
            } else if (result == dist[i]) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static void dijgkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node tmp = pq.poll();

            if (!visited[tmp.val]) {
                visited[tmp.val] = true;

                for (Node k : list[tmp.val]) {
                    if (dist[k.val] > dist[tmp.val] + k.w) {
                        dist[k.val] = dist[tmp.val] + k.w;
                        pq.add(new Node(k.val, dist[k.val]));
                    }
                }
            }
        }
    }
}
