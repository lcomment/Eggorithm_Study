package BOJ.MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ_1414 {
    static int N, total = 0, cycleNode = 1;;
    static int[][] edges;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        edges = new int[N*N][3];
        parents = new int[N+1];

        int idx = 0;
        for(int i=0 ; i<N ; i++){
            char[] input = br.readLine().toCharArray();
            int len;

            for(int j=0 ; j<N ; j++){
                if('a' <= input[j] && input[j] <= 'z') {
                    len = input[j] - 'a' + 1;
                    total += len;

                    edges[idx][0] = i;
                    edges[idx][1] = j;
                    edges[idx++][2] = len;
                }else if('A' <= input[j] && input[j] <= 'Z') {
                    len = input[j] - 'A' + 27;
                    total += len;

                    edges[idx][0] = i;
                    edges[idx][1] = j;
                    edges[idx++][2] = len;
                }

            }
        }
        for(int i=0 ; i<N ; i++){
            parents[i] = i;
        }

        int usedCount = kruskal(edges, parents);

        if(cycleNode != N) System.out.println(-1);
        else System.out.println(total-usedCount);

    }

    public static int kruskal(int[][] edges, int[] parents) {
        int total = 0;

        // 간선들을 가중치의 오름차순으로 정렬
        Arrays.sort(edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] e1, int[] e2) {
                return e1[2] - e2[2];

            }
        });

        for (int i = 0; i < edges.length; i++) {
            // 부모가 같지 않을 때 (사이클이 만들어지지 않을 때)
            if (find(parents, edges[i][0]) != find(parents, edges[i][1])) {
                cycleNode++;
                total += edges[i][2];
                union(parents, edges[i][0], edges[i][1]);
            }
        }

        return total;
    }

    // 부모 정점을 체크하는 메서드
    public static int find(int[] parent, int i) {
        if (parent[i] == i)
            return i;
        return find(parent, parent[i]);
    }

    // MST를 구성하는 간선들의 집합에 추가하는 메서드
    public static void union(int[] parent, int a, int b) {
        int a_parent = find(parent, a);
        int b_parent = find(parent, b);

        if (a_parent < b_parent)
            parent[b_parent] = a_parent;
        else
            parent[a_parent] = b_parent;
    }
}
