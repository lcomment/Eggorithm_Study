import java.util.*;
import java.io.*;
import java.util.Scanner;


class Swea_longestDistance {
    static boolean[] visited;
    static int N;
    static int M;
    static List<Integer>[] list;
    static int max = 0;
    public static void main(String args[]) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());


            visited = new boolean[N+1];
            list = new ArrayList[N+1];
            for(int i=0; i<=N; i++) {
                list[i] = new ArrayList<>();
            }

            for(int i=0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                list[a].add(b);
                list[b].add(a);
            }

            for(int i=1; i<=N; i++) {
                visited = new boolean[N+1];
                dfs(i,1);
            }
            System.out.println("#" + test_case + " " + max);
            max = 0;
        }
    }
    static void dfs(int index, int sum) {
        visited[index] = true;
        max = Math.max(max, sum);
        for(int k : list[index]) {
            if(!visited[k]) {
                dfs(k, sum+1);
                visited[k] = false;
            }
        }

    }
}