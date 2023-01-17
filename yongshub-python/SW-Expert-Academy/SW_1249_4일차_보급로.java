import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] visited;
    static int[][] arr;
    static int N;
    static int answer;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(br.readLine());
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for(int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            answer = Integer.MAX_VALUE;
            arr = new int[N][N];
            visited = new int[N][N];

            for(int i = 0; i < N; i++) {
                String st = br.readLine();
                for(int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(String.valueOf(st.charAt(j)));
                    visited[i][j] = Integer.MAX_VALUE;
                }
            }
            bfs();
            System.out.printf("#%d %d\n", test_case, visited[N - 1][N - 1]);
        }
    }

    public static void bfs() {
        Queue<ArrayList<Integer>> queue = new LinkedList<>();
        queue.add(new ArrayList<>(Arrays.asList(0, 0)));
        visited[0][0] = 0;
        while(queue.size() > 0) {
            ArrayList<Integer> locations = queue.poll();
            int x = locations.remove(0);
            int y = locations.remove(0);
            for(int i = 0; i < 4; i++) {
                if(x + dx[i] < 0 || x + dx[i] >= N || y + dy[i] < 0 || y + dy[i] >= N) {
                    continue;
                }

                if(visited[x + dx[i]][y + dy[i]] > visited[x][y] + arr[x + dx[i]][y + dy[i]]) {
                    visited[x + dx[i]][y + dy[i]] = visited[x][y] + arr[x + dx[i]][y + dy[i]];
                    queue.add(new ArrayList<>(Arrays.asList(x + dx[i], y + dy[i])));
                }
            }
        }
    }
}