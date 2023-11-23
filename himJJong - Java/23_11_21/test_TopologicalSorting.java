import java.util.*;

public class test_TopologicalSorting {
    public static void main(String[] args) {
        int n = 6;
        int[][] relationships = {{1, 2}, {1, 3}, {3, 6}, {3, 4}, {3, 5}};
        setNodeValues(n, relationships);
    }
    public static void setNodeValues(int n, int[][] relationships) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[n + 1];
        int[] values = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 그래프 생성과 진입 차수 계산
        for (int[] relation : relationships) {
            int parent = relation[0];
            int child = relation[1];
            graph.get(parent).add(child);
            indegree[child]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                values[i] = 1;
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int child : graph.get(current)) {
                indegree[child]--;
                if (indegree[child] == 0) {
                    queue.offer(child);
                    values[child] += values[current];
                }
            }
        }

        // 결과 출력
        for (int i = 1; i <= n; i++) {
            System.out.println("Node " + i + ": " + values[i]);
        }
    }
}
