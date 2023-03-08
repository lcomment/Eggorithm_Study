package BOJ.Disjoint_Set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class BOJ_16562 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, k;
    static int[] costs, parents, minCosts;

    public static void main(String[] args) throws IOException {
        init();

        for(int i=0 ; i<M ; i++) {
            int[] input = sToIntArray(br.readLine());

            // 합집합(union) 명령
            union(input[0], input[1]);
        }

        setMinCosts();

        int totalCost = calculateTotalCost();
        System.out.println(k >= totalCost ? totalCost:"Oh no");
    }

    private static void setMinCosts() {
        for(int i=1 ; i<=N ; i++) {
            int parent = find(i);
            minCosts[parent] = Math.min(minCosts[parent], costs[i - 1]);
        }
    }

    private static int calculateTotalCost() {
        Set<Integer> notDuplicatedParents = Arrays.stream(parents).boxed().collect(Collectors.toSet());
        notDuplicatedParents.remove(0);

        int totalCost = 0;
        for(int parent : notDuplicatedParents) {
            // 0번 인덱스부터 저장했기 때문에 1을 빼줌
            totalCost += minCosts[parent];
        }

        return totalCost;
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x < y) {
            parents[y] = x;
        } else if(x > y) {
            parents[x] = y;
        }
    }

    private static int find(int x) {
        if(x == parents[x]) return x;

        return parents[x] = find(parents[x]);
    }

    private static void init() throws IOException {
        int[] input = sToIntArray(br.readLine());

        N = input[0];
        M = input[1];
        k = input[2];
        parents = new int[N+1];
        minCosts = new int[N+1];

        costs = sToIntArray(br.readLine());
        Arrays.fill(minCosts, Integer.MAX_VALUE);

        for(int i=1 ; i<=N ; i++) {
            parents[i] = i;
        }
    }

    private static int[] sToIntArray(String s) {
        return Arrays.stream(s.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
