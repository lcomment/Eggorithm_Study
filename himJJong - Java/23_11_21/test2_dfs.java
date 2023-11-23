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
        int n = 8;
        int[][] relationships = {{2, 1}, {2, 3}, {3, 6}, {3, 4}, {3, 5}, {1, 7}, {1, 8}};
        Node[] nodes = new Node[n + 1];

        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node(0);
        }

        boolean[] isChild = new boolean[n + 1];

        // 그래프 생성 및 자식 여부 체크
        for (int[] relation : relationships) {
            int parentValue = relation[0];
            int childValue = relation[1];
            nodes[parentValue].children.add(nodes[childValue]);
            isChild[childValue] = true;
        }

        // 최상위 노드(root) 찾기
        Node root = null;
        for (int i = 1; i <= n; i++) {
            if (!isChild[i]) {
                root = nodes[i];
                break;
            }
        }

        // DFS 호출
        dfs(root);

        // 결과 출력
        for (int i = 1; i <= n; i++) {
            System.out.println("Node " + i + ": " + nodes[i].value);
        }
    }

    public static int dfs(Node node) {
        if (node.children.isEmpty()) {
            node.value = 1;
            return 1;
        }

        int childSum = 0;
        for (Node child : node.children) {
            childSum += dfs(child);
        }

        node.value = childSum;
        return childSum;
    }
}
