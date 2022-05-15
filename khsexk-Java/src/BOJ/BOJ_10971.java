package BOJ;

import java.io.*;

public class BOJ_10971 {
	private static int N;
    private static int[][] map;
    private static boolean[] isVisited;
    private static int answer = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        isVisited = new boolean[N];
        
        for (int i = 0; i < N; i++) {
        	String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        for (int i = 0; i < N; i++) {
            isVisited[i] = true;
            dfs(0, i, i, 0, isVisited);
        }
        System.out.println(answer);
    }

    public static void dfs(int depth, int start, int back, int cost, boolean[] isVisited) { 
        if (depth == N - 1) {
            if (map[back][start] != 0)
                answer = Math.min(answer, cost + map[back][start]);
                
            return;
        }
        for (int i=0; i < N; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                if (map[back][i] != 0) {
                    dfs(depth + 1, start, i, cost + map[back][i], isVisited);
                }
                isVisited[i] = false;
            }
        } // for_i
    }
}
