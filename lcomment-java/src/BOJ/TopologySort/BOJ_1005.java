package BOJ.TopologySort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1005 {
    static int T, N, K, W;
    static int[] seq, degrees, costs;
    static ArrayList<ArrayList<Integer>> adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = sToI(br.readLine());

        while(T-- > 0) {
            int[] input = sToIntArr(br.readLine());
            N = input[0];
            K = input[1];

            seq = sToIntArr(br.readLine());
            degrees = new int[N];
            adjList = new ArrayList<>();

            for(int i=0 ; i<N ; i++) {
                adjList.add(new ArrayList<>());
            }

            for(int i=0 ; i<K ; i++) {
                input = sToIntArr(br.readLine());
                adjList.get(input[0]-1).add(input[1]-1);
                degrees[input[1]-1]++;
            }

            W = sToI(br.readLine()) - 1;

            costs = new int[N];
            topologySort();
            System.out.println(costs[W]);
        }
    }

    static void topologySort() {
        Queue<Integer> q = new LinkedList<>();

        // degree가 0인걸 넣어줌
        for(int i=0 ; i<N ; i++) {
            if(degrees[i] == 0) {
                costs[i] = seq[i];
                q.offer(i);
            }
        }

        while(!q.isEmpty()) {
            int n = q.poll();

            ArrayList<Integer> adj = adjList.get(n);
            for(int next : adj) {
                costs[next] = Math.max(costs[next], costs[n] + seq[next]);

                if(--degrees[next] == 0) {
                    q.offer(next);
                }
            } // for_i
        }
    }

    private static int sToI(String s) {
        return Integer.parseInt(s);
    }

    private static int[] sToIntArr(String s) {
        return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
