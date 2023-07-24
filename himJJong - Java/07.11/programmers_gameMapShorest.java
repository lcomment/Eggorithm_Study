import java.util.*;

public class programmers_gameMapShorest {
    static class Node{
        int x;
        int y;
        int time;
        Node(int x, int y, int time){
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int n;
    static int m;
    public int solution(int[][] maps) {
        int answer = 0;
        int min = Integer.MAX_VALUE;
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (maps[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    min = Math.min(min, bfs(i, j, maps));
                    if (min != Integer.MAX_VALUE) return min;
                }
            }
        }
        return -1;
    }
    static int bfs(int x, int y, int[][] maps){
        int flag = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x,y,1));
        while(!q.isEmpty()){
            Node tmp = q.poll();
            for(int i=0; i<4; i++){
                int moveX = dx[i] + tmp.x;
                int moveY = dy[i] + tmp.y;

                if(moveX == n-1 && moveY == m-1){
                    flag = tmp.time+1;
                    q.clear();
                    break;
                }
                if(moveX >=0 && moveY >= 0 && moveX < n && moveY <m && !visited[moveX][moveY] && maps[moveX][moveY] == 1){
                    visited[moveX][moveY] = true;
                    q.add(new Node(moveX, moveY, tmp.time+1));
                }
            }
        }
        if(flag !=0)    return flag;
        else    return -1;
    }
}
