import java.util.*;

class pro_network {
    static List<Integer>[] list;
    static boolean[] visited;
    static int answer = 0;
    public int solution(int n, int[][] computers) {

        list = new ArrayList[n+1];
        visited = new boolean[n+1];

        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=1; i<=computers.length; i++){
            for(int j=0; j<computers[0].length; j++){
                if(i==j+1)    continue;
                if(computers[i-1][j] == 1){
                    list[i].add(j+1);
                }
            }
        }

        for(int i=1; i<=computers.length; i++){
            dfs(i, i);
        }

        for(int i=1; i<=visited.length-1; i++){
            if(!visited[i]){
                answer++;
            }
        }
        return answer;
    }
    private static void dfs(int index, int n){
        if(!visited[n])  {
            for(int k : list[index]){
                if(n != k && !visited[k]){
                    visited[k] = true;
                    dfs(k, n);
                }
            }
        }
    }
}