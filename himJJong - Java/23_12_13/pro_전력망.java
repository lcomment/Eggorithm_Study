import java.util.*;

public class pro_전력망 {
    public static void main(String[] args) {
        int n = 9;
        int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
        System.out.println(Solution.solution(n, wires));
    }

    public static class Solution {
        static List<Integer>[] list;
        static boolean[] visited;
        static boolean[][] dup;
        static int left = 0;
        static int right = 0;
        public static int solution(int n, int[][] wires) {
            int answer = Integer.MAX_VALUE;
            list = new ArrayList[n+1];
            visited = new boolean[n+1];
            dup = new boolean[n+1][n+1];

            for(int i=1; i<=n; i++){
                list[i] = new ArrayList<>();
            }

            for(int i=0; i<wires.length ; i++){
                list[wires[i][0]].add(wires[i][1]);
                list[wires[i][1]].add(wires[i][0]);
            }

            for(int i=1; i<=n; i++){
                for(int k : list[i]){
                    if(!dup[i][k] && !dup[k][i]) {
                        dup[i][k] = true;
                        dup[k][i] = true;
                        Arrays.fill(visited,false);
                        visited[i] = true;
                        visited[k] = true;
                        dfs(i, visited, 0);
                        left = checkLeft(k);

                        Arrays.fill(visited,false);
                        visited[i] = true;
                        visited[k] = true;
                        dfs(k, visited, 0);
                        right = checkRight(i);

                        if (left + right == n) {
                            answer = Math.min(answer, Math.abs(right - left));
                        }
                    }
                }
            }
            return answer;
        }

        private static int checkRight(int right) {
            int result  = 0;
            for(int i=1; i<visited.length; i++){
                if(visited[i] && i != right)    result++;
            }
            return result;
        }

        private static int checkLeft(int left) {
            int result  = 0;
            for(int i=1; i<visited.length; i++){
                if(visited[i] && i != left)    result++;
            }
            return result;
        }

        private static void dfs(int vertex, boolean[] visited, int count){
            visited[vertex] = true;
            int sum = count+1;

            for(int k : list[vertex]){
                if(!visited[k]){
                    dfs(k, visited, sum);
                }
            }
        }
    }
}
