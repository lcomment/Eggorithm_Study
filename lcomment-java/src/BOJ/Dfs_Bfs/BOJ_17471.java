package BOJ.Dfs_Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_17471 {
    static int N, result = Integer.MAX_VALUE;
    static int[] populations;
    static Set<Integer>[] adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = sToI(br.readLine());
        init(sToIntArray(br.readLine()));

        for(int i=1 ; i<=N ; i++) {
            int[] input = sToIntArray(br.readLine());

            // 맨 앞(0) 인접 지역수까지 인접리스트에 넣었다가 20분 날렸네 ㅋㅋ
            for(int j=1 ; j<=input[0] ; j++) {
                adjList[i].add(input[j]);
            }
        }

        for(int i=1 ; i<N ; i++) {
            combination(new ArrayList<>(), 1, i, 0);
        }

        if(result == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(result);
    }

    private static void combination(ArrayList<Integer> select, int start, int r, int cnt) {
        if(cnt == r) {
            gerrymandering(select);
            return;
        }

        for(int i=start ; i<=N ; i++) {
            select.add(i);
            combination(select, i+1, r, cnt+1);
            select.remove(cnt);
        }
    }

    private static void gerrymandering(ArrayList<Integer> select) {
        if(!bfs(select)) return;

        // 고른 지역구를 제외한 나머지 지역구 저장
        ArrayList<Integer> others = new ArrayList<>();
        for(int i=1 ; i<=N ; i++) {
            if(!select.contains(i)) others.add(i);
        }

        if(!bfs(others)) return;

        result = Math.min(result, Math.abs(calculatePopulation(select) - calculatePopulation(others)));
    }

    // 인접한지 체크
    private static boolean bfs(ArrayList<Integer> select) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(select.get(0));

        boolean[] visited = new boolean[N+1];
        visited[select.get(0)] = true;
        int cnt = 1;

        while(!q.isEmpty()) {
            int node = q.poll();

            for(int next : adjList[node]) {
                if(visited[next] || !select.contains(next)) continue;

                visited[next] = true;
                cnt++;
                q.offer(next);
            }
        }

        return cnt == select.size();
     }

     private static int calculatePopulation(ArrayList<Integer> arr) {
        int sum = 0;

        for(int i=0 ; i<arr.size() ; i++) {
            sum += populations[arr.get(i)];
        }
        return sum;
     }

    private static int sToI(String s) {
        return Integer.parseInt(s);
    }

    private static int[] sToIntArray(String s) {
        return Arrays.stream(s.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static void init(int[] input) {
        populations = new int[N+1];

        for(int i=1 ; i<=N ; i++) {
            populations[i] = input[i-1];
        }

        adjList = new HashSet[N+1];
        for(int i=1 ; i<=N ; i++) {
            adjList[i] = new HashSet<>();
        }
    }
}
