import java.util.*;

class pro_gameMapShortest{
    static class Node{
        int x;
        int y;
        int move;
        Node(int x, int y, int move){
            this.x = x;
            this.y = y;
            this.move = move;
        }
    }
    static boolean[][] visited;
    static int row;
    static int col;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    public int solution(int[][] maps) {
        row = maps.length;
        col = maps[0].length;
        visited = new boolean[row][col];
        int answer = bfs(0,0,maps);
        return answer;
    }

    private static int bfs(int x, int y, int[][] maps){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x,y,1));

        while(!q.isEmpty()){
            Node tmp = q.poll();

            if(tmp.x == row-1 && tmp.y == col - 1){
                return tmp.move;
            }
            for(int i=0; i<4; i++){
                int moveX = dx[i] + tmp.x;
                int moveY = dy[i] + tmp.y;

                if(moveX <0 || moveX >= row || moveY < 0 || moveY >= col || visited[moveX][moveY] || maps[moveX][moveY] == 0)   {
                    continue;
                }

                visited[moveX][moveY] = true;
                q.add(new Node(moveX, moveY, tmp.move+1));
            }
        }

        return -1;
    }
}