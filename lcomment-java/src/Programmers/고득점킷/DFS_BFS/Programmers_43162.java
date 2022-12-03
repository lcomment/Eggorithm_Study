package Programmers.고득점킷.DFS_BFS;

public class Programmers_43162 {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n]; // n 갯수만큼 boolean 배열을 만들고 모든 요소를 false로 초기화

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(computers, i, visited);
                answer++;
            }
        }
        return answer;
    }

    boolean[] dfs(int[][] computers, int i, boolean[] visited) {
        visited[i] = true;

        for (int j = 0; j < computers.length; j++) {
            if (i != j && computers[i][j] == 1 && visited[j] == false) {
                visited = dfs(computers, j, visited);
            }
        }
        return visited;
    }
}
