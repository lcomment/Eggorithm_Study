import java.util.*;
public class test2_dfs {
    static class Node {
        int value;
        List<Node> children;

        public Node(int value) {
            this.value = value;
            this.children = new ArrayList<>();
        }
    }
    public static void main(String[] args) {
        int n = 6;
        int[][] relationships = {{1, 2}, {1, 3}, {3, 6}, {3, 4}, {3, 5}};
        setNodeValues(n, relationships);
    }
    public static void setNodeValues(int n, int[][] relationships) {
        Node[] nodes = new Node[n + 1];

        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node(0);
        }

        // 그래프 생성
        for (int[] relation : relationships) {
            int parentValue = relation[0];
            int childValue = relation[1];
            nodes[parentValue].children.add(nodes[childValue]);
        }

        // DFS 호출
        dfs(nodes[1]);

        // 결과 출력
        for (int i = 1; i <= n; i++) {
            System.out.println("Node " + i + ": " + nodes[i].value);
        }
    }

    public static void dfs(Node node) {
        if (node.children.isEmpty()) {
            node.value = 1;
            return;
        }

        for (Node child : node.children) {
            dfs(child);
            node.value += child.value;
        }
        node.value += 1; // 자식 노드의 값의 합에 현재 노드 값(1)을 더함
    }
}
