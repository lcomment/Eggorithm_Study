package chapter2;

import java.util.*;
import java.io.*;
public class TypeInference {

    static int N, K;
    static int time;
    static boolean[] visited = new boolean[100001];
    static int[] parent = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if(N == K){
            sb.append(0).append("\n");
            sb.append(N).append("\n");
        }else {
            bfs(N);
            sb.append(time).append("\n");

            Stack<Integer> stack = new Stack<>();
            stack.add(K);
            int index = K;
            while (index != N) {
                stack.push(parent[index]);
                index = parent[index];
            }

            while (!stack.isEmpty()) {
                sb.append(stack.pop()).append(" ");
            }
        }
        System.out.println(sb);
    }

    static void bfs(int start) {
        time = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            // 만난 경우
            if(visited[K]) {
                return;
            }

            // 현재 q의 사이즈 만큼만 돌리기 - 시간 계산을 위해서
            for(int j = 0, size = q.size(); j < size; j++) {
                int now = q.poll();
                int next;

                // 다음에서 영역을 방문 처리
                // 다음의 부모를 현재로 설정
                next = now - 1;
                if(next >= 0 && !visited[next]) {
                    visited[next] = true;
                    parent[next] = now;
                    q.offer(next);
                }

                next = now + 1;
                if(next < 100001 && !visited[next]) {
                    visited[next] = true;
                    parent[next] = now;
                    q.offer(next);
                }

                next = now * 2;
                if(next < 100001 && !visited[next]) {
                    visited[next] = true;
                    parent[next] = now;
                    q.offer(next);
                }
            }
            time++;
        }
    }
}
