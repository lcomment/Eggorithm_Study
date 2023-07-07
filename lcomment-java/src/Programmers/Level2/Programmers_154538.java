package Programmers.Level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Programmers_154538 {
    public int solution(int x, int y, int n) {
        return bfs(x, y, n);
    }

    private int bfs(int goal, int start, int n) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start, 0});
        int[] dist = new int[start];
        Arrays.fill(dist, Integer.MAX_VALUE);

        while(!q.isEmpty()) {
            int[] now = q.poll();

            if(now[0] < 1) continue;

            if(now[0] == goal) {
                return now[1];
            }

            if(now[0] % 2 == 0 && now[1] + 1< dist[now[0] / 2]) {
                q.offer(new int[]{ now[0] / 2, now[1] + 1 });
            }
            if(now[0] % 3 == 0 && now[1] + 1< dist[now[0] / 3]) {
                q.offer(new int[]{ now[0] / 3, now[1] + 1 });
            }
            q.offer(new int[]{ now[0] - n, now[1] + 1});
        }
        return -1;
    }
}
