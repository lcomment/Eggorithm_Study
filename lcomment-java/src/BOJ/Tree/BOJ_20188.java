package BOJ.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ_20188 {
    static int N;
    static int[] dp;
    static ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
    static long sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = sToI(br.readLine());
        dp = new int[N+1];
        initEdges();

        // edge 저장
        for(int i=1 ; i<N ; i++) {
            int[] input = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            edges.get(input[0]).add(input[1]);
            edges.get(input[1]).add(input[0]);
        }

        topDown(1);
        System.out.println(sum);
    }

    private static int topDown(int standard) {
        // 초기값 저장 (자기 자신)
        dp[standard] = 1;

        // 서브 트리 계산
        for(int vertex : edges.get(standard)) {
            // 초기화 되지 않은 vertex 에 관해서만 DP 계산 (DFS 진행)
            if(dp[vertex] == 0)
                dp[standard] += topDown(vertex);
        }

        if(standard != 1) {
            // 총 Vertex 의 합 - 서브트리 Vertex 의 합
            sum += calculateTreeSum(N) - calculateTreeSum(N - dp[standard]);
        }
        return dp[standard];
    }

    private static long calculateTreeSum(int n) {
        return (long)n * (long)(n-1) / 2;
    }

    private static int sToI(String s) {
        return Integer.parseInt(s);
    }

    private static void initEdges() {
        for(int i=0 ; i<=N ; i++) {
            edges.add(new ArrayList<>());
        }
    }
}
