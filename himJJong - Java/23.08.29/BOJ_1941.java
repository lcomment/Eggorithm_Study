import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1941 {
    static int N = 5, res = 0, selected[];
    static char[][] map;
    static boolean visited[], adjVisited[];
    static Queue<Integer> q;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[N][N];
        selected = new int[7];
        visited = new boolean[25];

        for(int i=0; i<5; i++){
            map[i] = br.readLine().toCharArray();
        }

        find(0,0,0);
        System.out.println(res);
    }

    private static void find(int idx, int cnt, int cntS) {
        if(cnt == 7){
            if(cntS >= 4){
                if(chedkAdj())  res++;
                return;
            }
            return;
        }

        for(int i=idx; i<25; i++){
            visited[i] = true;
            selected[cnt] = i;
            if(map[i/5][i%5] == 'S')    {
                find(i+1, cnt+1, cntS+1);
            }
            else find(i+1, cnt+1, cntS);
            visited[i] = false;
        }
    }

    private static boolean chedkAdj() {
        int cnt = 1;
        adjVisited = new boolean[N*N];
        q = new LinkedList<>();
        // 임의 한 명 위치를 Queue에 넣고
        q.add(selected[0]);
        // 7명이 모두 인접해있는지 확인해보자.
        while(!q.isEmpty()) {
            int now = q.poll();
            adjVisited[now] = true;

            for (int d = 0; d < 4; d++) {
                int moveX = (now/N) + dx[d];
                int moveY = (now%N) + dy[d];
                // 범위를 벗어나면 pass
                if(moveX < 0 || moveY < 0 || moveX >= N || moveY >= N) continue;
                // 이미 확인한 애면 pass
                if(adjVisited[moveX*N+moveY]) continue;
                // 인접한 앤데 공주가 아니면 pass
                if(!visited[moveX*N+moveY]) continue;
                // 인접한 애가 같은 공주네?
                cnt++;
                adjVisited[moveX*N+moveY] = true;
                q.add(moveX*N+moveY);
            }
        }
        // 임의 한 명 이랑 인접한 공주가 모두 7명이 되면 true
        if(cnt == 7) return true;
        else return false;
    }
}
