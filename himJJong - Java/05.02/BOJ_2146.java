import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2146 {
    static class Node{
        int val;
        int x;
        int y;
        int time;
        Node(int val, int x, int y, int time){
            this.val = val;
            this.x = x;
            this.y = y;
            this.time = time;

        }
    }
    static int length;
    static boolean[][] visitBfs;
    static int[][] data;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        length = Integer.parseInt(br.readLine());
        data = new int[length][length];
        visitBfs = new boolean[length][length];

        for(int i=0; i<length; i++){
            data[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int index = 1;
        for(int i=0; i<length; i++){
            for(int j=0; j<length; j++){
                if(!visitBfs[i][j] && data[i][j]==1){
                    initBfs(i,j,index);
                    index++;
                }
            }
        }

        for(int i=0; i<length; i++){
            for(int j=0; j<length; j++){
                if(data[i][j] != 0){
                    findIsland(i,j);
                }
            }
        }
        System.out.println(min);
    }

    private static void findIsland(int x, int y) {
        boolean[][] visited = new boolean[length][length];
        visited[x][y] = true;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(data[x][y],x,y,0));

        while(!q.isEmpty()){
            Node tmp = q.poll();
            for(int k=0;k<4; k++){
                int moveX = dx[k] + tmp.x;
                int moveY = dy[k] + tmp.y;

                if(moveY < length && moveX < length && moveX >=0 && moveY>=0 && !visited[moveX][moveY] && data[moveX][moveY] != tmp.val){
                    if(data[moveX][moveY] > 0){
                        min = Math.min(tmp.time,min);
                        q.clear();
                        break;
                    }
                    visited[moveX][moveY] = true;
                    q.add(new Node(tmp.val,moveX,moveY, tmp.time+1));
                }
            }
        }
    }

    private static void initBfs(int i, int j, int val) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(data[i][j],i,j,0));
        while(!q.isEmpty()){
            Node tmp = q.poll();
            data[tmp.x][tmp.y] = val;
            for(int k=0;k<4; k++){
                int moveX = dx[k] + tmp.x;
                int moveY = dy[k] + tmp.y;

                if(moveY < length && moveX < length && moveX >=0 && moveY>=0 && !visitBfs[moveX][moveY] && data[moveX][moveY] == 1){
                    visitBfs[moveX][moveY] = true;
                    data[moveX][moveY] = val;
                    q.add(new Node(val,moveX,moveY,0));
                }
            }
        }
    }
}
